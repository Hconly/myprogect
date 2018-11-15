package util;

import java.io.IOException;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.PostMethod;
/*** * @author HeShuang *@Create_date:2017-5-4 */
public class Note { 
	//短信接口，传参（手机号，短信内容）即可发送短信。
	public String sendNode(String Tel,String message) throws HttpException, IOException{ 
		HttpClient client = new HttpClient();  
		PostMethod post = new PostMethod("https://feginesms.market.alicloudapi.com/codeNotice"); 
		post.addRequestHeader("Content-Type",     "application/x-www-form-urlencoded;charset=UTF-8");
		// 在头文件中设置转码，这里为UTF-8  
		NameValuePair[] data = {     
				new NameValuePair("Uid", ConfigNoteInfo.getInstance().getString("id")), 
				// 注册的用户名，我们通过单例模式从配置文件id中读取用户名。   
				new NameValuePair("Key",ConfigNoteInfo.getInstance().getString("key")),
				// 注册成功后，登录网站后得到的密钥 ，同样从配置文件读取。   
				new NameValuePair("smsMob", Tel), 
				// 传递过来的手机号码    
				new NameValuePair("smsText", message) 
				// 传递过来的短信内容  
				};  
				post.setRequestBody(data);  
				client.executeMethod(post);   
				Header[] headers = post.getResponseHeaders();  
				int flag = post.getStatusCode(); 
				//返回状态，参照API  System.out.println("statusCode:" + flag);  
				for (Header h : headers) {   
					System.out.println("---" + h.toString());  
				}   
				String result = new String(post.getResponseBodyAsString().getBytes(     "UTF-8"));  
				System.out.println(result);    
				String info="";  
				if(Integer.parseInt(result.trim())>0){  
					info="发送成功!";  
				}  switch (result.trim()) {  
				case "-1":   
					info="用户账号不存在！";   
					break;  
				case "-2":    
					info="接口密钥不正确";   
					break;   
				case "-3":   
					info="尊敬的用户，卖血卖肾，请您先把短信费用缴了！";  
					break;  
				case "-4":    
					info="手机号格式不正确！";  
					break;  
				case "-6":    
					info="IP存在限制！";  
					break;   
				case "-11":   
					info="该用户已被禁用！";   
					break;  
				case "-14":   
					info="短信内容存在非法字符！";   
					break; 
				default:   
					break;  
				} 
				return info;
		}
	}



