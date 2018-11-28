package org.lq.power.dao;

import java.util.List;

import org.lq.base.dao.BaseDao;
import org.lq.power.entity.RoleInfo;

public interface RoleInfoDao extends BaseDao<RoleInfo> {
	
	public List<RoleInfo> likeRoleByName(String name) throws Exception;
	
}