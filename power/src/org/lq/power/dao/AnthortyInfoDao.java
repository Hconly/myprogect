package org.lq.power.dao;

import java.util.List;

import org.lq.base.dao.BaseDao;
import org.lq.power.entity.AnthortyInfo;

public interface AnthortyInfoDao extends BaseDao<AnthortyInfo>{
	
	/**
	 * 获取所有父级节点
	 * @return
	 */
	public List<AnthortyInfo> getParent() throws Exception;
	

}