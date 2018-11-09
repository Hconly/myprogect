package org.lq.question.service.impl;

import org.lq.question.dao.RadOptionsDao;
import org.lq.question.dao.RmdQuestionsDao;
import org.lq.question.dao.impl.RadOptionsDaoImpl;
import org.lq.question.dao.impl.RmdQuestionsDaoImpl;
import org.lq.question.entity.RadOptions;
import org.lq.question.entity.RmdQuestions;
import org.lq.question.service.RmdQuestionsService;

public class RmdQuestionsServiceImpl implements RmdQuestionsService {
	private RmdQuestionsDao questionsDao = new RmdQuestionsDaoImpl();
	private RadOptionsDao optionsDao = new RadOptionsDaoImpl();

	@Override
	public boolean addQuestions(RmdQuestions questions, RadOptions options) {
		
		int num =questionsDao.save(questions);
		if(num >0 && options!=null) {
			int id = questionsDao.getCuurVal();
			//将题干的主键赋值给选项表
			options.setRad_id(id);
			num =optionsDao.save(options);
		}
		
		return num > 0;
	}

}
