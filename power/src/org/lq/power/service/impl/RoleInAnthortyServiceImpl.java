package org.lq.power.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.lq.base.util.CastUtil;
import org.lq.power.dao.RoleInAnthortyDao;
import org.lq.power.dao.impl.RoleInAnthortyDaoImpl;
import org.lq.power.service.RoleInAnthortyService;

public class RoleInAnthortyServiceImpl implements RoleInAnthortyService {

	RoleInAnthortyDao anthortyDao = new RoleInAnthortyDaoImpl();
	@Override
	public boolean save(String rid,String[] aid) {
		int roleId= CastUtil.castInt(rid);
		boolean bool = false;
		//��ɾ����ǰ��ɫ���е�����Ȩ����Ϣ
		anthortyDao.deleteByRoleId(roleId);
		try {
			//ѭ����Ȩ����Ϣ�ͽ�ɫ��Ϣ��ӵ��м����
			for (String id : aid) {
				anthortyDao.save(roleId, CastUtil.castInt(id));
			}
			bool = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bool;
	}

	@Override
	public List<Integer> getAnthorthIds(int roleid) {
		List<Integer> list = new ArrayList<>();
		
		try {
			//��ȡ����Ȩ��id,ѭ��������ת����Integer����
			for(Object id : anthortyDao.getAnthortyIds(roleid)) {
				list.add(CastUtil.castInt(id));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
