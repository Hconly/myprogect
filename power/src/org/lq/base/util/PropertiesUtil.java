package org.lq.base.util;

import java.io.IOException;
import java.util.Properties;
/**
 * �����ļ���ȡ
 * @author Administrator
 *
 */
public class PropertiesUtil {
	
	private static Properties properties;
	
	static {
		properties = new Properties();
		try {
			properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("context.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ͨ��key��ȡ����
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		return properties.getProperty(key, null);
	}
	

}
