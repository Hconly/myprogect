package org.lq.power.dao;

import java.util.List;

public interface RoleInAnthortyDao {
	
	/**
	 * ���Ȩ�޺ͽ�ɫ��ϵ��
	 * @param rid
	 * @param aid
	 * @return
	 */
	int save(int rid,int aid) throws Exception;
	
	List<Object> getAnthortyIds(int roleid) throws Exception;
	
	int deleteByRoleId(int roleid);

}
