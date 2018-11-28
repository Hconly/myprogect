package org.lq.power.service;

import java.util.List;

import org.lq.base.dao.BaseDaoFactory;
import org.lq.power.entity.RoleInfo;

public interface RoleService extends BaseDaoFactory{

	public List<RoleInfo> likeRoleByName(String name);
	public List<RoleInfo> findAll();
	public boolean deleteRoleById(int id);
	RoleInfo getRoleById(int id);
	boolean saveRole(RoleInfo role);
	public boolean update(RoleInfo info);
	
}
