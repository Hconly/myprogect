package util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinYinUtil {

	private static HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
	static {
		// 去掉声调
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
	}

	// 转换汉语拼音的方法
	public static String toHanYuPin(String str) {
		//接受字符串
		StringBuffer sbf = new StringBuffer();
		//遍历字符串
		for (int i = 0; i < str.length(); i++) {
			//取出字符串中每一个字符
			char c = str.charAt(i);
			try {
				//得到每一个汉字,转化成拼音
				String hanyupinyin[] = PinyinHelper.toHanyuPinyinStringArray(c, format);
				//如果不是汉字就转化为null
				if (hanyupinyin != null) {
					//将汉字的字母插入到char数组中
					char py[] = hanyupinyin[0].toCharArray();
					py[0] = castutil.castString(py[0]).toUpperCase().charAt(0);
					sbf.append(py);
				} else {
					sbf.append(c);
				}
			} catch (BadHanyuPinyinOutputFormatCombination e) {
				sbf.append(c);
			}
		}
		return sbf.toString();
	}

	public static String toFirst(String str) {
		StringBuffer sbf = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			try {
				String[] py = PinyinHelper.toHanyuPinyinStringArray(c, format);
				if (py != null) {
					char first = py[0].toUpperCase().charAt(0);
					sbf.append(first);
				} else {
					sbf.append(c);
				}
			} catch (BadHanyuPinyinOutputFormatCombination e) {
				sbf.append(c);
			}
		}
		return sbf.toString();
	}
}
