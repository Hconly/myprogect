package org.lq.power.test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.lq.power.entity.AnthortyInfo;

public class BeanTest {

	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<>();
		map.put("anthortyId", new String[] {"1001"});
		map.put("anthortyPid", new String[] {"0"});
		map.put("anthortyName", "www");
		map.put("anthortyDesc", "mmmm");
		map.put("anthortyUrl", "abc");
		
		AnthortyInfo bean = new AnthortyInfo();
		System.out.println(bean);
		try {
			BeanUtils.populate(bean, map);
			System.out.println(bean);
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
