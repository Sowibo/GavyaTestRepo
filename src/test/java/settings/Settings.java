package settings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import settings.Settings;

public class Settings {
	public static Settings getInstance(){
		return new Settings();
		
	}
	public String getProperty(String key) {
		String s="";
		Properties properties=new Properties();
		try {
			FileInputStream file=new FileInputStream("src/test/resources/settings.properties");
			
//			FileInputStream file=new FileInputStream("GreenGavyaTest/src/test/resources/settings.properties");
			properties.load(file);
			 s=properties.getProperty(key);
//			 String s1=properties.getProperty(urldb);
//			 String s2=properties.getProperty(username);
//			 String s3=properties.getProperty(password);
			  
//			  System.out.println("value of flag:"+get);

			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
		
	}
	

}
