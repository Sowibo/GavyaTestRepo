package automation;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.ietf.jgss.Oid;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import dbcontroller.DbConnection;
import settings.Settings;
import webdriver.CustomWebDriver;

public class AutomationScript extends CustomWebDriver{
	WebElement add,check,pCheck,sendkey,email,pswd,btn;;
	public static AutomationScript returnobj() {
		return new AutomationScript();
		
		
	}
	public void launchUrl() {
		driver.get(Settings.getInstance().getProperty("url"));
	}
	
	//****NEERAJA****
	
	public void login() {
		sendkey=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		sendkey.click();
		email=driver.findElement(By.id("email"));
		email.sendKeys("neeraja@sowibo.com");
		pswd=driver.findElement(By.id("password"));
		pswd.sendKeys("neerajasnath");
		btn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div[1]/div[2]/div[2]/button"));
		btn.click();
	}
	public void addProduct() {
		add=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[4]/div/div[2]/div[2]/div[1]/button"));
		add.click();
	}
	public void checkOut() {
		check = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
		check.click();
		
	}
	
	public void proceedCheck() {
		WebElement pCheck;
		pCheck=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div/div/button"));
		pCheck.click();
	
	
	}
	//flat number filed empty
	
	public void FlatEmpty() {
			
		WebElement fullname,mobilenum,area,city,district,pin,landmark,delibtn,element;
		
		fullname=driver.findElement(By.name("fullname"));
		fullname.sendKeys("neerajasnath");
		
		mobilenum=driver.findElement(By.name("mobile"));
		mobilenum.sendKeys("8129481454");
		
		
		area=driver.findElement(By.name("area"));
		area.sendKeys("AKG Nagar,Peroorkada");
		
		city=driver.findElement(By.name("city"));
		city.sendKeys("Peroorkada");
		
		district=driver.findElement(By.name("district"));
		district.sendKeys("Trivandram");
		
		pin=driver.findElement(By.name("pin"));
		pin.sendKeys("605501");
		
		landmark=driver.findElement(By.name("landmark"));
		landmark.sendKeys("Peroor Hospital");
		 
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();

		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[5]"));
		String elementval = element.getText();
		String value="Must have atleast 3-75 character!";
		if(elementval.equals(value)) {
			System.out.println("TCID147 sucess");
		}
		else {
			
			fail("TCID <147> failed: <no show error message when flat number field is empty>");
		}
		
		
		
	}
	//flat number fileld with input data in positive case
	
	public void FlatPositive() {
		
		WebElement flatnum,delibtn;
		flatnum=driver.findElement(By.name("house"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		flatnum.sendKeys("133");
		delibtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		flatnum.clear();
		flatnum.sendKeys("1333");
		delibtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flatnum.clear();
		flatnum.sendKeys("13454565676787654567876545678908765456789056789065432467689087654567897654");
		delibtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flatnum.clear();
		flatnum.sendKeys("134545656676787654567876545678908765456789056789065432467689087654567897654");
		delibtn.click();

		
	}

	//flat number fileld with input data in negative case
	
	public void FlatNegative() {
		
		WebElement flatnum,delibtn,element;
		flatnum=driver.findElement(By.name("house"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		flatnum.sendKeys("13");
		btn.click();
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[5]"));
		String elementval = element.getText();
		String value="Must have atleast 3-75 character!";
		if(elementval.equals(value)) {
			System.out.println("TCID149 sucess");
		}
		else {
			
			fail("TCID <149> failed: <no show error message when phone number length is not correct>");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flatnum.clear();
		flatnum.sendKeys("1346545656676787654567876545678908765456789056789065432467689087654567897654");
		btn.click();
		String elementvalue = element.getText();
		String value1="Must have atleast 3-75 character!";
		if(elementvalue.equals(value1)) {
			System.out.println("TCID149 sucess");
		}
		else {
			
			fail("TCID <149> failed: <no show error message when phone number length is not correct>");
		}
		
	}
	//Invalid Area
	
	public void AreaInvalid() {
		WebElement area,delibtn;
		
		area=driver.findElement(By.name("area"));
		area.sendKeys("awwaww123");
	
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();
	}
	//Area Empty Case
	
	public void AreaEmpty() {
		
		WebElement fullname,mobilenum,flatnum,city,district,pin,landmark,delibtn,element;
		
		fullname=driver.findElement(By.name("fullname"));
		fullname.sendKeys("neerajasnath");
		
		mobilenum=driver.findElement(By.name("mobile"));
		mobilenum.sendKeys("8129481454");
		
		flatnum=driver.findElement(By.name("house"));
		flatnum.sendKeys("13B");
		
		
		city=driver.findElement(By.name("city"));
		city.sendKeys("Peroorkada");
		
		district=driver.findElement(By.name("district"));
		district.sendKeys("Trivandram");
		
		pin=driver.findElement(By.name("pin"));
		pin.sendKeys("605501");
		
		landmark=driver.findElement(By.name("landmark"));
		landmark.sendKeys("Peroor Hospital");
		 
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[7]"));
		String elementval = element.getText();
		String value="Must have atleast 3-50 character!";
		if(elementval.equals(value)) {
			System.out.println("TCID151 sucess");
		}
		else {
			
			fail("TCID <151> failed: <no show error message when area field is empty>");
		}
	}
	
	//Area fileld with input data in positive case
	
	public void AreaPositive() {
		
		WebElement area,delibtn;
		
		area=driver.findElement(By.name("area"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		area.sendKeys("Per");
		delibtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		area.clear();
		area.sendKeys("Pero");
		delibtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		area.clear();
		area.sendKeys("Perogtyfdcvghnbghjuytredfvbhjklpoiuytedscfrtyhnbg");
		delibtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		area.clear();
		area.sendKeys("Perogtyfducvghnbghjuytredfvbhjklpoiuytedscfrtyhnbg");
		delibtn.click();
		
	}
	
	//Area fileld with input data in negative case4
	
	public void AreaNegative() {
		
		WebElement area,delibtn,element;
		
		area=driver.findElement(By.name("area"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		area.sendKeys("Pe");
		delibtn.click();
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[7]"));
		String elementval = element.getText();
		String value="Must have atleast 3-50 character!";
		if(elementval.equals(value)) {
			System.out.println("TCID153 sucess");
		}
		else {
			
			fail("TCID <153> failed: <no show error message when area  length is not correct>");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		area.clear();
		area.sendKeys("Peroogtyfducvghnbghjuytredfvbhjklpoiuytedscfrtyhnbg");
		delibtn.click();
		String elementvalue = element.getText();
		String value1="Must have atleast 3-50 character!";
		if(elementvalue.equals(value1)) {
			System.out.println("TCID153 sucess");
		}
		else {
			
			fail("TCID <153> failed: <no show error message when area length is not correct>");
		}
	}
	//City Invalid

	public void CityInvalid() {
		
		WebElement city,delibtn;
		
		city=driver.findElement(By.name("city"));
		city.sendKeys("ABcDS");
		
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();
	}
	//City Empty
	
	public void CityEmpty() {
		
		WebElement fullname,mobilenum,flatnum,area,district,pinnum,landmark,delibtn,element;
		
		fullname=driver.findElement(By.name("fullname"));
		fullname.sendKeys("neerajasnath");
		
		mobilenum=driver.findElement(By.name("mobile"));
		mobilenum.sendKeys("8129481454");
		
		flatnum=driver.findElement(By.name("house"));
		flatnum.sendKeys("13B");
		
		area=driver.findElement(By.name("area"));
		area.sendKeys("AK");
	
		
		district=driver.findElement(By.name("district"));
		district.sendKeys("Trivandram");
		
		pinnum=driver.findElement(By.name("pin"));
		pinnum.sendKeys("605501");
		
		landmark=driver.findElement(By.name("landmark"));
		landmark.sendKeys("Peroor Hospital");
		 
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[9]"));
		String elementval = element.getText();
		String value="Must have atleast 3-50 character!";
		if(elementval.equals(value)) {
			System.out.println("TCID155 sucess");
		}
		else {
			
			fail("TCID <155> failed: <no show error message when city field is empty>");
		}
	}
	
	//City fileld with input data in positive case
	
	public void CityPositive() {
		
		WebElement city,delibtn;
		
		city=driver.findElement(By.name("city"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		city.sendKeys("Tvm");
		delibtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		city.clear();
		city.sendKeys("Tvmp");
		delibtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		city.clear();
		city.sendKeys("Tvmpredfrtuhnbgfdswertyuiolmjhnbfdwertyuioplmkhgf");
		delibtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		city.clear();
		city.sendKeys("Tvmpredfrtuhnbgfdswertyuiolmjhnbfdwertyuioplmkhgfy");
		delibtn.click();
	    
	}
	//City fileld with input data in negative case
	
	public void CityNegative() {
	
	WebElement city,delibtn,element;
	
	city=driver.findElement(By.name("city"));
	delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
	
	city.sendKeys("Tv");
	delibtn.click();
	element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[9]"));
	String elementval = element.getText();
	String value="Must have atleast 3-50 character!";
	if(elementval.equals(value)) {
		System.out.println("TCID157 sucess");
	}
	else {
		
		fail("TCID <157> failed: <no show error message when city length is not correct>");
	}
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	city.clear();
	city.sendKeys("Tvmpredf7rtuhnbgfdswertyuiolmjhnbfdwertyuioplmkhgfy");
	delibtn.click();
	String elementvalue = element.getText();
	String value1="Must have atleast 3-50 character!";
	if(elementvalue.equals(value1)) {
		System.out.println("TCID157 sucess");
	}
	else {
		
		fail("TCID <157> failed: <no show error message when area length is not correct>");
	}

	}
	//All options available in district field
	
	public void DistrictAvailable() {
		WebElement district,delibtn;
		
		district=driver.findElement(By.name("district"));
		district.sendKeys("Trivandram");
		
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();
	
	}
	//All options selected in district field
	
	public void DistrictSelection() {
		
		Select district;
		WebElement delibtn;
		
		district=new Select(driver.findElement(By.name("district")));
		district.selectByVisibleText("Trivandram");
		
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();
	}
	
	//District field Default
	
	public void DistrictDefault() {
		
		WebElement fullname,mobilenum,area,flatnum,city,pin,landmark,delibtn;
		
		fullname=driver.findElement(By.name("fullname"));
		fullname.sendKeys("neerajasnath");
		
		mobilenum=driver.findElement(By.name("mobile"));
		mobilenum.sendKeys("8129481454");
		
		flatnum=driver.findElement(By.name("house"));
		flatnum.sendKeys("13B");
		
		
		area=driver.findElement(By.name("area"));
		area.sendKeys("AKG Nagar,Peroorkada");
		
		city=driver.findElement(By.name("city"));
		city.sendKeys("Peroorkada");
		
		pin=driver.findElement(By.name("pin"));
		pin.sendKeys("605501");
		
		landmark=driver.findElement(By.name("landmark"));
		landmark.sendKeys("Peroor Hospital");
		 
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();
	}
	
	//Pin filed is Invalid case
	
	public void PinInvalid() {
		WebElement pinnum,delibtn;
		
		pinnum=driver.findElement(By.name("pin"));
		pinnum.sendKeys("6055");
	}
	
	//Pin filed is empty case
	
	public void PinEmpty() {
		WebElement fullname,mobilenum,flatnum,area,city,district,landmark,delibtn,element;
		fullname=driver.findElement(By.name("fullname"));
		fullname.sendKeys("neerajasnath");
		
		mobilenum=driver.findElement(By.name("mobile"));
		mobilenum.sendKeys("8129481454");
		
		flatnum=driver.findElement(By.name("house"));
		flatnum.sendKeys("13B");
		
		area=driver.findElement(By.name("area"));
		area.sendKeys("AKG Nagar,Peroorkada");
		
		city=driver.findElement(By.name("city"));
		city.sendKeys("Peroorkada");
		
		district=driver.findElement(By.name("district"));
		district.sendKeys("Trivandram");
		
		landmark=driver.findElement(By.name("landmark"));
		landmark.sendKeys("Peroor Hospital");
		 
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[12]"));
		String elementval = element.getText();
		String value="Enter a valid PIN number";
		if(elementval.equals(value)) {
			System.out.println("TCID162 sucess");
		}
		else {
			
			fail("TCID <162> failed: <no show error message when pin numnber filed is empty>");
		}
	}
	
	
	//Pinfield positive case
	
	public void PinPositive() {
		
		WebElement pinnum,delibtn;
	
		pinnum=driver.findElement(By.name("pin"));
		pinnum.sendKeys("659901");
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.clear();
	}
	
	//Pinfield negative case
	
	public void PinNegative() {
		WebElement pinnum,delibtn;
	
		pinnum=driver.findElement(By.name("pin"));
		pinnum.sendKeys("659");
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.clear();
	}
	

}
