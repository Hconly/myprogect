package org.lq.power.dao;

import java.util.List;

public interface RoleInAnthortyDao {
	
	/**
	 * 添加权限和角色关系表
	 * @param rid
	 * @param aid
	 * @return
	 */
	int save(int rid,int aid) throws Exception;
	
	List<Object> getAnthortyIds(int roleid) throws Exception;
	
	int deleteByRoleId(int roleid);

}
