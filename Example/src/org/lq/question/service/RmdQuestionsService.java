package org.lq.question.service;

import org.lq.question.entity.RadOptions;
import org.lq.question.entity.RmdQuestions;

public interface RmdQuestionsService {
	/**
	 * 添加实体
	 * @param questions 题干
	 * @param options 选项
	 * @return
	 */
	public boolean addQuestions(RmdQuestions questions,RadOptions options);

}
