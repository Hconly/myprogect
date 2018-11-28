package org.lq.power.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.lq.base.util.DBUtil;
import org.lq.power.dao.RoleInAnthortyDao;

public class RoleInAnthortyDaoImpl implements RoleInAnthortyDao {

	private QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
	
	@Override
	public int save(int rid, int aid)throws Exception {
		return qr.update("insert into role_anthority_info values(?,?)",rid,aid);
	}

	@Override
	public List<Object> getAnthortyIds(int roleid)throws Exception {
		List<Object> list= qr.query("select anthorty_id from role_anthority_info where role_id = ?", new ColumnListHandler<>(),roleid);
		return list; 
	}

	@Override
	public int deleteByRoleId(int roleid) {
		int num =0;
		
		try {
			num = qr.update("delete from role_anthority_info where role_id=?",roleid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return num;
	}

}
