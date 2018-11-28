package org.lq.base.dao;

import org.lq.power.dao.AnthortyInfoDao;
import org.lq.power.dao.RoleInfoDao;
import org.lq.power.dao.StaffInfoDao;
import org.lq.power.dao.impl.AnthortyInfoDaoImpl;
import org.lq.power.dao.impl.RoleInfoDaoImpl;

public interface BaseDaoFactory {
	/**
	 * 获取权限接口
	 * @return
	 */
	default AnthortyInfoDao getAnthortyInfoDao() {
		return new AnthortyInfoDaoImpl();
	}
	/**
	 * 获取角色接口
	 * @return
	 */
	default RoleInfoDao getRoleInfoDao() {
		return new RoleInfoDaoImpl();
	}
	/**
	 * 获取员工接口
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
