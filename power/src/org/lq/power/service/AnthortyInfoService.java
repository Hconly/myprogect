package org.lq.power.service;

import java.util.List;

import org.lq.base.dao.BaseDaoFactory;
import org.lq.power.entity.AnthortyInfo;

public interface AnthortyInfoService extends BaseDaoFactory {
	
	boolean addAnthortyInfo(AnthortyInfo info);
		
	List<AnthortyInfo> findAll();
	
	List<AnthortyInfo> findParemt();
	
	AnthortyInfo getAnthortyInfoById(int id);

	boolean deleteAnthortyById(int castInt);
	
	
	List<AnthortyInfo> getParentInChild(String roleId);
}
