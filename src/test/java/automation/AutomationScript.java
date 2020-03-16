package automation;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.WatchEvent;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.protobuf.Empty;

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

		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[6]"));
		String elementval = element.getText();

		if(elementval.equals(" ")) {
			fail("TCID <147> failed: <no show error message when flat number field is empty>");
		}
		else {
			
			
			System.out.println("TCID147 success");
		}
		
		
		
	}
	//flat number fileld with input data in positive case
	
	public void FlatPositive() {
		
		WebElement flatnum,delibtn,element;
		flatnum=driver.findElement(By.name("house"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		flatnum.sendKeys("133");
		delibtn.click();
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[6]]"));
		String elementval = element.getText();
		
		if(elementval.equals(" ")) {
			
			System.out.println("TCID148 sucess 1 test case");
		}
		else {
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
		
		if(elementval1.equals(" ")) {
			
			System.out.println("TCID148 sucess 2 test case");
		}
		else {
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
		
		if(elementval2.equals(" ")) {
			
			System.out.println("TCID148 sucess 3 test case");
		}
		else {
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
		
		if(elementval3.equals(" ")) {
			
			System.out.println("TCID148 sucess 4 test case");
		}
		else {
			fail("TCID <148> failed: <show error message when flat number with positive case>");
			
		}
		
	}

	//flat number fileld with input data in negative case
	
	public void FlatNegative() {
		
		WebElement flatnum,delibtn,element;
		flatnum=driver.findElement(By.name("house"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		flatnum.sendKeys("13");
		btn.click();
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[6]]"));
		String elementval = element.getText();
		
		if(elementval.equals(" ")) {
			
			fail("TCID <149> failed: <no show error message when  flat number length is incorrect >");
		}
		else {
			
			System.out.println("TCID149 sucess test case1");
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
		
		if(elementvalue1.equals(" ")) {
			
			fail("TCID <149> failed: <no show error message when flat number length is not correct>");
		}
		else {
			
			System.out.println("TCID149 sucess test case2");
		}
		
	}
	//Invalid Area
	
	public void AreaInvalid() {
		WebElement area,delibtn;
		
		area=driver.findElement(By.name("area"));
		area.sendKeys("awwaww123");
	
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();
		
		String message=area.getAttribute("validationMessage");
		
		
		if(message.isEmpty()) {
			fail("TCID <150> failed: <no show error message when area filed with invalid data>");
			
		}
		else {
			System.out.println("TCID150 success");
		}
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
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[8]"));
		String elementval = element.getText();

		if(elementval.equals(" ")) {
			fail("TCID <151> failed: <no show error message when area field is empty>");
		}
		else {
			
			
			System.out.println("TCID151 success");
		}
	}
	
	//Area fileld with input data in positive case
	
	public void AreaPositive() {
		
		WebElement area,delibtn,element;
		
		area=driver.findElement(By.name("area"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		area.sendKeys("Per");
		delibtn.click();
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[8]"));
		String elementval = element.getText();
		
		if(elementval.equals(" ")) {
			
			System.out.println("TCID152 sucess 1 test case");
		}
		else {
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
		
		if(elementval1.equals(" ")) {
			
			System.out.println("TCID152 sucess 2 test case");
		}
		else {
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
		
		if(elementval2.equals(" ")) {
			
			System.out.println("TCID152 sucess 3 test case");
		}
		else {
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
		
		if(elementval3.equals(" ")) {
			
			System.out.println("TCID152 sucess 4 test case");
		}
		else {
			fail("TCID <152> failed: <show error message when area field with positive case>");
			
		}
	}
	
	//Area fileld with input data in negative case4
	
	public void AreaNegative() {
		
		WebElement area,delibtn,element;
		
		area=driver.findElement(By.name("area"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		area.sendKeys("Pe");
		delibtn.click();
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[8]"));
		String elementval = element.getText();
		
		if(elementval.equals(" ")) {
			
			fail("TCID <153> failed: <no show error message when area field length is incorrect >");
		}
		else {
			
			System.out.println("TCID153 sucess test case1");
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
		
		if(elementvalue1.equals(" ")) {
			
			fail("TCID <153> failed: <no show error message when area field is not correct>");
		}
		else {
			
			System.out.println("TCID153 sucess test case2");
		}
	}
	//City Invalid

	public void CityInvalid() {
		
		WebElement city,delibtn;
		
		city=driver.findElement(By.name("city"));
		city.sendKeys("ABcDS");
		
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();
		
		String message=city.getAttribute("validationMessage");
		
		
		if(message.isEmpty()) {
			fail("TCID <154> failed: <no show error message when city filed with invalid data>");
			
		}
		else {
			System.out.println("TCID154 success");
		}
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
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[10]"));
		String elementval = element.getText();

		if(elementval.equals(" ")) {
			fail("TCID <155> failed: <no show error message when city field is empty>");
		}
		else {
			
			
			System.out.println("TCID155 success");
		}
	}
	
	//City fileld with input data in positive case
	
	public void CityPositive() {
		
		WebElement city,delibtn,element;
		
		city=driver.findElement(By.name("city"));
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		
		city.sendKeys("Tvm");
		delibtn.click();
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[10]"));
		String elementval = element.getText();
		
		if(elementval.equals(" ")) {
			
			System.out.println("TCID156 sucess 1 test case");
		}
		else {
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
		
		if(elementval1.equals(" ")) {
			
			System.out.println("TCID156 sucess 2 test case");
		}
		else {
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
		
		if(elementval2.equals(" ")) {
			
			System.out.println("TCID156 sucess 3 test case");
		}
		else {
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
		
		if(elementval3.equals(" ")) {
			
			System.out.println("TCID156 sucess 4 test case");
		}
		else {
			fail("TCID <156> failed: <show error message when city field with positive case>");
			
		}
	}
	//City fileld with input data in negative case
	
	public void CityNegative() {
	
	WebElement city,delibtn,element;
	
	city=driver.findElement(By.name("city"));
	delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
	
	city.sendKeys("Tv");
	delibtn.click();
	
	element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[10]"));
	String elementval = element.getText();
	
	if(elementval.equals(" ")) {
		
		fail("TCID <157> failed: <no show error message when city field length is incorrect >");
	}
	else {
		
		System.out.println("TCID157 sucess test case1");
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
	
	if(elementvalue1.equals(" ")) {
		
		fail("TCID <157> failed: <no show error message when city field length is not correct>");
	}
	else {
		
		System.out.println("TCID157 sucess test case2");
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
		WebElement district,delibtn;
		
		district=driver.findElement(By.name("district"));
		district.sendKeys("Kollam");
		 
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();
		
		String message=district.getAttribute("DefaultMessage");
		
		
		if(message.isEmpty()) {
			fail("TCID <160> failed: <no show error message when district field with invalid data>");
			
		}
		else {
			System.out.println("TCID160 success");
		}
	}
	
	//Pin filed is Invalid case
	
	public void PinInvalid() {
		WebElement pinnum,delibtn;
		
		pinnum=driver.findElement(By.name("pin"));
		pinnum.sendKeys("6055");
		
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.click();
		
		String message=pinnum.getAttribute("validationMessage");
		
		
		if(message.isEmpty()) {
			fail("TCID <161> failed: <no show error message when pin field with invalid data>");
			
		}
		else {
			System.out.println("TCID161 success");
		}
		
		
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
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[13]"));
		String elementval = element.getText();

		if(elementval.equals(" ")) {
			fail("TCID <162> failed: <no show error message when pin field is empty>");
		}
		else {
			
			
			System.out.println("TCID162 success");
		}
	}
	
	
	//Pinfield positive case
	
	public void PinPositive() {
		
		WebElement pinnum,delibtn,element;
	
		pinnum=driver.findElement(By.name("pin"));
		pinnum.sendKeys("659901");
		
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.clear();
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[13]"));
		String elementval = element.getText();
		
		if(elementval.equals(" ")) {
			
			System.out.println("TCID163 sucess  test case");
		}
		else {
			fail("TCID <163> failed: <show error message when pin field with length is positive case>");
			
		}
	}
	
	//Pinfield negative case
	
	public void PinNegative() {
		WebElement pinnum,delibtn,element;
	
		pinnum=driver.findElement(By.name("pin"));
		pinnum.sendKeys("659");
		
		delibtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/input[8]"));
		delibtn.clear();
		
		element=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[2]/form/p[13]"));
		String elementval = element.getText();
		
		if(elementval.equals(" ")) {
			
			fail("TCID <164> failed: <no show error message when pin field length is incorrect >");
		}
		else {
			System.out.println("TCID164 sucess test case");
		}
	}
	
	//Landmark is empty case
	
	public void LandEmpty() {
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
		
		if(elementval.equals(" ")) {
			
			fail("TCID <165> failed: <no show error message when landmark field is empty>");
		}
		else {
			System.out.println("TCID165 sucess");
			
		}
		
	}
	
	//Primary address with empty case
	
	public void PrimaryAddress() {
		
		WebElement fullname,mobilenum,flatnum,area,city,district,pinnum,landmark,delibtn,okbtn=null;
		
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
		
		okbtn.click();
	
	}
	//Display Cookies
	
	public void DisplayCookies() {
		WebElement cookies;
		
		cookies=driver.findElement(By.className("col-lg-10 col-md-10 col-sm-12 col-xs-12"));
		cookies.sendKeys("We use cookies to enhance your experience. By continuing to visit this site, you agree to our use of cookies.");
		
	}
	
	//Confirm Order
	
	public void UseAddress() {
		
		WebElement useaddress;
		
		useaddress=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div[2]/div[1]/div/div/button"));
		useaddress.click();
	}
	
	public void ConfirmOrder() {
		
		WebElement conforder;
		
		conforder=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div/div[4]/a"));
		conforder.click();
		
	}
	
	//Change Address
	
	public void ChangeAddress() {
		
		WebElement changeaddbtn;
		
		changeaddbtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div/p/a"));
		changeaddbtn.click();
	
	}
	
	//Change Order
	
	public void ChangeOrder() {
		
		WebElement changeorderbtn;
		
		changeorderbtn=driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[3]/div/div/div[4]/p/a"));
		changeorderbtn.click();
		
	}
}
