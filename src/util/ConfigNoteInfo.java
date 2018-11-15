package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 *<p>Title:ConfigNoteInfo</p>
 *<p>Description:</p>
 * @author ����
 * @date2018��9��22������9:45:26
 */
public class ConfigNoteInfo {
	private static ConfigNoteInfo configNoteInfo;
	private static Properties properties;
	private ConfigNoteInfo(){  
		//note.properties�����ڸ�Ŀ¼�½��������ļ� 
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

