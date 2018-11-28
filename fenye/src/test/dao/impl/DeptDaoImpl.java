package test.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import test.dao.DeptDao;
import test.entity.Dept;
import test.entity.Emp;
import test.util.DBUtil;

public class DeptDaoImpl implements DeptDao{
	private QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
	
	@Override
	public List<Dept> pageList(int pageIndex, int pageSize) {
		List<Dept> list = null;
		String sql = "String sql = \"select * from (\"\r\n" + 
				"				+ \"select rownum r,e.* from \"\r\n" + 
				"				+ \"(select * from dept order by deptno) e \"\r\n" + 
				"				+ \" where rownum <= ? )\"\r\n" + 
				"				+ \"where r > ?\";";
		int max = pageIndex * pageSize;
		int min = (pageIndex-1)*pageSize;
		try {
			list = qr.query(sql,new BeanListHandler<>(Dept.class),min,max);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Dept> pageList(int pageIndex, int pageSize, String name) {
		String sql = "select * from ("
				+ "select rownum r,e.* from "
				+ "(select * from dept where dname like ? order by deptno ) e "
				+ " where rownum <= ? )"
				+ "where r > ?";
		
		int max = pageIndex * pageSize;
		int min = (pageIndex-1)*pageSize;
		List<Dept>  list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Dept.class),"%"+name+"%",max,min);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int getCount() {
		String sql = "select count(1) from dept";
		
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
