package org.lq.question.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.lq.question.util.DBUtil;

public class DBUtilTest {

	@Test
	public void testGetDataSource() {
		try {
			System.out.println(DBUtil.getDataSource().getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
