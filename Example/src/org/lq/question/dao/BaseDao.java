package org.lq.question.dao;

import java.util.List;

public interface BaseDao<T> {
	/**
	 * Ìí¼Ó
	 * @param t
	 * @return
	 */
	int save(T t);
	
	int update(T t);
	
	int delete(int no);
	
	T findById(int no);
	
	List<T> findAll();
	
	List<T> likeAll(String txt);
	
		
	
}
