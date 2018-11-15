package util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinYinUtil {

	private static HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
	static {
		// ȥ������
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
	}

	// ת������ƴ���ķ���
	public static String toHanYuPin(String str) {
		//�����ַ���
		StringBuffer sbf = new StringBuffer();
		//�����ַ���
		for (int i = 0; i < str.length(); i++) {
			//ȡ���ַ�����ÿһ���ַ�
			char c = str.charAt(i);
			try {
				//�õ�ÿһ������,ת����ƴ��
				String hanyupinyin[] = PinyinHelper.toHanyuPinyinStringArray(c, format);
				//������Ǻ��־�ת��Ϊnull
				if (hanyupinyin != null) {
					//�����ֵ���ĸ���뵽char������
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
