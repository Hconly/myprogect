package org.lq.power.service;

import java.util.List;

public interface RoleInAnthortyService {
	
	/**
	 * 添加权限和角色关系表
	 * @param rid
	 * @param aid
	 * @return
	 */
	boolean save(String rid,String[] aid);
	
	List<Integer> getAnthorthIds(int roleid);

}
