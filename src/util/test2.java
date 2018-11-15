package util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

public class test2 {

	public static void main(String[] args) {
	    String host = "https://feginesms.market.alicloudapi.com";
	    String path = "/codeNotice";
	    String method = "GET";
	    String appcode = "cce3e538b6fa4398ab7bb6cf6c417ec1";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("param", "123456");
	    querys.put("phone", "18737316335");
	    querys.put("sign", "1");
	    querys.put("skin", "2");
            //JDK 1.8示例代码请在这里下载：  http://code.fegine.com/Tools.zip

	    try {
	    	
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
	    	//System.out.println(response.toString());如不输出json, 请打开这行代码，打印调试头部状态码。
                //状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
	    	//获取response的body
	    	System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}

}
