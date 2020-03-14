package automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
	
//		KEERTHI
	

	public void logIn(){
		WebElement settings,accounts,numfield,login,logid,logpass,logbtn;
		login=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		login.click();
		logid=driver.findElement(By.id("email"));
		logid.sendKeys("keerthisudev444@gmail.com");		
		logpass=driver.findElement(By.xpath("password"));
		logpass.sendKeys("keerthisudev");		
		logbtn=driver.findElement(By.cssSelector("div.row:nth-child(2) > div:nth-child(2) > div:nth-child(2) > button:nth-child(1)"));
		logbtn.click();
	}
	
//		LOGOUT
	
	public void logOut() {
		WebElement logout;		
		logout = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/ul/li[2]/a"));
		logout.click();
	}
	
//		SETTINGS
	
	public void settingsPage() {
		WebElement settings;		
		settings=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[1]/div/div/div[2]/ul/li[3]/a"));
		settings.click();
	}
	
//		ACCOUNTS
	
	public void accountsSection() {
		WebElement accounts;		
		accounts=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[1]/div/ul/li[2]/p"));
		accounts.click();
	}
	
	
//			FUNCTIONS NEEDED FOR TCID 119 
//			login,settingsPage,accountsSection
		
	public void testPhoneNumber() {
		WebElement numfield,updatebtn;		
		numfield=driver.findElement(By.xpath("//*[@id=\"phone\"]"));
		numfield.sendKeys("9999998");	
		updatebtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/form/p[2]/button"));
		updatebtn.click();	
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		numfield.clear();
		numfield.sendKeys("100000000000");
		updatebtn.click();
	}
	
	
//			FUNCTIONS NEEDED FOR TCID 120 
	
//			login,settings ,accounts
	public void testValidData() {		
		WebElement fname,lname,pnum,updatebtn;		
		fname = driver.findElement(By.id("fname"));
		fname.sendKeys("keerthi");		
		lname = driver.findElement(By.id("lname"));
		lname.sendKeys("sudev");		
		pnum = driver.findElement(By.id("phone"));
		pnum.sendKeys("8137006670");		
		updatebtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/form/p[2]/button"));
		updatebtn.click();	
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	
//			FUNCTIONS NEEDED FOR TCID 121
//	login,settings, acoount,logout
	public void checkUpdate() {
		WebElement fname,lname,pnum,updatebtn;	
		fname = driver.findElement(By.id("fname"));
		fname.sendKeys("keerthi");		
		lname = driver.findElement(By.id("lname"));
		lname.sendKeys("sudev");		
		pnum = driver.findElement(By.id("phone"));
		pnum.sendKeys("8137006670");		
		updatebtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/form/p[2]/button"));
		updatebtn.click();		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
	}
	
//	FUNCTIONS NEEDED FOR TCID 122
//	login,settings,accounts,chngpass 
	public void changePass() {
	WebElement chngpass	;
	chngpass = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[1]/div/ul/li[1]/p"));
	chngpass.click();
	}	

	public void currentValidPass() {
		WebElement chngpass,crntpass,newpass,conpass;

		crntpass = driver.findElement(By.id("oldpassword"));
		crntpass.sendKeys("keerthisudev");
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthikeerthi");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthikeerthi");
//		ivide button add cheyyanam
	}


//		FUNCTIONS NEEDED FOR TCID 123
//		login ,settings, changepass

	public void currentInvalidPass() {
		WebElement crntpass,newpass,conpass;
		crntpass = driver.findElement(By.id("oldpassword"));
		crntpass.sendKeys("invalidpass");
		newpass = driver.findElement(By.id("password"));
		newpass.sendKeys("keerthikeerthi");
		conpass = driver.findElement(By.id("confirmpassword"));
		conpass.sendKeys("keerthikeerthi");
//	ivide button add cheyyanam
}

//		FUNCTIONS NEEDED FOR TCID 124

//		FUNCTIONS NEEDED FOR TCID 132
//		login,settings,changepass
		public void currentPassEmpty() {			
			WebElement crntpass,newpass,conpass;		
			newpass = driver.findElement(By.id("password"));
			newpass.sendKeys("keerthikeerthi");			
			conpass = driver.findElement(By.id("confirmpassword"));
			conpass.sendKeys("keerthikeerthi");
//			ivide button add cheyyanam		
		}


//		FUNCTIONS NEEDED FOR TCID 133
//		SETTINGS,CHANGEPASS	
	
		public void confirmPassEmpty() {
			WebElement crntpass,newpass,conpass;

			crntpass = driver.findElement(By.id("oldpassword"));
			crntpass.sendKeys("keerthisudev");
			newpass = driver.findElement(By.id("password"));
			newpass.sendKeys("keerthikeerthi");			
		//	ivide button add cheyyanam
		}

//		FUNCTIONS NEEDED FOR TCID 134
		
		public void newPassEmpty() {
			WebElement crntpass,newpass,conpass;
//			SETTINGS
//			CHANGEPASS
			crntpass = driver.findElement(By.id("oldpassword"));
			crntpass.sendKeys("keerthisudev");
			conpass = driver.findElement(By.id("confirmpassword"));
			conpass.sendKeys("keerthikeerthi");
//			ivide button add cheyyanam
		}

//		FUNCTIONS NEEDED FOR TCID 135
		
		public void addProduct() {
			WebElement add;
			add = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[4]/div/div[2]/div[2]/div[1]/button"));
			add.click();
		}
		
		public void checkOut() {
			WebElement checkout;
			checkout = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
			checkout.click();
		}

		public void proceedCheckOut() {
			WebElement proceed;
			proceed = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div/div/button"));
			proceed.click();
		}
		
		public void useAddress() {
			WebElement useadrs,conordr;
			useadrs = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[1]/div/div/button"));
			useadrs.click();
//			conordr = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div/div[4]/a"));
//			conordr.click();
		}

//		FUNCTIONS NEEDED FOR TCID 136	
//		call addProduct,checkout,proceedcheckout
		
		public void removeAddress() {
			WebElement remove;

			remove = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[1]/div/div/h5/a"));
			remove.click();	
		}
		
//		FUNCTIONS NEEDED FOR TCID 137		
//		call addProduct,checkout,proceedcheckout
		
		public void validDetails() {
			WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;			
			fname = driver.findElement(By.id("fullname"));
			fname.sendKeys("keerthisudev");			
			mnum = driver.findElement(By.id("mobile"));
			mnum.sendKeys("8593026651");			
			flatnum = driver.findElement(By.id("house"));
			flatnum.sendKeys("myhome123");		
			area = driver.findElement(By.id("area"));
			area.sendKeys("akg nagar peroorkkada");		
			city =  driver.findElement(By.id("city"));
			city.sendKeys("Thiruvananthapuram");	
			district = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/select"));
			district.sendKeys("Trivandrum");		
			pin = driver.findElement(By.id("pin"));
			pin.sendKeys("695020");
			lmark = driver.findElement(By.id("landmark"));
			lmark.sendKeys("near hss school");
			deliverbtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
			deliverbtn.click();
		}
		
//		FUNCTIONS NEEDED FOR TCID 138		
//		call addProduct,checkout,proceedcheckout
		
		public void invalidFullName() {
			WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;		
			fname = driver.findElement(By.id("fullname"));
			fname.sendKeys("k1234");		
			mnum = driver.findElement(By.id("mobile"));
			mnum.sendKeys("8593026651");		
			flatnum = driver.findElement(By.id("house"));
			flatnum.sendKeys("myhome123");	
			area = driver.findElement(By.id("area"));
			area.sendKeys("akg nagar peroorkkada");	
			city =  driver.findElement(By.id("city"));
			city.sendKeys("Thiruvananthapuram");
			district = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/select"));
			district.sendKeys("Trivandrum");			
			pin = driver.findElement(By.id("pin"));
			pin.sendKeys("695020");			
			lmark = driver.findElement(By.id("landmark"));
			lmark.sendKeys("near hss school");			
			deliverbtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
			deliverbtn.click();			
		}
//			FUNCTIONS NEEDED FOR TCID 139

		public void emptyFullName() {			
			WebElement mnum,flatnum,area,city,district,pin,lmark,deliverbtn;		
			mnum = driver.findElement(By.id("mobile"));
			mnum.sendKeys("8593026651");		
			flatnum = driver.findElement(By.id("house"));
			flatnum.sendKeys("myhome123");		
			area = driver.findElement(By.id("area"));
			area.sendKeys("akg nagar peroorkkada");			
			city =  driver.findElement(By.id("city"));
			city.sendKeys("Thiruvananthapuram");			
			district = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/select"));
			district.sendKeys("Trivandrum");			
			pin = driver.findElement(By.id("pin"));
			pin.sendKeys("695020");		
			lmark = driver.findElement(By.id("landmark"));
			lmark.sendKeys("near hss school");		
			deliverbtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
			deliverbtn.click();		
		}
		
		
//		FUNCTIONS NEEDED FOR TCID 142		
//		call addProduct,checkout,proceedcheckout
		
		public void invalidMobileNumber() {		
			WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;
			fname = driver.findElement(By.id("fullname"));
			fname.sendKeys("keerthisudev");			
			mnum = driver.findElement(By.id("mobile"));
			mnum.sendKeys("122");			
			flatnum = driver.findElement(By.id("house"));
			flatnum.sendKeys("myhome123");			
			area = driver.findElement(By.id("area"));
			area.sendKeys("akg nagar peroorkkada");			
			city =  driver.findElement(By.id("city"));
			city.sendKeys("Thiruvananthapuram");			
			district = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/select"));
			district.sendKeys("Trivandrum");			
			pin = driver.findElement(By.id("pin"));
			pin.sendKeys("695020");			
			lmark = driver.findElement(By.id("landmark"));
			lmark.sendKeys("near hss school");			
			deliverbtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
			deliverbtn.click();	
		}
		
		
//		FUNCTIONS NEEDED FOR TCID 143		
//		call addProduct,checkout,proceedcheckout
		
		public void emptyMobileNumber() {
			WebElement fname,flatnum,area,city,district,pin,lmark,deliverbtn;			
			fname = driver.findElement(By.id("fullname"));
			fname.sendKeys("keerthisudev");			
			flatnum = driver.findElement(By.id("house"));
			flatnum.sendKeys("myhome123");			
			area = driver.findElement(By.id("area"));
			area.sendKeys("akg nagar peroorkkada");			
			city =  driver.findElement(By.id("city"));
			city.sendKeys("Thiruvananthapuram");
			district = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/select"));
			district.sendKeys("Trivandrum");		
			pin = driver.findElement(By.id("pin"));
			pin.sendKeys("695020");		
			lmark = driver.findElement(By.id("landmark"));
			lmark.sendKeys("near hss school");	
			deliverbtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
			deliverbtn.click();		
		}
//		144
		
		public void mobileNumberLenPositive() {
			WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;			
			fname = driver.findElement(By.id("fullname"));
			fname.sendKeys("keerthisudev");		
			mnum = driver.findElement(By.id("mobile"));
			mnum.sendKeys("999999");
			flatnum = driver.findElement(By.id("house"));
			flatnum.sendKeys("myhome123");			
			area = driver.findElement(By.id("area"));
			area.sendKeys("akg nagar peroorkkada");			
			city =  driver.findElement(By.id("city"));
			city.sendKeys("Thiruvananthapuram");
			district = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/select"));
			district.sendKeys("Trivandrum");		
			pin = driver.findElement(By.id("pin"));
			pin.sendKeys("695020");		
			lmark = driver.findElement(By.id("landmark"));
			lmark.sendKeys("near hss school");	
			deliverbtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
			deliverbtn.click();		
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			mnum.clear();
			mnum.sendKeys("100000000000000");
			deliverbtn.click();
			
		}
		
//		145
		
		public void mobileNumberLenNegative() {
			WebElement fname,mnum,flatnum,area,city,district,pin,lmark,deliverbtn;			
			fname = driver.findElement(By.id("fullname"));
			fname.sendKeys("keerthisudev");		
			mnum = driver.findElement(By.id("mobile"));
			mnum.sendKeys("99999");
			flatnum = driver.findElement(By.id("house"));
			flatnum.sendKeys("myhome123");			
			area = driver.findElement(By.id("area"));
			area.sendKeys("akg nagar peroorkkada");			
			city =  driver.findElement(By.id("city"));
			city.sendKeys("Thiruvananthapuram");
			district = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/select"));
			district.sendKeys("Trivandrum");		
			pin = driver.findElement(By.id("pin"));
			pin.sendKeys("695020");		
			lmark = driver.findElement(By.id("landmark"));
			lmark.sendKeys("near hss school");	
			deliverbtn = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
			deliverbtn.click();		
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			mnum.clear();
			mnum.sendKeys("1000000000000000");
			deliverbtn.click();
		}
			
}
	