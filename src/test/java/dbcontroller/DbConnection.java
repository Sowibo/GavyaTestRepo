package dbcontroller;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import automation.AutomationScript;

public class DbConnection {
	static Statement statement;
	
	public static DbConnection getInstance(){
		return new DbConnection();
		
	}
	public void initialisation(String urldb,String username,String password) {
		
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
	/*------------- Athira-------------   */
	
	public void getValidLogin() {
		ResultSet rs;
		try {
				 rs= statement.executeQuery("SELECT Email_address,password FROM register WHERE id=1 OR id=2 OR id=3");
				 while(rs.next()) {
				 	String s1=rs.getString(1);
					String s2=rs.getString(2);
					AutomationScript.returnobj().testLogin(s1,s2);
			}
		}
		catch(SQLException c) {
				System.err.println("SQL error"+c);
			}
		}
	
	
	public void getEmptyLogin() {
		ResultSet rs;
		try {
				 rs= statement.executeQuery("SELECT Email_address,password FROM register WHERE id=1");
				 while(rs.next()) {
				 	String s1=rs.getString(1);
					String s2=rs.getString(2);
					AutomationScript.returnobj().loginOneEmpty(s1, s2);
			}
		}
			catch(SQLException c) {
				System.err.println("SQL error"+c);
			}
		}
	public void getInvalidLogin() {
		ResultSet rs;
		try {
				 rs= statement.executeQuery("SELECT Email_address,password FROM register WHERE id=6");
				 while(rs.next()) {
				 	String s1=rs.getString(1);
					String s2=rs.getString(2);
					AutomationScript.returnobj().invalidLogin(s1, s2);
			}
		}
			catch(SQLException c) {
				System.err.println("SQL error"+c);
			}
		}
	
	public void getValidOne() {
		ResultSet rs;
		try {
				 rs= statement.executeQuery("SELECT Email_address,password FROM register WHERE id=7");
				 while(rs.next()) {
				 	String s1=rs.getString(1);
					String s2=rs.getString(2);
					AutomationScript.returnobj().validOne(s1, s2);
			}
		}
			catch(SQLException c) {
				System.err.println("SQL error"+c);
			}
		}
	public void getForgotValid() {
		ResultSet rs;
		try {
				 rs= statement.executeQuery("SELECT Email_address FROM register WHERE id=1 OR id=2 OR id=3");
				 while(rs.next()) {
				 	String s1=rs.getString(1);
					
					AutomationScript.returnobj().forgotValid(s1);
			}
		}
			catch(SQLException c) {
				System.err.println("SQL error"+c);
			}
		}
	public void getForgotInvalid() {
		ResultSet rs;
		try {
				 rs= statement.executeQuery("SELECT Email_address FROM register WHERE id=6");
				 while(rs.next()) {
				 	String s1=rs.getString(1);
					
					AutomationScript.returnobj().forgotInvalid(s1);
			}
		}
			catch(SQLException c) {
				System.err.println("SQL error"+c);
			}
		}
	

}
