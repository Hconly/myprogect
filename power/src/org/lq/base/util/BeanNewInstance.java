package org.lq.base.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.lq.power.entity.AnthortyInfo;
import org.lq.power.entity.RoleInfo;
/**
 * 获取实例对象
 * @author Administrator
 *
 */
public class BeanNewInstance {
	/**
	 * 根据map创建java实体对象
	 * @param c	需要创建的实体类的字节码
	 * @param map 创建的数据源
	 * @return	返回一个实例对象
	 */
	public static <T> T getInstance(Class<T> c,Map<String,? extends Object> map) {
		T t = null;
		try {
			t = (T) c.newInstance();//根据字节码实例对象 new 类();
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
