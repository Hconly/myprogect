package org.lq.power.service;

import java.util.List;

public interface RoleInAnthortyService {
	
	/**
	 * ���Ȩ�޺ͽ�ɫ��ϵ��
	 * @param rid
	 * @param aid
	 * @return
	 */
	boolean save(String rid,String[] aid);
	
	List<Integer> getAnthorthIds(int roleid);

}
