package xxc.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import xxc.dao.EmpDao;
import xxc.entity.Dept;
import xxc.entity.Emp;
import xxc.util.DBUtil;

public class EmpDaoImpl implements EmpDao{

	//获取数据源
	QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
	
	@Override
	public int insert(Emp d) {
		int num = 0;
		String sql = "insert into emp\r\n" + 
				"  (empno,ename, job, mgr, hiredate, sal, comm, deptno)\r\n" + 
				"values\r\n" + 
				"  (EMP_SEQ.nextval,?,?,?,?,?,?,?)";
		System.out.println(sql);
		try {
			num = qr.update(sql,d.getEname(),d.getJob(),d.getMgr(),d.getHiredate(),d.getSal(),d.getComm(),d.getDeptno());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int update(Emp d) {
		int num = 0;
		String sql = "update emp\r\n" + 
				"   set ename = ?,\r\n" + 
				"       job = ?,\r\n" + 
				"       mgr = ?,\r\n" + 
				"       hiredate = ?,\r\n" + 
				"       sal = ?,\r\n" + 
				"       comm = ?,\r\n" + 
				"       deptno = ?\r\n" + 
				" where empno = ?";
		try {
			num = qr.update(sql,d.getEname(),d.getJob(),d.getMgr(),d.getHiredate(),d.getSal(),d.getComm(),d.getDeptno(),d.getEmpno());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int delete(int id) {
		int num = 0;
		String sql = "delete from emp where empno=?";
		try {
			num = qr.update(sql,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public Emp getEmp(int id) {
		Emp emp = null;
		try {
			emp = qr.query("select * from emp where empno =?", new BeanHandler<>(Emp.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public List<Emp> findAll(int pageIndex, int pageSize, String ename) {
		String sql = "select * from ( "
				+ "select rownum r,d.* from ("
				+ "select * from emp where ename like ? order by empno"
				+ ") d where rownum <= ? )"
				+ "where r > ?";
		int min = (pageIndex-1)*pageSize;
		int max = pageIndex * pageSize;
		List<Emp> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Emp.class),"%"+ename+"%",max,min);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
