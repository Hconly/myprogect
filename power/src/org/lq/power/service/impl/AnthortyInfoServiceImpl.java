package org.lq.power.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.lq.base.util.CastUtil;
import org.lq.power.entity.AnthortyInfo;
import org.lq.power.service.AnthortyInfoService;

import lombok.extern.log4j.Log4j;
@Log4j
public class AnthortyInfoServiceImpl implements AnthortyInfoService {

	
	@Override
	public boolean addAnthortyInfo(AnthortyInfo info) {
		boolean bool=false;
		try {
			 bool =  getAnthortyInfoDao().insert(info) > 0;
			log.debug("权限添加执行结果:"+( bool ? "成功" : "失败"));
		} catch (Exception e) {
			log.error("权限添加异常",e);
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public List<AnthortyInfo> findAll() {
		List<AnthortyInfo> list = null;
		try {
			list = getAnthortyInfoDao().findAll();
		} catch (Exception e) {
			log.error("权限查询异常:",e);
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<AnthortyInfo> findParemt() {
		List<AnthortyInfo> list = null;
		try {
			list = getAnthortyInfoDao().getParent();
		} catch (Exception e) {
			log.error("权限查询父节点异常:",e);
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public AnthortyInfo getAnthortyInfoById(int id) {
		log.debug("权限ID查询:"+id);
		AnthortyInfo info = null;
		try {
			info =getAnthortyInfoDao().selectByPrimaryKey(id);
			//通过当前节点的pid查询父级对象
			info.setParent(getAnthortyInfoDao().selectByPrimaryKey(info.getAnthorty_pid()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public boolean deleteAnthortyById(int castInt) {
		boolean bool = false;
		log.debug("删除权限:"+castInt);
		try {
			//判断下面是否有子节点   获取所有节点,判断pid是否等于当前删除的id
			//通过id查询字节点数量
			List<AnthortyInfo> list = findAll();
			for (AnthortyInfo anthortyInfo : list) {
				//代表当前下面有子节点
				if(castInt == anthortyInfo.getAnthorty_pid()) {
					return false;
				}
			}
			
			int num =getAnthortyInfoDao().deleteByPrimaryKey(castInt);
			bool = num>0;
			log.debug("删除权限结果:"+num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bool;
	}

	@Override
	public List<AnthortyInfo> getParentInChild(String roleid) {
		//查询所有权限列表
		List<AnthortyInfo> allList = findAll();
		//查询所有父权限列表
		List<AnthortyInfo> parents = findParemt();
		//获取当前角色拥有的权限编号
		List<Integer> aids = new RoleInAnthortyServiceImpl().getAnthorthIds(CastUtil.castInt(roleid));
		//循环当前权限编号
		for (Integer aid : aids) {
			//如果当前父权限列表中的对象等于当前就是已有的权限编号为当前权限对象的checked属性赋值
			for (AnthortyInfo parent : parents) {
				// 因为使用的Integer数据类型,如果超过127将无法比较,需要转换成int基本数据类型
				if(parent.getAnthorty_id().intValue() == aid.intValue()) {
					//如果当前权限的编号等于就是拥有的权限编号就把checked属性设置成true,在页面展示使用
					parent.setChecked(true);
				}
			}
			//下面对所有子节点处理,同上
			for (AnthortyInfo child : allList) {
				if(child.getAnthorty_id().intValue() == aid.intValue()) {
					 child.setChecked(true);
				}
			}
			
		}
		
		//创建父子关系 循环所有父节点和子节点
		for (AnthortyInfo parent : parents) {
			for (AnthortyInfo child : allList) {
				//如果当前子节点的父id等父权限对象中的自身id就代表当前对象是父权限对象的子菜单,添加到子菜单集合中
				if(child.getAnthorty_pid() == parent.getAnthorty_id()) {
					parent.getChilds().add(child);
				}
				
			}
			
		}
		
		
		
		return parents;
	}
	
	
	
	
}
