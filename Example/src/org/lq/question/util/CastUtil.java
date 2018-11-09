package org.lq.question.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 转型操作工具类
 * @author 无语
 *
 * @时间 2018年8月24日
 * 20180824_jsp_ch03
 */
public class CastUtil {
	
	
	// java.util.Date->有空构造,但是数据库不可以直接使用 和 java.sql.Date(数据库时间类型)->没有空构造
	/**
	 * 将字符串转换成SQL对象
	 * @param obj
	 * @return
	 */
	public static Date castSqlDatetoString(String obj) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date=null;
		try {
			date = Date.valueOf(obj);
		} catch (Exception e) {
			try {
				java.util.Date utildate= sdf.parse(obj);
				date= castUtilDatetoSqlDate(utildate);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
		}
		return date;
	}
	/**
	 * 将UtilDate转换成SqlDate
	 * @param obj
	 * @return
	 */
	public static Date castUtilDatetoSqlDate(java.util.Date obj) {
		return new Date(obj.getTime());
	}
	
	/**
	 * 转为字符串
	 * @param obj
	 * @return
	 */
	public static String castString(Object obj) {
		return castString(obj, "");
	}
	/**
	 * 转成String型(默认值)
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static String castString(Object obj,String defaultValue) {
		return obj != null ? String.valueOf(obj) : defaultValue;
	}
	/**
	 * 转为double
	 * @param obj
	 * @return
	 */
	public static double castDouble(Object obj) {
		return castDouble(obj,0);
	}
	/**
	 * 转成double带默认值
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static double castDouble(Object obj,double defaultValue) {
		double doubleValue = defaultValue;
		if(obj!=null) {
			String strVal = castString(obj);
			try {
				if(!"".equals(strVal)) {
					doubleValue = Double.parseDouble(strVal);
				}
			} catch (NumberFormatException e) {
				doubleValue = defaultValue;
			}
			
		}
		return doubleValue;
	}
	/**
	 * 转换成int类型
	 * @param obj
	 * @return
	 */
	public static int castInt(Object obj) {
		return castInt(obj, 0);
	}
	/**
	 * 转换int带默认值
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static int castInt(Object obj,int defaultValue) {
		int intValue = defaultValue;
		if(obj!=null) {
			String strVal = castString(obj);
			try {
				if(!"".equals(strVal)) {
					intValue = Integer.valueOf(strVal);
				}
			} catch (NumberFormatException e) {
				intValue = defaultValue;
			}
		}
		return intValue;
	}
	
}
