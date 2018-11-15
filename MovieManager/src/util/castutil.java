package util;

public class castutil {
	/**
	 * 转换字符串类型(带默认值)
	 * 
	 * @author Administrator
	 *
	 */

	public static String castString(Object obj, String defaultValue) {
		return obj != null ? String.valueOf(obj) : defaultValue;
	}

	// 不带默认值
	public static String castString(Object obj) {
		
		return castString(obj, "");
	}

	// int类型转换,带默认值
	public static int castint(Object obj, int defaultValue) {
		int intvalue = defaultValue;
		if (obj != null) {
			String strValue = castString(obj);
			if (!"".equals(strValue)) {
				try {
					intvalue = Integer.valueOf(strValue);
				} catch (NumberFormatException e) {
					intvalue = defaultValue;
				}
			}
		}
		return intvalue;
	}

	// int类型转换不带默认值
	public static int castint(Object obj) {
		return castint(obj, 0);
	}

	// double类型转换,带默认值
	public static double castDouble(Object obj, double defaultValue) {
		double doublevalue = defaultValue;
		if (obj != null) {
			String strValue = castString(obj);
			if (!"".equals(strValue)) {
				try {
					doublevalue = Double.valueOf(strValue);
				} catch (NumberFormatException e) {
					doublevalue = defaultValue;
				}
			}
		}
		return doublevalue;
	}

	// double类型转换不带默认值
	public static double castDouble(Object obj) {
		return castDouble(obj, 0.0);
	}

}
