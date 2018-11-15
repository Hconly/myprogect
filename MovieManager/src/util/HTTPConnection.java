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
			//创建URL路径													参数
			URL url = new URL("http://isbn.market.alicloudapi.com/ISBN?isbn=" + code);

			//连接网络
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("Authorization", "APPCODE cce3e538b6fa4398ab7bb6cf6c417ec1");
			//创建容器存取传回的数据
			InputStream is = conn.getInputStream();
			//字节流转换
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			//读取数据
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
