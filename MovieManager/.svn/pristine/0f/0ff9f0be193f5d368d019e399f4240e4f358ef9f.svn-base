package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 *<p>Title:ConfigNoteInfo</p>
 *<p>Description:</p>
 * @author 王超
 * @date2018年9月22日下午9:45:26
 */
public class ConfigNoteInfo {
	private static ConfigNoteInfo configNoteInfo;
	private static Properties properties;
	private ConfigNoteInfo(){  
		//note.properties是你在根目录新建的配置文件 
		String configFile="note.properties";  
		properties=new Properties(); 
		InputStream in=ConfigNoteInfo.class.getClassLoader().getResourceAsStream(configFile); 
		try {  
			properties.load(in);  
			in.close(); 
		} catch (IOException e) {
			e.printStackTrace(); 
		} 
	}
	public static ConfigNoteInfo getInstance(){ 
		if(configNoteInfo==null){ 
			configNoteInfo = new ConfigNoteInfo(); 
		}  return configNoteInfo;
	}
	public String getString(String key){ 
		return properties.getProperty(key); 
	}

}

