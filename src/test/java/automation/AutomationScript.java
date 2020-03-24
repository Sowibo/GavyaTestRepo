
package automation;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import dbcontroller.DbConnection;
import settings.Settings;
import webdriver.CustomWebDriver;

public class AutomationScript extends CustomWebDriver{
	
	
	public static AutomationScript returnobj() {
		return new AutomationScript();
	}
	public void launchUrl() {
		driver.get(Settings.getInstance().getProperty("url"));
	}
	//Gopika
	//Automation
	public void cooki() {
		WebElement cooki;
		cooki=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/button"));
		cooki.click();
	}
	public void login() {
		WebElement login,submit,email,password;
		driver.get(Settings.getInstance().getProperty("url"));
		AutomationScript.returnobj().cooki();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		login=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		login.click();
		email=driver.findElement(By.id("email"));
		email.sendKeys(Settings.getInstance().getProperty("email"));
		password=driver.findElement(By.id("password"));
		password.sendKeys(Settings.getInstance().getProperty("pass"));
		submit=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/div[2]/div[2]/button"));
		submit.click();
	}
	
	
	public void checkout() {
		 WebElement cart,checkout,proceedtocheckout;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		cart=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[2]/div[2]/div[2]/button"));
		cart.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		checkout=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
		checkout.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		proceedtocheckout=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/div/button"));
		proceedtocheckout.click();
	}
	
	public void useAddress() {
		WebElement address,confirmorder,yourorder;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		address=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[1]/div/div/button"));
		address.click();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		confirmorder=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[4]/a"));
		confirmorder.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		yourorder=driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div/a"));
		yourorder.click();
	}
	
	public void cancel() {
		WebElement cancel;
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cancel=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/p[2]/span/button"));
		cancel.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.switchTo().alert().accept();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
	}
	
	
	public void reorder() {
		WebElement reorder,continuebtn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reorder=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/p[2]/span[2]/button"));
		reorder.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		continuebtn=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[3]/div/div[2]/button"));
		continuebtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ConfirmReorder ="https://www.greengavya.com/reorder";
		String url=driver.getCurrentUrl();
		if(url.equals(ConfirmReorder )) {
//			System.out.println("TCID 92 success");
			
		}
		else {
			fail("TCID <92> failed:  Doesnt redirect to ConfirmReorder page>");
			
		}
	}
	
	public void editAddress() {
		
		WebElement edit,name1,mobnum1,flatno1,sreet1,city1,dis1,pin1,landmark,cnbtn,name2,mobnum2,flatno2,sreet2,city2,pin2;
		Select district;
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		name1=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[2]/div/div[1]/p[1]"));
		String message=name1.getText();
		flatno1=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[2]/div/div[1]/p[2]"));
		String message1=flatno1.getText();
		sreet1=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[2]/div/div[1]/p[3]"));
		String message2=sreet1.getText();
		city1=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[2]/div/div[1]/p[4]"));
		String message3=city1.getText();
		dis1=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[2]/div/div[1]/p[5]"));
		String message4=dis1.getText();
		pin1=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[2]/div/div[1]/p[5]"));
		String message5=pin1.getText();
		mobnum1=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[2]/div/div[1]/p[6]"));
		String message6=mobnum1.getText();
		edit=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[2]/div/div[1]/p[7]/button[1]"));
		edit.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		name2=driver.findElement(By.id("name"));
		name2.clear();
		name2.sendKeys("Aswajith");
		String message7=name2.getText();
		
		mobnum2=driver.findElement(By.id("phone"));
		mobnum2.clear();
		mobnum2.sendKeys("9961565559");
		String message8=mobnum2.getText();
		flatno2=driver.findElement(By.id("house"));
		flatno2.clear();
		flatno2.sendKeys("56XXN");
		String message9=flatno2.getText();
		sreet2=driver.findElement(By.id("street"));
		sreet2.clear();
		sreet2.sendKeys("Revathi chundavila pothencode");
		String message10=sreet2.getText();
		city2=driver.findElement(By.id("city"));
		city2.clear();
		city2.sendKeys("Revathi chundavila pothencode");
		String message11=city2.getText();
		dis1=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/form/select"));
		dis1.click();
		district=new Select(driver.findElement(By.name("district")));
		district.selectByVisibleText("Kollam");
		String message15= district.getFirstSelectedOption().getText();
		pin2=driver.findElement(By.id("pin"));
		pin2.clear();
		pin2.sendKeys("645909");
		String message12=pin2.getText();
		landmark=driver.findElement(By.id("landmark"));
		landmark.clear();
		landmark.sendKeys("near at school");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cnbtn=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/form/input[8]"));
		cnbtn.click();
		if(message.equals(message7)) {
			fail("TCID <93> failed: <no show error message when  name field with invalid data>");	
		}
//		else {
//			System.out.println("tcid 93 name success");
//		}
		if(message1.equals(message9)) {
			fail("TCID <93> failed: <no show error message when  name field with invalid data>");	
		}
//		else {
//			System.out.println("tcid 93 flat success");
//		}
		if(message2.equals(message10)) {
			fail("TCID <93> failed: <no show error message when  name field with invalid data>");	
		}
//		else {
//			System.out.println("tcid 93 street success");
//		}
		if(message3.equals(message11)) {
			fail("TCID <93> failed: <no show error message when  name field with invalid data>");	
		}
//		else {
//			System.out.println("tcid 93 city success");
//		}
		if(message5.equals(message12)) {
			fail("TCID <93> failed: <no show error message when  name field with invalid data>");	
		}
//		else {
//			System.out.println("tcid 93 pin success");
//		}
		if(message6.equals(message8)) {
			fail("TCID <93> failed: <no show error message when  name field with invalid data>");	
		}
//		else {
//			System.out.println("tcid 93 mobile success");
//		}
		if(message4.equals(message15)) {
			fail("TCID <93> failed: <no show error message when  name field with invalid data>");	
		}
//		else {
//			System.out.println("tcid 93 dis success");
//		}
//		
		
		
	}
	
	public void newAddress() {
		WebElement newaddress,name,mobnum,flatno,sreet,city,dis,pin,landmark,cnbtn,name1,mobnum1,flatno1,sreet1,dis1,city1,pin1;
		Select district;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		name1=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[2]/div/div[1]/p[1]"));
		String message=name1.getText();
		flatno1=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[2]/div/div[1]/p[2]"));
		String message1=flatno1.getText();
		sreet1=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[2]/div/div[1]/p[3]"));
		String message2=sreet1.getText();
		city1=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[2]/div/div[1]/p[4]"));
		String message3=city1.getText();
		pin1=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[2]/div/div[1]/p[5]"));
		String message4=pin1.getText();
		mobnum1=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[2]/div/div[1]/p[6]"));
		String message5=mobnum1.getText();
		dis1=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[2]/div/div[1]/p[5]"));
		String message14=dis1.getText();
		newaddress=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[2]/div/div[1]/p[7]/button[2]"));
		newaddress.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		name=driver.findElement(By.id("name"));
		name.clear();
		name.sendKeys("Gopika");
		String message6=name.getText();
		mobnum=driver.findElement(By.id("phone"));
		mobnum.clear();
		mobnum.sendKeys("7592018435");
		String messag7=mobnum.getText();
		flatno=driver.findElement(By.id("house"));
		flatno.clear();
		flatno.sendKeys("56BBN");
		String messag8=flatno.getText();
		sreet=driver.findElement(By.id("street"));
		sreet.clear();
		sreet.sendKeys("chundappana veedu karoor  pothencode");
		String messag9=sreet.getText();
		city=driver.findElement(By.id("city"));
		city.clear();
		city.sendKeys("chundappana veedu karoor  pothencode");
		String messag10=city.getText();
		dis=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/form/select"));
		dis.click();
		district=new Select(driver.findElement(By.name("district")));
		district.selectByVisibleText("Trivandrum");
		String message15= district.getFirstSelectedOption().getText();
		pin=driver.findElement(By.id("pin"));
		pin.clear();
		pin.sendKeys("908969");
		String messag11=pin.getText();
		landmark=driver.findElement(By.id("landmark"));
		landmark.clear();
		landmark.sendKeys("near at school");
		cnbtn=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/form/input[8]"));
		cnbtn.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(message.equals(message6)) {
			fail("TCID <93> failed: <no show error message when  name field with invalid data>");	
		}
//		else {
//			System.out.println("tcid 93 name success");
//		}
		if(message1.equals(messag8)) {
			fail("TCID <93> failed: <no show error message when  name field with invalid data>");	
		}
//		else {
//			System.out.println("tcid 93 flat success");
//		}
		if(message2.equals(messag9)) {
			fail("TCID <93> failed: <no show error message when  name field with invalid data>");	
		}
//		else {
//			System.out.println("tcid 93 street success");
//		}
		if(message3.equals(messag10)) {
			fail("TCID <93> failed: <no show error message when  name field with invalid data>");	
		}
//		else {
//			System.out.println("tcid 93 city success");
//		}
		if(message4.equals(messag11)) {
			fail("TCID <93> failed: <no show error message when  name field with invalid data>");	
		}
//		else {
//			System.out.println("tcid 93 pin success");
//		}
		if(message5.equals(messag7)) {
			fail("TCID <93> failed: <no show error message when  name field with invalid data>");	
		}
//		else {
//			System.out.println("tcid 93 mob success");
//		}
		if(message14.equals(message15)) {
			fail("TCID <93> failed: <no show error message when  name field with invalid data>");	
		}
//		else {
//			System.out.println("tcid 93 dis success");
//		}
		
	}
	
	
	
	public void reorder1() {
		WebElement reorder,continuebtn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reorder=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/p[2]/span[2]/button"));
		reorder.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		continuebtn=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[3]/div/div[2]/button"));
		continuebtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	public void confirmReorder() {
		WebElement confirmorder;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		confirmorder=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[3]/div[2]/button[2]"));
		confirmorder.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert=driver.switchTo().alert();
		alert.accept();
	
		if(alert.equals(null)) {
			fail("TCID <95> failed: <alert box not present");
			
		}
//		else {
//			System.out.println("tcid 95 success");
//		}
		
	}
	
	public void back() {
		WebElement back;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		back=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div/div[3]/div[2]/button[1]"));
		back.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String myReorder ="https://www.greengavya.com/myorders";
		String url=driver.getCurrentUrl();
		if(url.equals(myReorder )) {
//			System.out.println("TCID 96 success");
			
		}
		else {
			fail("TCID <96> failed:  Doesnt redirect to myReorder page>");
			
		}
		
	}
	
	public void trackOrder() {
		WebElement track,close,delivery;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		track=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/p[2]/button/img"));
		track.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		delivery=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div[1]/div/div[1]/h3"));
		
		String message=delivery.getText();
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <97> failed: <no show error message when  name field with invalid data>");	
		}
//		else {
//			System.out.println("tcid 97 success");
//		}
		close=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div[1]/div/div[1]/span"));
		close.click();
		
		
	}
	
	public void invoicePrint() {
		WebElement invoice,print;
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		invoice=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/p[1]/a"));
		invoice.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print=driver.findElement(By.xpath("/html/body/div/div/div/div/div/button[1]"));
		print.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.switchTo().alert().dismiss();; 

	}
	
	public void invoiceDownload() {
		WebElement download;
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		download=driver.findElement(By.xpath("/html/body/div/div/div/div/div/button[2]"));
		download.click();
		driver.switchTo().alert().getText(); 
//		if(alert.equals(null)) {
//			fail("TCID <98> failed: <alert box not present");
//			
//		}
//		else {
//			System.out.println("tcid 98 success");
//		}
		
	}
	
	public void validContactUs() {
		WebElement contact,select,name,email,phnum,comment,btn;
		contact=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[4]/a"));
		contact.click();
		select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/select/option[2]"));
		select.click();
		name=driver.findElement(By.id("name"));
		email=driver.findElement(By.id("email"));
		phnum=driver.findElement(By.id("phone"));
		comment=driver.findElement(By.id("comment"));
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/button"));
		name.sendKeys("Gopika");
		email.sendKeys("gopikagopakumaran1@gmail.com");
		phnum.sendKeys("7592018435");
		comment.sendKeys("SoWiBo is not just a software development house. 100 percent of our profits are used for social causes.");
		btn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert=driver.switchTo().alert();
		alert.accept();
		if(alert.equals(null)) {
			fail("TCID <100> failed: <alert box not present");
			
		}
//		else {
//			System.out.println("tcid 100 success");
//		}
		

	}
	public void invalidNameContactUs() {
		WebElement contact,select,name,email,phnum,comment,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contact=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[4]/a"));
		contact.click();
		select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/select/option[2]"));
		select.click();
		name=driver.findElement(By.id("name"));
		name.clear();
		name.sendKeys("dfretr$$#@@@#");
		
		String message=name.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <101> failed: <no show error message when  name field with invalid data>");	
		}
//		else {
//			System.out.println("tcid 101 success");
//		}
		email=driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("gopikagopakumaran1@gmail.com");
		phnum=driver.findElement(By.id("phone"));
		phnum.clear();
		phnum.sendKeys("7592018435");
		comment=driver.findElement(By.id("comment"));
		comment.clear();
		comment.sendKeys("SoWiBo is not just a software development house. 100 percent of our profits are used for social causes.");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/button"));
		btn.click();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.switchTo().alert().accept();
		
	}
	
	
	
	public void emptyNameContactus() {
		WebElement contact,select,name,email,phnum,comment,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contact=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[4]/a"));
		contact.click();
		select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/select/option[2]"));
		select.click();
		name=driver.findElement(By.id("name"));
		name.clear();
		name.sendKeys("");
		email=driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("gopikagopakumaran1@gmail.com");
		phnum=driver.findElement(By.id("phone"));
		phnum.clear();
		phnum.sendKeys("7592018435");
		comment=driver.findElement(By.id("comment"));
		comment.clear();
		comment.sendKeys("SoWiBo is not just a software development house. 100 percent of our profits are used for social causes.");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/button"));
		btn.click();
		
		String message=name.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <102> failed: <no show error message when empty name field>");	
		}
//		else {
//			System.out.println("tcid 102 success");
//		}
//		
	}
	public void invalidEmailContactus() {
		WebElement contact,select,name,email,phnum,comment,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contact=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[4]/a"));
		contact.click();
		select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/select/option[2]"));
		select.click();
		name=driver.findElement(By.id("name"));
		name.clear();
		name.sendKeys("gopika");
		email=driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("sfdeea234432ddd");
		phnum=driver.findElement(By.id("phone"));
		phnum.clear();
		phnum.sendKeys("7592018435");
		comment=driver.findElement(By.id("comment"));
		comment.clear();
		comment.sendKeys("SoWiBo is not just a software development house. 100 percent of our profits are used for social causes.");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/button"));
		btn.click();
		
		String message=email.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <103> failed: <no show error message when  email field with invalid data>");	
		}
//		else {
//			System.out.println("tcid 103 success");
//		}
//		
	
		
	}
	public void emptyEmailContactus() {
		WebElement contact,select,name,email,phnum,comment,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contact=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[4]/a"));
		contact.click();
		select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/select/option[2]"));
		select.click();
		name=driver.findElement(By.id("name"));
		name.clear();
		name.sendKeys("gopika");
		email=driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("");
		phnum=driver.findElement(By.id("phone"));
		phnum.clear();
		phnum.sendKeys("7592018435");
		comment=driver.findElement(By.id("comment"));
		comment.clear();
		comment.sendKeys("SoWiBo is not just a software development house. 100 percent of our profits are used for social causes.");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/button"));
		btn.click();
		
		String message=email.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <104> failed: <no show error message when empty email field>");	
		}
//		else {
//			System.out.println("tcid 104 success");
//		}
		
	}
	public void invalidPhnContactus() {
		WebElement contact,select,name,email,phnum,comment,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contact=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[4]/a"));
		contact.click();
		select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/select/option[2]"));
		select.click();
		name=driver.findElement(By.id("name"));
		name.clear();
		name.sendKeys("gopika");
		email=driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("gopikagopakumaran1@gmail.com");
		phnum=driver.findElement(By.id("phone"));
		phnum.clear();
		phnum.sendKeys("tdrd##2e44");
		comment=driver.findElement(By.id("comment"));
		comment.clear();
		comment.sendKeys("SoWiBo is not just a software development house. 100 percent of our profits are used for social causes.");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/button"));
		btn.click();
		
		String message=phnum.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <105> failed: <no show error message when  phone number field with invalid data>");	
		}
//		else {
//			System.out.println("tcid 105 success");
//		}
		
	}
	public void emptyPhnContact() {
		WebElement contact,select,name,email,phnum,comment,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contact=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[4]/a"));
		contact.click();
		select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/select/option[2]"));
		select.click();
		name=driver.findElement(By.id("name"));
		name.clear();
		name.sendKeys("gopika");
		email=driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("gopikagopakumaran1@gmail.com");
		phnum=driver.findElement(By.id("phone"));
		phnum.clear();
		phnum.sendKeys("");
		comment=driver.findElement(By.id("comment"));
		comment.clear();
		comment.sendKeys("SoWiBo is not just a software development house. 100 percent of our profits are used for social causes.");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/button"));
		btn.click();
		
		String message=phnum.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <106> failed: <no show error message when empty phone number field>");	
		}
//		else {
//			System.out.println("tcid 106 success");
//		}
	}
	public void emptyComment() {
		WebElement contact,select,name,email,phnum,comment,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contact=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[4]/a"));
		contact.click();
		select=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div/select/option[2]"));
		select.click();
		name=driver.findElement(By.id("name"));
		name.clear();
		name.sendKeys("gopika");
		email=driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("gopikagopakumaran1@gmail.com");
		phnum=driver.findElement(By.id("phone"));
		phnum.clear();
		phnum.sendKeys("7592018435");
		comment=driver.findElement(By.id("comment"));
		comment.clear();
		comment.sendKeys("");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/div[2]/form/button"));
		btn.click();
		
		String message=comment.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <107> failed: <no show error message when   empty comment field>");	
		}
//		else {
//			System.out.println("tcid 107 success");
//		}
	}
	
	public void invalidFname() {
		WebElement setting,account,fname,lname,phn,btn;
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();
		fname=driver.findElement(By.id("fname"));	
		fname.clear();
		fname.sendKeys("fderw434@##");
		String message=fname.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <108> failed: <no show error message when first name field with invalid data>");	
		}
//		else {
//			System.out.println("tcid 108 success");
//		}
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("gg");
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("7592018435");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		
//		
		
	}

	public void emptyFname() {
		WebElement setting,account,fname,lname,phn,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("");
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("gg");
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("7592018435");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();
		
		String message=fname.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			
			fail("TCID <109> failed: <no show error message when empty first name field>");	
		}
//		else {
//			
//			System.out.println("tcid 109 success");
//		}
//		
	}
	public void positivFname() {
		WebElement setting,account,fname,lname,phn,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("go");
		String message=fname.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
//			System.out.println("tcid 110 first positive success");
			
		}
		else {
			fail("TCID <110> failed: <no show error message when  first name field with 2 nymber data>");	
			
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname.clear();
		fname.sendKeys("gop");
		String message1=fname.getAttribute("validationMessage");
		if(message1.isEmpty()||message1.equals(null)) {
//			System.out.println("tcid 110 second positive success");
			
		}
		else {
			fail("TCID <110> failed: <no show error message when  first name field with 3 number data>");	
			
		}
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("gg");
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("7592018435");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		
	}
	public void negativeFname() {
		WebElement setting,account,fname,lname,phn,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("g");
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("gg");
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("7592018435");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();
		String message=fname.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <111> failed: <no show error message when  first name field with  1 number data>");
			
		}
//		else {
//				
//			System.out.println("tcid 111 negative test success");
//		}
		
	}
	
	public void invalidLname() {
		WebElement setting,account,fname,lname,phn,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("gopika");
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("21@@@3E");
		String message=lname.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <112> failed: <no show error message when last name with invalid data>");
		}
//		else {
//			System.out.println("tcid 112 success");
//		}
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("7592018435");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		
	}
	public void emptyLname() {
		
		WebElement setting,account,fname,lname,phn,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("gopika");
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("");
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("7592018435");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();
		String message=lname.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			
			fail("TCID <113> failed: <no show error message when empty last name field>");
		}	
//		else {
//			
//			System.out.println("tcid 113 success");
//		
//		}
		
	}
	public void positiveLname() {
		WebElement setting,account,fname,lname,phn,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("gopika");
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("gg");
		String message=lname.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
//			System.out.println("tcid 114 first positive success");
			
		}
		else {
			fail("TCID <110> failed: <no show error message when  last name field with 2 nymber data>");	
			
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lname.clear();
		lname.sendKeys("ggg");
		String message1=lname.getAttribute("validationMessage");
		if(message1.isEmpty()||message1.equals(null)) {
//			System.out.println("tcid 114 first positive success");
			
		}
		else {
			fail("TCID <110> failed: <no show error message when  last name field with 3 nymber>");	
			
		}
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("7592018435");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		
	}
	public void nagativeLname() {
		WebElement setting,account,fname,lname,phn,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("gopika");
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("g");
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("7592018435");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();
		String message=lname.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <115> failed: <no show error message when  first name field with  1 number data>");
			
		}
//		else {
//				
//			System.out.println("tcid 115 negative test success");
//		}
//		
	}
	public void invalidPhn() {
		WebElement setting,account,fname,lname,phn,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("gopika");
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("gg");
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("bdf@@#445");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();
		String message=phn.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <116> failed: <no show error message when phone number with invalid data>");
		}
//		else {
//			System.out.println("tcid 116 success");
//		}
//		
		
	}
	public void emptyPhn() {
		WebElement setting,account,fname,lname,phn,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("gopika");
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("gg");
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("");
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();
		String message=phn.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
			
			fail("TCID <117> failed: <no show error message when empty phone number field>");
		}	
//		else {
//			
//			System.out.println("tcid 117 success");
//		
//		}
	}
	public void positivephnum() {
		WebElement setting,account,fname,lname,phn,btn;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setting=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		setting.click();
		account=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		account.click();	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fname=driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("gopika");
		lname=driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("gg");
		phn=driver.findElement(By.id("phone"));
		phn.clear();
		phn.sendKeys("999999");
		String message=phn.getAttribute("validationMessage");
		if(message.isEmpty()||message.equals(null)) {
//			System.out.println("tcid 118 first positive success");
			
		}
		else {
			fail("TCID <118> failed: <no show error message when  phone number field with 6 nymber data>");	
			
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		phn.clear();
		phn.sendKeys("9999997");
		String message1=phn.getAttribute("validationMessage");
		if(message1.isEmpty()||message1.equals(null)) {
//			System.out.println("tcid 118 second positive success");
			
		}
		else {
			fail("TCID <118> failed: <no show error message when  phone number field with 6 nymber data>");	
			
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		phn.clear();
		phn.sendKeys("9999997896");
		String message2=phn.getAttribute("validationMessage");
		if(message2.isEmpty()||message2.equals(null)) {
//			System.out.println("tcid 118 third positive success");
			
		}
		else {
			fail("TCID <118> failed: <no show error message when  phone number field with 6 nymber data>");	
			
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		phn.clear();
		phn.sendKeys("9999992345");
		String message3=phn.getAttribute("validationMessage");
		if(message3.isEmpty()||message3.equals(null)) {
//			System.out.println("tcid 118 forth positive success");
			
		}
		else {
			fail("TCID <118> failed: <no show error message when  phone number field with 6 nymber data>");	
			
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btn=driver.findElement(By.xpath("/html/body/div/div/div/div/div[3]/div/div[2]/form/p[2]/button"));
		btn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		
		
	}
	
	public void logout() {
		WebElement logout;
		logout=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[2]/a"));
		logout.click();
	}
	
	
		
			
		
		
	
	
	
	
	 


	
}
