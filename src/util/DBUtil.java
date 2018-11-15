package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	public static Connection getconn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ma?characterEncoding=utf8", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeAll() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (ps != null) {
				ps.close();
				ps = null;
			}
			if (conn != null) {
				conn.close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//通用增删改
	public static int executeupdate(String sql, Object... params) {
		int num = 0;
		getconn();
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				Object v = params[i];
				ps.setObject(i + 1, v);
			}
			num = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return num;

	}
//通用查询
	public static ResultSet executequery(String sql, Object... params) {
		
		getconn();
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				Object v = params[i];
				ps.setObject(i + 1, v);
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;

	}
//	public static void main(String[] args) {
//		System.out.println(getconn());
//	}
}
