package org.lq.question.dao;

import org.lq.question.entity.RmdQuestions;

public interface RmdQuestionsDao extends BaseDao<RmdQuestions> {
	/**
	 * 获取当前添加的主键值
	 * @return
	 */
	public int getCuurVal();

}
