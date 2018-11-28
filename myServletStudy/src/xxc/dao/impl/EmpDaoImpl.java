package xxc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import xxc.dao.EmpDao;
import xxc.entity.Emp;
import xxc.util.DBUtil;

public class EmpDaoImpl implements EmpDao{
	QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
	@Override
	public List<Emp> findAllEmp() {
		String sql = "select * from Emp";
		List<Emp> list = null;
		try {
			list = qr.query(sql,new BeanListHandler<>(Emp.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int delteEmp(int id) {
		int num = 0;
		String sql = "delete from emp where empno=?";
		try {
			num = qr.update(sql,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

}
