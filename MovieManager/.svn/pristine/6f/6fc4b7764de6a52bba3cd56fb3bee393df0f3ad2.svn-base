package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Tools {
    public static void main(String[] args) throws  Exception{
        String host = "https://goexpress.market.alicloudapi.com";       //请求地址  支持http 和 https 及 WEBSOCKET
        String path = "/goexpress";                                     //后缀
        String appcode = "cce3e538b6fa4398ab7bb6cf6c417ec1";                             //AppCode  你自己的AppCode 在买家中心查看
        String no = "780098068058";                                     //参数，具体参照api接口参数
        String type = "zto";                                            //参数，具体参照api接口参数
        String urlSend = host + path + "?no=" + no + "&type=" + type;   //拼接请求链接
        URL url = new URL(urlSend);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty("Authorization", "APPCODE " + appcode);//格式Authorization:APPCODE (中间是英文空格)
        int httpCode = httpURLConnection.getResponseCode();
        String json = read(httpURLConnection.getInputStream());
        System.out.println("/* 获取服务器响应状态码 200 正常；400 权限错误 ； 403 次数用完； */ ");
        System.out.println(httpCode);
        System.out.println("/* 获取返回的json   */ ");
        System.out.print(json);
    }
    /*
        读取返回结果
     */
    private static String read(InputStream is) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        while ((line = br.readLine()) != null) {
            line = new String(line.getBytes(), "utf-8");
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
