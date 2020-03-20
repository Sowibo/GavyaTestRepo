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
			properties.load(file);
			s=properties.getProperty(key);
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
