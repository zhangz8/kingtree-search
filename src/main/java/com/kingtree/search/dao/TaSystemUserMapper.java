package com.kingtree.search.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kingtree.search.entity.TaSystemUser;

public interface TaSystemUserMapper {
	int deleteByPrimaryKey(String uid);

	int insert(TaSystemUser record);

	int insertSelective(TaSystemUser record);

	TaSystemUser selectByPrimaryKey(String uid);

	int updateByPrimaryKeySelective(TaSystemUser record);

	int updateByPrimaryKey(TaSystemUser record);

	List<TaSystemUser> selectWithPage(@Param("start") int start, @Param("length") int length);
}