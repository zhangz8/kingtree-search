package com.kingtree.search.dao;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kingtree.search.entity.TaSystemUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mvc.xml")
public class TaSystemUserDaoTest extends AbstractJUnit4SpringContextTests {

	@Resource
	private TaSystemUserMapper taSystemUserMapper;

	@Test
	public void testSelect() {
		TaSystemUser user = new TaSystemUser();
		Assert.assertEquals(1, taSystemUserMapper.insert(user));
	}

}
