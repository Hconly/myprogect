package org.lq.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lq.dao.DeptDao;
import org.lq.entity.Dept;
import org.lq.util.DBUtil;

public class DeptDaoImpl implements DeptDao {
	private QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
	@Override
	public int insert(Dept record) {
		int num = 0;
		String sql = "insert into dept values(dept_seq.nextval,?,?)";
		try {
			num = qr.update(sql,record.getDname(),record.getLoc());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int update(Dept dept) {
		int num = 0;
		String sql = "update set dept dname =? ,loc=? where deptno = ?";
		try {
			num = qr.update(sql,dept.getDname(),dept.getLoc(),dept.getDeptno());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int delete(int id) {
		int num = 0;
		String sql = "delete from dept where deptno = ?";
		try {
			num = qr.update(sql,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public Dept getDept(int id) {
		Dept dept = null;
		try {
			dept = qr.query("select * from dept where deptno =?", new BeanHandler<>(Dept.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dept;
	}

	@Override
	public List<Dept> findAll(int pageIndex, int pageSize, String dname) {
		
		String sql = "select * from ( "
				+ "select rownum r,d.* from ("
				+ "select * from dept where dname like ? order by deptno"
				+ ") d where rownum <= ? )"
				+ "where r > ?";
		int min = (pageIndex-1)*pageSize;
		int max = pageIndex * pageSize;
		List<Dept> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Dept.class),"%"+dname+"%",max,min);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getCount(String dname) {
		String sql = "select count(1) from dept where dname like ?";
		int num = 0;
		try {
			BigDecimal decimal = qr.query(sql, new ScalarHandler<>(),"%"+dname+"%");
			num = decimal.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

}















