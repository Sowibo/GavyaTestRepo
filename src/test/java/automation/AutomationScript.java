package automation;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.WatchEvent;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.protobuf.Empty;

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
	
	//****NEERAJA****
	
	public void Cookies() {
		WebElement cooki;
		cooki=driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/button"));
		cooki.click();
	}
	
	public void login() {
		
		
		WebElement login,submit,email,password;
		driver.get(Settings.getInstance().getProperty("url"));
		AutomationScript.returnobj().Cookies();
		login=driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div/div[2]/ul/li[1]/a"));
		login.click();
		email=driver.findElement(By.id("email"));
		email.sendKeys(Settings.getInstance().getProperty("email"));
		password=driver.findElement(By.id("password"));
		password.sendKeys(Settings.getInstance().getProperty("pass"));
		submit=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/div[2]/div[2]/button"));
		submit.click();
		
	}
	public void addProduct() {
		WebElement add;
		add = driver.findElement(By.className("col-lg-3 col-md-3 col-sm-4 col-xs-6 product-card"));
		add.click();
	}
	
	public void checkOut() {
		WebElement checkout;
		checkout = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[4]/div/div[3]/div/div[3]/div[1]/button"));
		checkout.click();
	}

	public void proceedCheck() {
		WebElement proceed;
		proceed = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div/div/button"));
		proceed.click();
	}
	
	//flat number filed empty
	
	public void flatEmpty() {
			
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

		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[6]"));
		String elementval = element.getText();

		if(elementval.equals(" ")||(elementval.equals(null))) {
			fail("TCID <147> failed: <no show error message when flat number field is empty>");
		}
			
	}
	//flat number fileld with input data in positive case
	
	public void flatPositive() {
		
		WebElement flatnum,delibtn,element;
		flatnum=driver.findElement(By.name("house"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		flatnum.sendKeys("133");
		delibtn.click();
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[6]]"));
		String elementval = element.getText();
		
		if(elementval.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <148> failed: <show error message when flat number with positive case>");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flatnum.clear();
		flatnum.sendKeys("1334");
		delibtn.click();
		String elementval1 = element.getText();
		
		if(elementval1.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <148> failed: <show error message when flat number with positive case>");
			
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flatnum.clear();
		flatnum.sendKeys("13657890876543213456789754326789065434567890543276890876543245678908765432");
		delibtn.click();
		String elementval2 = element.getText();
		
		if(elementval2.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <148> failed: <show error message when flat number with positive case>");
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flatnum.clear();
		flatnum.sendKeys("136576890876543213456789754326789065434567890543276890876543245678908765432");
		delibtn.click();
		String elementval3 = element.getText();
		
		if(elementval3.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <148> failed: <show error message when flat number with positive case>");
			
		}
		
	}

	//flat number fileld with input data in negative case
	
	public void flatNegative() {
		
		WebElement flatnum,delibtn,element;
		flatnum=driver.findElement(By.name("house"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		flatnum.sendKeys("13");
		delibtn.click();
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[6]]"));
		String elementval = element.getText();
		
		if(elementval.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <149> failed: <no show error message when  flat number length is incorrect >");
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flatnum.clear();
		flatnum.sendKeys("1376576890876543213456789754326789065434567890543276890876543245678908765432");
		delibtn.click();
		String elementvalue1 = element.getText();
		
		if(elementvalue1.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <149> failed: <no show error message when flat number length is not correct>");
		}
		
	}
	//Invalid Area
	
	public void areaInvalid() {
		WebElement area,delibtn;
		
		area=driver.findElement(By.name("area"));
		area.sendKeys("awwaww123");
	
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();
		
		String message=area.getAttribute("validationMessage");
		
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <150> failed: <no show error message when area filed with invalid data>");
			
		}
	}
	//Area Empty Case
	
	public void areaEmpty() {
		
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
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[8]"));
		String elementval = element.getText();

		if(elementval.equals(" ")||(elementval.equals(null))) {
			fail("TCID <151> failed: <no show error message when area field is empty>");
		}
	}
	
	//Area fileld with input data in positive case
	
	public void areaPositive() {
		
		WebElement area,delibtn,element;
		
		area=driver.findElement(By.name("area"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		area.sendKeys("Per");
		delibtn.click();
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[8]"));
		String elementval = element.getText();
		
		if(elementval.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <152> failed: <show error message when area field with positive case>");
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		area.clear();
		area.sendKeys("Pero");
		delibtn.click();
		String elementval1 = element.getText();
		
		if(elementval1.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <152> failed: <show error message when area field with positive case>");
		
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		area.clear();
		area.sendKeys("Peroredfthyuiolkmnbdertgvcxzaqwtryhbguioplmnhgfds");
		delibtn.click();
		String elementval2 = element.getText();
		
		if(elementval2.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <152> failed: <show error message when area field with positive case>");
			
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		area.clear();
		area.sendKeys("Peroredftuhyuiolkmnbdertgvcxzaqwtryhbguioplmnhgfds");
		delibtn.click();
		String elementval3 = element.getText();
		
		if(elementval3.equals(" ")||(elementval.equals(null))) {
			
		fail("TCID <152> failed: <show error message when area field with positive case>");
		}	
		
	}
	
	//Area fileld with input data in negative case4
	
	public void areaNegative() {
		
		WebElement area,delibtn,element;
		
		area=driver.findElement(By.name("area"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		area.sendKeys("Pe");
		delibtn.click();
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[8]"));
		String elementval = element.getText();
		
		if(elementval.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <153> failed: <no show error message when area field length is incorrect >");
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		area.clear();
		area.sendKeys("Perorepdftuhyuiolkmnbdertgvcxzaqwtryhbguioplmnhgfds");
		delibtn.click();
		String elementvalue1 = element.getText();
		
		if(elementvalue1.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <153> failed: <no show error message when area field is not correct>");
		}
		
	}
	//City Invalid

	public void cityInvalid() {
		
		WebElement city,delibtn;
		
		city=driver.findElement(By.name("city"));
		city.sendKeys("ABcDS");
		
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();
		
		String message=city.getAttribute("validationMessage");
		
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <154> failed: <no show error message when city filed with invalid data>");
			
		}
	}
	//City Empty
	
	public void cityEmpty() {
		
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
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[10]"));
		String elementval = element.getText();

		if(elementval.equals(" ")||(elementval.equals(null))) {
			fail("TCID <155> failed: <no show error message when city field is empty>");
		}
	}	
	
	//City fileld with input data in positive case
	
	public void cityPositive() {
		
		WebElement city,delibtn,element;
		
		city=driver.findElement(By.name("city"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		city.sendKeys("Tvm");
		delibtn.click();
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[10]"));
		String elementval = element.getText();
		
		if(elementval.equals(" ")||(elementval.equals(null)))  {
			
			fail("TCID <156> failed: <show error message when city field with positive case>");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		city.clear();
		city.sendKeys("Tvmp");
		delibtn.click();
		String elementval1 = element.getText();
		
		if(elementval1.equals(" ")||(elementval.equals(null)))  {
			
			fail("TCID <156> failed: <show error message when city field with positive case>");

		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		city.clear();
		city.sendKeys("Tvmptgfrtyujkmnbvswertyuiokmnhgvcxzswertyuiokmnhg");
		delibtn.click();
		String elementval2 = element.getText();
		
		if(elementval2.equals(" ")||(elementval.equals(null)))  {
			
			fail("TCID <156> failed: <show error message when city field with positive case>");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		city.clear();
		city.sendKeys("Tvmptgfrtyuujkmnbvswertyuiokmnhgvcxzswertyuiokmnhg");
		delibtn.click();
		String elementval3 = element.getText();
		
		if(elementval3.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <156> failed: <show error message when city field with positive case>");
			
		}
	}
	//City fileld with input data in negative case
	
	public void cityNegative() {
	
	WebElement city,delibtn,element;
	
	city=driver.findElement(By.name("city"));
	delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
	
	city.sendKeys("Tv");
	delibtn.click();
	
	element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[10]"));
	String elementval = element.getText();
	
	if(elementval.equals(" ")||(elementval.equals(null))) {
		
		fail("TCID <157> failed: <no show error message when city field length is incorrect >");
	}
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	city.clear();
	city.sendKeys("Tvmptgfrtyuujkmnbvswertyuiokmnhgvcxzswertyuiokmnhg");
	delibtn.click();
	String elementvalue1 = element.getText();
	
	if(elementvalue1.equals(" ")||(elementval.equals(null))) {
		
		fail("TCID <157> failed: <no show error message when city field length is not correct>");
	}
 }
	//All options available in district field
	
	public void districtAvailable() {
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
	
	public void districtDefault() {
		WebElement district,delibtn;
		
		district=driver.findElement(By.name("district"));
		district.sendKeys("Kollam");
		 
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();
		
		String message=district.getAttribute("DefaultMessage");
		
		
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <160> failed: <no show error message when district field with invalid data>");
			
		}
	}
	
	//Pin filed is Invalid case
	
	public void pinInvalid() {
		WebElement pinnum,delibtn;
		
		pinnum=driver.findElement(By.name("pin"));
		pinnum.sendKeys("6055");
		
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();
		
		String message=pinnum.getAttribute("validationMessage");
		
		
		if(message.isEmpty()||message.equals(null)) {
			fail("TCID <161> failed: <no show error message when pin field with invalid data>");
			
		}
	}
	
	//Pin filed is empty case
	
	public void pinEmpty() {
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
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[13]"));
		String elementval = element.getText();

		if(elementval.equals(" ")||(elementval.equals(null))) {
			fail("TCID <162> failed: <no show error message when pin field is empty>");
		}
	}
	
	
	//Pinfield positive case
	
	public void pinPositive() {
		
		WebElement pinnum,delibtn,element;
	
		pinnum=driver.findElement(By.name("pin"));
		pinnum.sendKeys("659901");
		
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.clear();
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[13]"));
		String elementval = element.getText();
		
		if(elementval.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <163> failed: <no show error message when pin field length is correct >");
		}
	}
	
	//Pinfield negative case
	
	public void pinNegative() {
		WebElement pinnum,delibtn,element;
	
		pinnum=driver.findElement(By.name("pin"));
		pinnum.sendKeys("659");
		
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.clear();
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[13]"));
		String elementval = element.getText();
		
		if(elementval.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <164> failed: <no show error message when pin field length is incorrect >");
		}
	}
	
	//Landmark is empty case
	
	public void landEmpty() {
		WebElement fullname,mobilenum,flatnum,area,city,district,pinnum,delibtn,element;
		
		fullname=driver.findElement(By.name("fullname"));
		fullname.sendKeys("neerajasnath");
		
		mobilenum=driver.findElement(By.name("mobile"));
		mobilenum.sendKeys("8129481454");
		
		flatnum=driver.findElement(By.name("house"));
		flatnum.sendKeys("13B");
		
		area=driver.findElement(By.name("area"));
		area.sendKeys("AK");
		
		city=driver.findElement(By.name("city"));
		city.sendKeys("Peroorkada");
		
	
	    district=driver.findElement(By.name("district"));
		district.sendKeys("Trivandram");
		
		pinnum=driver.findElement(By.name("pin"));
		pinnum.sendKeys("605501");
		
		 
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();
		
		element=driver.findElement(By.xpath("//*[@id=\"landmark\"]"));
		String elementval = element.getText();
		
		if(elementval.equals(" ")||(elementval.equals(null))) {
			
			fail("TCID <165> failed: <no show error message when landmark field is empty>");
		}
	}
	
	//Primary address with empty case
	
	public void primaryAddress() {
		
		WebElement fullname,mobilenum,flatnum,area,city,district,pinnum,landmark,delibtn;
		
		fullname=driver.findElement(By.name("fullname"));
		fullname.sendKeys("neerajasnath");
		
		mobilenum=driver.findElement(By.name("mobile"));
		mobilenum.sendKeys("8129481454");
		
		flatnum=driver.findElement(By.name("house"));
		flatnum.sendKeys("13B");
		
		area=driver.findElement(By.name("area"));
		area.sendKeys("AK");
		
		city=driver.findElement(By.name("city"));
		city.sendKeys("Peroorkada");
		
	
	    district=driver.findElement(By.name("district"));
		district.sendKeys("Trivandram");
		
		pinnum=driver.findElement(By.name("pin"));
		pinnum.sendKeys("605501");
		
		landmark=driver.findElement(By.name("landmark"));
		landmark.sendKeys("Peroor Hospital");
		
		
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();
		
		Alert alert=driver.switchTo().alert();
		alert.accept();
		if(alert.equals(null)) {
			fail("TCID <166> failed: <alert box not present");
		}
		
	}
	
	//Display Cookies
	
	public void displayCookies() {
		WebElement cookies;
		
		cookies=driver.findElement(By.className("col-lg-10 col-md-10 col-sm-12 col-xs-12"));
		cookies.sendKeys("We use cookies to enhance your experience. By continuing to visit this site, you agree to our use of cookies.");
		
	}
	
	//Confirm Order
	
	public void useAddress() {
		
		WebElement useaddress;
		
		useaddress=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[1]/div/div/button"));
		useaddress.click();
	}
	
	public void confirmOrder() {
		
		WebElement conforder;
		
		conforder=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div/div[4]/a"));
		conforder.click();
		
	}
	
	//Change Address
	
	public void changeAddress() {
		
		WebElement changeaddbtn;
		
		changeaddbtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div/p/a"));
		changeaddbtn.click();
	
	}
	
	//Change Order
	
	public void changeOrder() {
		
		WebElement changeorderbtn;
		
		changeorderbtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div/div[4]/p/a"));
		changeorderbtn.click();
		
	}
	
	//standard delivery option
	
	public void standDelivery() {
		WebElement standbtn;
		
		standbtn=driver.findElement(By.name("deliverytype"));
		standbtn.click();
	}
	
	//Fast Delivery
	
	public void fastDelivery() {
		WebElement fastbtn;
		
		fastbtn=driver.findElement(By.name("deliverytype"));
		fastbtn.click();
	}
	//Total amount shown in the cart page
	public void showTotal() {
		
		WebElement total1,total2;
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		total1=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[2]/p/span"));
		String value1=total1.getText();
		String value2="64.00";
		if(value1.equals(value2)) {
			
		 }
		 else {
			 fail("TCID <173> failed: Total value mismatch");
		 }
		
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		total2=driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div/div[3]/div/div[2]/p/span"));
		String value3=total2.getText();
		String value4="265.00";
		
		if(value3.equals(value4)) {
			
		 }
		 else {
			 fail("TCID <173> failed: Total value ");
		 }
		
	}

	
	
	
	
	
	
}
