package org.lq.power.service.impl;

import java.util.List;

import org.lq.power.entity.RoleInfo;
import org.lq.power.service.RoleService;

import lombok.extern.log4j.Log4j;
@Log4j
public class RoleServiceImpl implements RoleService {

	@Override
	public List<RoleInfo> likeRoleByName(String name) {
		List<RoleInfo> list = null;
		 try {
			 log.debug("执行角色模糊查询:"+name);
			list = getRoleInfoDao().likeRoleByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<RoleInfo> findAll() {
		List<RoleInfo> list = null;
		 try {
			 log.debug("执行角色查询");
			list = getRoleInfoDao().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean deleteRoleById(int id) {
		boolean bool = false;
		//TODO 角色删除需要对中间表进行维护管理
		try {
			bool = getRoleInfoDao().deleteByPrimaryKey(id)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bool;
	}

	@Override
	public RoleInfo getRoleById(int id) {
		RoleInfo info = null;
		try {
			info = getRoleInfoDao().selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public boolean saveRole(RoleInfo role) {
		boolean bool = false;
		try {
			bool = getRoleInfoDao().insert(role)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return bool;
	}

	@Override
	public boolean update(RoleInfo info) {
		boolean bool = false;
		try {
			bool = getRoleInfoDao().updateByPrimaryKey(info)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return bool;
	}

	
	
}
