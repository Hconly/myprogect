package org.lq.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lq.dao.EmpDao;
import org.lq.entity.Emp;
import org.lq.util.DBUtil;

public class EmpDaoImpl implements EmpDao {
    QueryRunner qr  = new QueryRunner(DBUtil.getDataSource());
     
	@Override
	public int deleteByPrimaryKey(int empno) {
		int num=0;
		String sql= "delete from emp where empno=?";
		try {
			num= qr.update(sql,empno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int insert(Emp record) {
		int num = 0;
		String sql = "insert into emp\r\n" + 
				"  (ename, job, mgr, hiredate, sal, comm, dno)\r\n" + 
				"values\r\n" + 
				"  (emp_id.nextval,?,?,?,?,?,?,?)";
		try {
			num = qr.update(sql,record.getEname(),record.getJob(),record.getMgr(),record.getHiredate()
					,record.getSal(),record.getComm(),record.getDno());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public Emp selectByPrimaryKey(int empno) {
		Emp emp = null;
		String sql = "select * from emp where empno = ?";
		try {
			emp = qr.query(sql, new BeanHandler<>(Emp.class),empno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public int updateByPrimaryKey(Emp record) {
		int num  = 0;
		String sql = "update emp\r\n" + 
				"   set \r\n" + 
				"       ename = ?,\r\n" + 
				"       job = ?,\r\n" + 
				"       mgr = ?,\r\n" + 
				"       hiredate = ?,\r\n" + 
				"       sal = ?,\r\n" + 
				"       comm = ?,\r\n" + 
				"       dno = ?\r\n" + 
				" where empno = ?";
		try {
			num = qr.update(sql,record.getEname(),record.getJob(),record.getMgr(),record.getHiredate()
						,record.getSal(),record.getComm(),record.getDno());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Emp> findPage(int pageIndex, int pageSize, String ename) {
		
		List<Emp> list = null;
		String sql = "select * from("
				+ "select rownum r,e.*("
				+ "select * from emp where ename like ? order by empno"
				+ ") e  where rownum <= ?"
				+ ") where r > ?";
		int max = pageIndex * pageSize;
		int min = (pageIndex-1) * pageSize;
		return list;
		
	}

	@Override
	public int getCount(String ename) {
		String sql = "select count(1) from emp where ename like ?";
		int num = 0;
		try {
			BigDecimal decimal = qr.query(sql, new ScalarHandler<>(),"%"+ename+"%");
			num = decimal.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

}
