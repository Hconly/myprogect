package org.lq.base.util;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

/**
 * 数据源连接工具类
 * @author Administrator
 *
 */
public class DBUtil {
	
	private static DataSource ds = null;
	static {
		Properties properties = new Properties();
		try {
			properties.load(DBUtil.class.getClassLoader().getResourceAsStream("dbcp.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			ds = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource() {
		return ds;
	}

}
