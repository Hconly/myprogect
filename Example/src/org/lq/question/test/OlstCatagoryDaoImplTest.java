package org.lq.question.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.lq.question.dao.OlstCatagoryDao;
import org.lq.question.dao.impl.OlstCatagoryDaoImpl;
import org.lq.question.entity.OlstCatagory;

public class OlstCatagoryDaoImplTest {

	@Test
	public void testSave() {
		OlstCatagoryDao dao =new OlstCatagoryDaoImpl();
		int num = dao.save(OlstCatagory
				.builder()
				.content("Java»ù´¡")
				.pid(0)
				.build());
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
		List<OlstCatagory> list = new OlstCatagoryDaoImpl().findAll();
		System.out.println(list);
	}

	@Test
	public void testLikeAll() {
		List<OlstCatagory> list = new OlstCatagoryDaoImpl().likeAll("J");
		System.out.println(list);
	}

}
