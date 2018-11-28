package org.lq.base.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.lq.power.entity.AnthortyInfo;
import org.lq.power.entity.RoleInfo;
/**
 * ��ȡʵ������
 * @author Administrator
 *
 */
public class BeanNewInstance {
	/**
	 * ����map����javaʵ�����
	 * @param c	��Ҫ������ʵ������ֽ���
	 * @param map ����������Դ
	 * @return	����һ��ʵ������
	 */
	public static <T> T getInstance(Class<T> c,Map<String,? extends Object> map) {
		T t = null;
		try {
			t = (T) c.newInstance();//�����ֽ���ʵ������ new ��();
			BeanUtils.copyProperties(t, map);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	
	
	public static void main(String[] args) {
		getInstance(RoleInfo.class,null);
	}
	
	
}
