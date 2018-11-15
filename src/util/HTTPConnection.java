package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;

public class HTTPConnection {
	public static String getJson(String code) {
		String json = "";
		try {
			//����URL·��													����
			URL url = new URL("http://isbn.market.alicloudapi.com/ISBN?isbn=" + code);

			//��������
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("Authorization", "APPCODE cce3e538b6fa4398ab7bb6cf6c417ec1");
			//����������ȡ���ص�����
			InputStream is = conn.getInputStream();
			//�ֽ���ת��
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			//��ȡ����
			BufferedReader br = new BufferedReader(isr);
			StringBuffer sbf = new StringBuffer();
			String line = "";
			while ((line = br.readLine()) != null) {
				sbf.append(line);
			}
			json = sbf.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;

	}
}
