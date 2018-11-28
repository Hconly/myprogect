package test.util;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

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
			System.out.println(ds.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public static DataSource getDataSource() {
		return ds;
	}
	public static void main(String[] args) {
		System.out.println(getDataSource());
	}
}
