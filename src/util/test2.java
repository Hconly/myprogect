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
	    //�����header�еĸ�ʽ(�м���Ӣ�Ŀո�)ΪAuthorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("param", "123456");
	    querys.put("phone", "18737316335");
	    querys.put("sign", "1");
	    querys.put("skin", "2");
            //JDK 1.8ʾ�����������������أ�  http://code.fegine.com/Tools.zip

	    try {
	    	
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
	    	//System.out.println(response.toString());�粻���json, ������д��룬��ӡ����ͷ��״̬�롣
                //״̬��: 200 ������400 URL��Ч��401 appCode���� 403 �������ꣻ 500 API���ܴ���
	    	//��ȡresponse��body
	    	System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}

}
