package test.dao.impl;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import test.dao.EmpDao;
import test.entity.Emp;
import test.util.DBUtil;

public class EmpDaoImpl implements EmpDao{

	private QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
	
	//Æ´Ð´·ÖÒ³µÄSQLÓï¾ä
	
	@Override
	public List<Emp> pageList(int pageIndex, int pageSize) {
		String sql = "select * from ("
				+ "select rownum r,e.* from "
				+ "(select * from emp order by empno) e "
				+ " where rownum <= ? )"
				+ "where r > ?";
		
		int max = pageIndex * pageSize;
		int min = (pageIndex-1)*pageSize;
		List<Emp>  list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Emp.class),max,min);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Emp> pageList(int pageIndex, int pageSize, String name) {
		String sql = "select * from ("
				+ "select rownum r,e.* from "
				+ "(select * from emp where ename like ? order by empno ) e "
				+ " where rownum <= ? )"
				+ "where r > ?";
		
		int max = pageIndex * pageSize;
		int min = (pageIndex-1)*pageSize;
		List<Emp>  list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Emp.class),"%"+name+"%",max,min);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override@Test
	public int getCount() {
		String sql = "select count(1) from emp";
		
		int count = 0;
		try {
			BigDecimal decimal = qr.query(sql, new ScalarHandler<>());
			count = decimal.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
