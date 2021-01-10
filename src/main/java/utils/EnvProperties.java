package utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

public class EnvProperties {

	private static Map<String, String> properties = null;
	
	public static Map<String,String> getProperties(){
		if (properties == null) {
			properties = getPropertiesFromFile();
		}
		return properties;
	}
	
	private static Map<String, String> getPropertiesFromFile(){
		Properties propMain = new Properties();
		String enviroment = Optional.ofNullable(System.getProperty("env")).orElse("dev");
		properties=new HashMap<String, String>();
		try {
			FileInputStream fisDev=new FileInputStream(System.getProperty("user.dir")+"\\input\\"+enviroment+".properties");
			propMain.load(fisDev);
			properties.put("baseUrl", propMain.getProperty("baseUrl"));
			properties.put("apiKey", propMain.getProperty("apiKey"));
		} catch (Exception e) {
		}
		return properties;
	}
	
}
