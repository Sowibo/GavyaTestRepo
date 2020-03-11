package dbcontroller;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbConnection {
	Statement stmt;
	public static DbConnection getInstance(){
		return new DbConnection();
		
	}
	public void initialisation(String urldb,String username,String password) {
		Statement statement;
		boolean flag=true;
		Properties properties=new Properties();
	    	try {
	    		
	    		Class.forName("com.mysql.cj.jdbc.Driver");//Driver registration.
	    		Connection con=DriverManager.getConnection(urldb,username,password);//Connection established.
	    		statement=con.createStatement(); 			
			}
			catch(ClassNotFoundException e) {
				System.err.println("class not found"+e);
				flag=false;
			}
			catch(SQLException p) {
				System.err.println("Connection error"+p);
				flag=false;
			}
	    	if(flag) {
	    		System.out.println("Database Connection Established");
	    
	    	}
	}
	
	
	

}
