package com.kingtree.search.controller;

import java.io.StringReader;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kingtree.search.dao.TaSystemUserMapper;
import com.kingtree.search.entity.TaSystemUser;

@Controller
public class IndexController {

	@Resource
	private TaSystemUserMapper taSystemUserMapper;

	private Directory dir;
	private final static String INDEX_PATH = "D:/zhangz/lucene";

	@ResponseBody
	@RequestMapping("/index")
	public void index(HttpServletResponse response) throws Exception {
		List<TaSystemUser> users = taSystemUserMapper.selectWithPage(0, Integer.MAX_VALUE);
		if (users != null) {
			index(INDEX_PATH, users);
		}
	}

	@ResponseBody
	@RequestMapping("/search")
	public Map<String, Object> search(HttpServletResponse response, String q) throws Exception {
		Map<String, Object> data = new HashMap<>();
		Directory dir = FSDirectory.open(Paths.get(INDEX_PATH));
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher is = new IndexSearcher(reader);
		// Analyzer analyzer=new StandardAnalyzer(); // 标准分词器
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
		QueryParser parser = new QueryParser("userName", analyzer);
		Query query = parser.parse(q);
		long start = System.currentTimeMillis();
		TopDocs hits = is.search(query, Integer.MAX_VALUE);
		long end = System.currentTimeMillis();
		System.out.println("匹配 " + q + " ，总共花费" + (end - start) + "毫秒" + "查询到" + hits.totalHits + "个记录");

		QueryScorer scorer = new QueryScorer(query);
		Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
		SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color='red'>", "</font></b>");
		Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
		highlighter.setTextFragmenter(fragmenter);
		for (ScoreDoc scoreDoc : hits.scoreDocs) {
			Document doc = is.doc(scoreDoc.doc);
			System.out.println(doc.get("userId"));
			System.out.println(doc.get("userName"));
			System.out.println(doc.get("url"));
			// String desc = doc.get("url");
			// if (desc != null) {
			// TokenStream tokenStream = analyzer.tokenStream("userName", new
			// StringReader(desc));
			// System.out.println(highlighter.getBestFragment(tokenStream,
			// desc));
			// }
		}
		reader.close();
		return data;
	}

	/**
	 * 获取IndexWriter实例
	 * 
	 * @return
	 * @throws Exception
	 */
	private IndexWriter getWriter() throws Exception {
		// Analyzer analyzer=new StandardAnalyzer(); // 标准分词器
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
		IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
		IndexWriter writer = new IndexWriter(dir, iwc);
		return writer;
	}

	/**
	 * 生成索引
	 * 
	 * @param indexDir
	 * @throws Exception
	 */
	private void index(String indexDir, List<TaSystemUser> users) throws Exception {
		dir = FSDirectory.open(Paths.get(indexDir));
		IndexWriter writer = getWriter();
		for (TaSystemUser item : users) {
			Document doc = new Document();
			doc.add(new StringField("userId", item.getUid(), Field.Store.YES));
			doc.add(new TextField("userName", item.getUsername(), Field.Store.YES));
			doc.add(new TextField("mobile", item.getMobile(), Field.Store.YES));
			doc.add(new StringField("url", "http://item.showjoy.net/" + item.getUid() + ".html", Field.Store.YES));
			writer.addDocument(doc);
		}
		writer.close();
	}
}
