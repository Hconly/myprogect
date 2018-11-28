package org.lq.power.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lq.power.dao.RoleInfoDao;
import org.lq.power.entity.RoleInfo;

public class RoleInfoDaoImpl implements RoleInfoDao {

	@Override
	public int deleteByPrimaryKey(Integer id) throws Exception {
		return getQueryRunner().update("delete from role_info where role_id = ?",id);
	}

	@Override
	public int insert(RoleInfo t) throws Exception {
		String sql ="insert into role_info\n" +
						"   ( role_name, role_desc, role_state)\n" + 
						" values\n" + 
						"   ( ?, ?, ?)";
		return getQueryRunner().update(sql,t.getRole_name(),t.getRole_desc(),t.getRole_state());
	}

	@Override
	public RoleInfo selectByPrimaryKey(Integer id) throws Exception {
		return getQueryRunner().query("select * from role_info where role_id=?",new BeanHandler<>(RoleInfo.class),id);
	}

	@Override
	public int updateByPrimaryKey(RoleInfo t) throws Exception {
		String sql = 
				"update role_info\n" +
						"    set\n" + 
						"        role_name = ?,\n" + 
						"        role_desc = ?,\n" + 
						"        role_state = ?\n" + 
						"  where role_id = ?\n" + 
						"";
		return getQueryRunner().update(sql,t.getRole_name(),t.getRole_desc(),t.getRole_state(),t.getRole_id());
	}

	@Override
	public List<RoleInfo> findAll() throws Exception {
		return getQueryRunner().query("select * from role_info", new BeanListHandler<>(RoleInfo.class));
	}

	@Override
	public List<RoleInfo> findPage(int pageIndex, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RoleInfo> likeRoleByName(String name) throws Exception{
		return getQueryRunner().query("select * from role_info where role_name like ?", new BeanListHandler<>(RoleInfo.class),"%"+name+"%");
	}

}
