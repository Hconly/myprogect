package org.lq.base.dao;

import org.lq.power.dao.AnthortyInfoDao;
import org.lq.power.dao.RoleInfoDao;
import org.lq.power.dao.StaffInfoDao;
import org.lq.power.dao.impl.AnthortyInfoDaoImpl;
import org.lq.power.dao.impl.RoleInfoDaoImpl;

public interface BaseDaoFactory {
	/**
	 * ��ȡȨ�޽ӿ�
	 * @return
	 */
	default AnthortyInfoDao getAnthortyInfoDao() {
		return new AnthortyInfoDaoImpl();
	}
	/**
	 * ��ȡ��ɫ�ӿ�
	 * @return
	 */
	default RoleInfoDao getRoleInfoDao() {
		return new RoleInfoDaoImpl();
	}
	/**
	 * ��ȡԱ���ӿ�
	 * @return
	 */
	default StaffInfoDao getStaffInfoDao() {
		return null;
	}
	
//	default BaseDao<T> getBaseDao(String name){
//		switch (name) {
//		case "anthorty":		
//			return (BaseDao<T>) new AnthortyInfoDaoImpl();
//			break;
//
//		default:
//			break;
//		}
//	}
}
