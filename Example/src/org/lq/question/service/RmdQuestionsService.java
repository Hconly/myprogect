package org.lq.question.service;

import org.lq.question.entity.RadOptions;
import org.lq.question.entity.RmdQuestions;

public interface RmdQuestionsService {
	/**
	 * ���ʵ��
	 * @param questions ���
	 * @param options ѡ��
	 * @return
	 */
	public boolean addQuestions(RmdQuestions questions,RadOptions options);

}
