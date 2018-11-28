package xxc.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CastUtil {
	
	
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
	
	public static Date castUtilDatetoSqlDate(java.util.Date obj) {
		return new Date(obj.getTime());
	}
	
	public static String castString(Object obj) {
		return castString(obj, "");
	}
	
	public static String castString(Object obj,String defaultValue) {
		return obj != null ? String.valueOf(obj) : defaultValue;
	}
	
	
	public static double castDouble(Object obj) {
		return castDouble(obj,0);
	}
	
	
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
	
	
	public static int castInt(Object obj) {
		return castInt(obj, 0);
	}
	
	
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
