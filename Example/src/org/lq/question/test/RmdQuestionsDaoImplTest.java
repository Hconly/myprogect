package org.lq.question.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.lq.question.dao.RmdQuestionsDao;
import org.lq.question.dao.impl.RmdQuestionsDaoImpl;
import org.lq.question.entity.RmdQuestions;

public class RmdQuestionsDaoImplTest {

	@Test
	public void testSave() {
		RmdQuestionsDao dao = new RmdQuestionsDaoImpl();
		int num =dao.save(RmdQuestions.builder().descrpt("A").correct("A").quest_ctgr(13).quest_type(1).question("dsad").build());
		System.out.println(num);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testLikeAll() {
		fail("Not yet implemented");
	}

}
