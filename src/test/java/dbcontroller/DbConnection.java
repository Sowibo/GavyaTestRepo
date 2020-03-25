package dbcontroller;

import java.io.FileInputStream;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automation.AutomationScript;
import webdriver.CustomWebDriver;

public class DbConnection {
	Statement stmt;
	static Statement  statement;
	
	public static DbConnection getInstance(){
		return new DbConnection();
		
	}
	public void initialisation(String urldb,String username,String password) {
//		Statement statement;
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
	
	//*********************************veena*************************************
	public void getData() {
//		Statement st=null;
		
		 ResultSet rs;
		
		 
		 try {
			 rs= statement.executeQuery("SELECT name FROM product");
			 while(rs.next()) {
				
				 String s1=rs.getString(1);
				AutomationScript.returnobj().testSearch(s1); 

				
			}
			
			}
		 catch(SQLException s) {
				System.err.println("SQL error"+s);
			}
			
	 }
	public void getElement() {
//		Statement st=null;
		
		 ResultSet rs;
		
		 
		 try {
			 rs= statement.executeQuery("SELECT first_name FROM element");
			 while(rs.next()) {
				
				 String s1=rs.getString(1);
				AutomationScript.returnobj().invalidElement(s1); 

				
			}
			
			}
		 catch(SQLException s) {
				System.err.println("SQL error"+s);
			}
			
	 }
	
	public void clickElement() {
//		Statement st=null;
		
		 ResultSet rs;
		
		 
		 try {
			 rs= statement.executeQuery("SELECT name FROM product");
			 while(rs.next()) {
				
				 String s1=rs.getString(1);
				AutomationScript.returnobj().clickOption(s1); 

				
			}
			
			}
		 catch(SQLException s) {
				System.err.println("SQL error"+s);
			}
			
	 }
	public void clickSearchBtn() {

		ResultSet rs;
		
		 
		 try {
			 rs= statement.executeQuery("SELECT name FROM product");
			 while(rs.next()) {
				
				 String s1=rs.getString(1);
				AutomationScript.returnobj().mouseClick(s1); 

				
			}
			
			}
		 catch(SQLException s) {
				System.err.println("SQL error"+s);
			}
			
	 }
	public void searchClear() {

		ResultSet rs;
		
		 
		 try {
			 rs= statement.executeQuery("SELECT name FROM product");
			 while(rs.next()) {
				
				 String s1=rs.getString(1);
				AutomationScript.returnobj().clickClearOption(s1); 

				
			}
			
			}
		 catch(SQLException s) {
				System.err.println("SQL error"+s);
			}
			
	 }
	public void categoryDb() {
		ResultSet rs;
		
		 
		 try {
			 rs= statement.executeQuery("SELECT category_name FROM category");
			 while(rs.next()) {
				
				 String s1=rs.getString(1);
				AutomationScript.returnobj().findCategory(s1); 
				

				
			}
			
			}
		 catch(SQLException s) {
				System.err.println("SQL error"+s);
			}
			
	}
}
