package automation;

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
			
		WebElement fullname,mobilenum,area,city,district,pin,landmark,delibtn;
		
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
	}
	//flat number fileld with input data in positive case
	
	public void FlatPositive() {
		
		WebElement flatnum,delibtn;
		
		flatnum=driver.findElement(By.name("house"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		flatnum.sendKeys("13B");
		delibtn.click();
		delibtn.clear();
		
		
		flatnum.sendKeys("133B");
		delibtn.click();
		delibtn.clear();
		 
		flatnum.sendKeys("133asedgtryhgfcdftresduhnbvdfrtukjnbvcdftyuiknhgfcxasertyuiokjB");
		delibtn.click();
		delibtn.clear();
		
		 
		flatnum.sendKeys("133asedgtryhgfcdftresduhnbvdfrtukjnbvcdftyuiknhgfcxasertyuiokjnB");
		delibtn.click();
		
		
	}

	//flat number fileld with input data in negative case
	
	public void FlatNegative() {
		
		WebElement flatnum,delibtn;
		
		
		flatnum=driver.findElement(By.name("house"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		flatnum.sendKeys("1");
		delibtn.click();
		delibtn.clear();
		
		
		flatnum.sendKeys("1B");
		delibtn.click();
		delibtn.clear();
		 
		flatnum.sendKeys("133asedgtryhgfcdftresduhnbvdfrtukjnbvcdftyuikbnhgfcxasertyuiokjnB");
		delibtn.click();
		delibtn.clear();
		
		 
		flatnum.sendKeys("133asedgtryhgfcdftresduhnbvdfrtukjnbvcdftyuiknhgfcxasertyuiokjnytB");
		delibtn.click();
		
		
		
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
		
		WebElement fullname,mobilenum,flatnum,city,district,pin,landmark,delibtn;
		
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
	}
	
	//Area fileld with input data in positive case
	
	public void AreaPositive() {
		
		WebElement area,delibtn;
		
		area=driver.findElement(By.name("area"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		area=driver.findElement(By.name("area"));
		area.sendKeys("AKG");
		delibtn.click();
		delibtn.clear();
		
		area=driver.findElement(By.name("area"));
		area.sendKeys("AKGN");
		delibtn.click();
		delibtn.clear();
		
		area=driver.findElement(By.name("area"));
		area.sendKeys("AKGsdaertgfvcsdertyujnbgfdsryuikjnbhgrtyuilmnbvse");
		delibtn.click();
		delibtn.clear();
		
		area=driver.findElement(By.name("area"));
		area.sendKeys("AKGsdaertgfvcsdertyujnbgfdsryuikjnbhgrtyuilmnbvseu");
		delibtn.click();
		
	}
	
	//Area fileld with input data in negative case4
	
	public void AreaNegative() {
		
		WebElement area,delibtn;
		
		area=driver.findElement(By.name("area"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		area=driver.findElement(By.name("area"));
		area.sendKeys("A");
		delibtn.click();
		delibtn.clear();
		
		area=driver.findElement(By.name("area"));
		area.sendKeys("AK");
		delibtn.click();
		delibtn.clear();
		
		area=driver.findElement(By.name("area"));
		area.sendKeys("AKGsdaertgfvcsdertyujnbgfdTsryuikjnbhgrtyuilmnbvseu");
		delibtn.click();
		delibtn.clear();
		
		area=driver.findElement(By.name("area"));
		area.sendKeys("AKGsdaertgfvTFcsdertyujnbgfdsryuikjnbhgrtyuilmnbvseu");
		delibtn.click();
	
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
		
		WebElement fullname,mobilenum,flatnum,area,district,pinnum,landmark,delibtn;
		
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
	}
	
	//City fileld with input data in positive case
	
	public void CityPositive() {
		
		WebElement city,delibtn;
		
		city=driver.findElement(By.name("city"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		city=driver.findElement(By.name("city"));
		city.sendKeys("Bal");
		delibtn.click();
	    delibtn.clear();
	    
	    city=driver.findElement(By.name("city"));
		city.sendKeys("Bala");
		delibtn.click();
	    delibtn.clear();
	    
	    city=driver.findElement(By.name("city"));
		city.sendKeys("Balarfderthbvfdaertyujnhfdertyuiolknhbvfseryuiopl");
		delibtn.click();
	    delibtn.clear();
	    
	    
	    city=driver.findElement(By.name("city"));
		city.sendKeys("Balarfderthbvfdaertyujnhfdertyuiolkmnhbvfseryuiopl");
		delibtn.click();
	    
	}
	//City fileld with input data in negative case
	
	public void CityNegative() {
	
	WebElement city,delibtn;
	
	city=driver.findElement(By.name("city"));
	delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
	
	city=driver.findElement(By.name("city"));
	city.sendKeys("B");
	delibtn.click();
    delibtn.clear();
    
    city=driver.findElement(By.name("city"));
	city.sendKeys("Ba");
	delibtn.click();
    delibtn.clear();
    
    city=driver.findElement(By.name("city"));
	city.sendKeys("Balarfderthbvfdaertyujnhfdertyuiolknhbvfseryuioplyt");
	delibtn.click();
    delibtn.clear();
    
    
    city=driver.findElement(By.name("city"));
	city.sendKeys("Balarfderthbvfdaertyujnhfdertyuiolkmnhbvfseryuioplyt");
	delibtn.click();

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
		WebElement fullname,mobilenum,flatnum,area,city,district,landmark,delibtn;
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
	
	//Landmark is Empty case
	
	public void LandEmpty() {
		WebElement fullname,mobilenum,area,flatnum,city,district,pin,delibtn;
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
		
		
		pin=driver.findElement(By.name("pin"));
		pin.sendKeys("605501");
		
		 
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();
	}
	//set primary address
//	public void SetPrimary() {
//		
//		WebElement fullname,mobilenum,area,flatnum,city,district,pin,landmark,delibtn,okbtn;
//		fullname=driver.findElement(By.name("fullname"));
//		fullname.sendKeys("neerajasnath");
//		
//		mobilenum=driver.findElement(By.name("mobile"));
//		mobilenum.sendKeys("8129481454");
//		
//		flatnum=driver.findElement(By.name("house"));
//		flatnum.sendKeys("13B");
//		
//		
//		area=driver.findElement(By.name("area"));
//		area.sendKeys("AKG Nagar,Peroorkada");
//		
//		city=driver.findElement(By.name("city"));
//		city.sendKeys("Peroorkada");
//		
//		district=driver.findElement(By.name("district"));
//		district.sendKeys("Trivandram");
//		
//		
//		pin=driver.findElement(By.name("pin"));
//		pin.sendKeys("605501");
//		
//		landmark=driver.findElement(By.name("landmark"));
//		landmark.sendKeys("Peroor Hospital");
//		
//		
//		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
//		delibtn.click();
//		
//		okbtn.click();
//	}
	
	
}
