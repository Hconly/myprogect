package org.lq.question.dao;

import org.lq.question.entity.RmdQuestions;

public interface RmdQuestionsDao extends BaseDao<RmdQuestions> {
	/**
	 * ��ȡ��ǰ��ӵ�����ֵ
	 * @return
	 */
	public int getCuurVal();

}
