package org.lq.base.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.lq.base.util.DBUtil;

public interface BaseDao<T> {
	/*
	 * 接口默认方法
	 */
	default QueryRunner getQueryRunner() {
		return new QueryRunner(DBUtil.getDataSource());
	}
	
	
	int deleteByPrimaryKey(Integer id) throws Exception;

    int insert(T t) throws Exception;

    T selectByPrimaryKey(Integer id)throws Exception;

    int updateByPrimaryKey(T t)throws Exception;
    
    List<T> findAll()throws Exception;
    
    List<T> findPage(int pageIndex,int pageSize)throws Exception;
    
    int getCount()throws Exception;

}
