package util;

import java.io.IOException;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.PostMethod;
/*** * @author HeShuang *@Create_date:2017-5-4 */
public class Note { 
	//���Žӿڣ����Σ��ֻ��ţ��������ݣ����ɷ��Ͷ��š�
	public String sendNode(String Tel,String message) throws HttpException, IOException{ 
		HttpClient client = new HttpClient();  
		PostMethod post = new PostMethod("https://feginesms.market.alicloudapi.com/codeNotice"); 
		post.addRequestHeader("Content-Type",     "application/x-www-form-urlencoded;charset=UTF-8");
		// ��ͷ�ļ�������ת�룬����ΪUTF-8  
		NameValuePair[] data = {     
				new NameValuePair("Uid", ConfigNoteInfo.getInstance().getString("id")), 
				// ע����û���������ͨ������ģʽ�������ļ�id�ж�ȡ�û�����   
				new NameValuePair("Key",ConfigNoteInfo.getInstance().getString("key")),
				// ע��ɹ��󣬵�¼��վ��õ�����Կ ��ͬ���������ļ���ȡ��   
				new NameValuePair("smsMob", Tel), 
				// ���ݹ������ֻ�����    
				new NameValuePair("smsText", message) 
				// ���ݹ����Ķ�������  
				};  
				post.setRequestBody(data);  
				client.executeMethod(post);   
				Header[] headers = post.getResponseHeaders();  
				int flag = post.getStatusCode(); 
				//����״̬������API  System.out.println("statusCode:" + flag);  
				for (Header h : headers) {   
					System.out.println("---" + h.toString());  
				}   
				String result = new String(post.getResponseBodyAsString().getBytes(     "UTF-8"));  
				System.out.println(result);    
				String info="";  
				if(Integer.parseInt(result.trim())>0){  
					info="���ͳɹ�!";  
				}  switch (result.trim()) {  
				case "-1":   
					info="�û��˺Ų����ڣ�";   
					break;  
				case "-2":    
					info="�ӿ���Կ����ȷ";   
					break;   
				case "-3":   
					info="�𾴵��û�����Ѫ�����������ȰѶ��ŷ��ý��ˣ�";  
					break;  
				case "-4":    
					info="�ֻ��Ÿ�ʽ����ȷ��";  
					break;  
				case "-6":    
					info="IP�������ƣ�";  
					break;   
				case "-11":   
					info="���û��ѱ����ã�";   
					break;  
				case "-14":   
					info="�������ݴ��ڷǷ��ַ���";   
					break; 
				default:   
					break;  
				} 
				return info;
		}
	}



