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
			log.debug("Ȩ�����ִ�н��:"+( bool ? "�ɹ�" : "ʧ��"));
		} catch (Exception e) {
			log.error("Ȩ������쳣",e);
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
			log.error("Ȩ�޲�ѯ�쳣:",e);
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
			log.error("Ȩ�޲�ѯ���ڵ��쳣:",e);
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public AnthortyInfo getAnthortyInfoById(int id) {
		log.debug("Ȩ��ID��ѯ:"+id);
		AnthortyInfo info = null;
		try {
			info =getAnthortyInfoDao().selectByPrimaryKey(id);
			//ͨ����ǰ�ڵ��pid��ѯ��������
			info.setParent(getAnthortyInfoDao().selectByPrimaryKey(info.getAnthorty_pid()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public boolean deleteAnthortyById(int castInt) {
		boolean bool = false;
		log.debug("ɾ��Ȩ��:"+castInt);
		try {
			//�ж������Ƿ����ӽڵ�   ��ȡ���нڵ�,�ж�pid�Ƿ���ڵ�ǰɾ����id
			//ͨ��id��ѯ�ֽڵ�����
			List<AnthortyInfo> list = findAll();
			for (AnthortyInfo anthortyInfo : list) {
				//����ǰ�������ӽڵ�
				if(castInt == anthortyInfo.getAnthorty_pid()) {
					return false;
				}
			}
			
			int num =getAnthortyInfoDao().deleteByPrimaryKey(castInt);
			bool = num>0;
			log.debug("ɾ��Ȩ�޽��:"+num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bool;
	}

	@Override
	public List<AnthortyInfo> getParentInChild(String roleid) {
		//��ѯ����Ȩ���б�
		List<AnthortyInfo> allList = findAll();
		//��ѯ���и�Ȩ���б�
		List<AnthortyInfo> parents = findParemt();
		//��ȡ��ǰ��ɫӵ�е�Ȩ�ޱ��
		List<Integer> aids = new RoleInAnthortyServiceImpl().getAnthorthIds(CastUtil.castInt(roleid));
		//ѭ����ǰȨ�ޱ��
		for (Integer aid : aids) {
			//�����ǰ��Ȩ���б��еĶ�����ڵ�ǰ�������е�Ȩ�ޱ��Ϊ��ǰȨ�޶����checked���Ը�ֵ
			for (AnthortyInfo parent : parents) {
				// ��Ϊʹ�õ�Integer��������,�������127���޷��Ƚ�,��Ҫת����int������������
				if(parent.getAnthorty_id().intValue() == aid.intValue()) {
					//�����ǰȨ�޵ı�ŵ��ھ���ӵ�е�Ȩ�ޱ�žͰ�checked�������ó�true,��ҳ��չʾʹ��
					parent.setChecked(true);
				}
			}
			//����������ӽڵ㴦��,ͬ��
			for (AnthortyInfo child : allList) {
				if(child.getAnthorty_id().intValue() == aid.intValue()) {
					 child.setChecked(true);
				}
			}
			
		}
		
		//�������ӹ�ϵ ѭ�����и��ڵ���ӽڵ�
		for (AnthortyInfo parent : parents) {
			for (AnthortyInfo child : allList) {
				//�����ǰ�ӽڵ�ĸ�id�ȸ�Ȩ�޶����е�����id�ʹ���ǰ�����Ǹ�Ȩ�޶�����Ӳ˵�,��ӵ��Ӳ˵�������
				if(child.getAnthorty_pid() == parent.getAnthorty_id()) {
					parent.getChilds().add(child);
				}
				
			}
			
		}
		
		
		
		return parents;
	}
	
	
	
	
}
