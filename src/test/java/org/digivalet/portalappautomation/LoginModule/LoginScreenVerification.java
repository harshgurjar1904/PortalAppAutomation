package org.digivalet.portalappautomation.LoginModule;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.digivalet.portalappautomation.Setup.BaseClass;
import org.digivalet.portalappautomation.pageObject.android.LoginPage.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginScreenVerification extends BaseClass{
	
	private String correctEmail;
	private String correctPassword;
	private String incorrectEmail;
	private String incorrectPassword;
	
	@DataProvider
	public Object[][] getLoginData() throws IOException{
		
		List<HashMap<String,String>> data=getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\org\\digivalet\\portalappautomation\\LoginModule\\loginTestData.json");
		return new Object[][]{{data.get(0)}};
	}
	
	@Test(dataProvider="getLoginData",priority=1)
	public void setLoginData(HashMap<String,String> input) {
		correctEmail=input.get("emailAddress");
		correctPassword=input.get("password");
		incorrectEmail=input.get("incorrectEmailAddress");
		incorrectPassword=input.get("incorrectPassword");
	}
	
	//tap on login page without entering email address and password.
	@Test(priority=2)
	public void LoginWithoutEmailAndPassword() throws InterruptedException {
	LoginPage loginDriver=new LoginPage(driver);
	loginDriver.tapLoginButton();
	String emailError=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/email_error_text\"]")).getText();
	Assert.assertEquals(emailError,"Email address can't be blank.");
	}
	
	
	//tap on login page without entering password.
	@Test(priority=3)
	public void LoginWithoutPassword() throws InterruptedException {
		
		LoginPage loginDriver=new LoginPage(driver);
		loginDriver.sendEmailAddress(correctEmail);
		loginDriver.tapLoginButton();	
		String emailError=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/password_error_text\"]")).getText();
		Assert.assertEquals(emailError,"Password can't be blank.");
	}
	
	//tap on login page with entering incorrect email address and correct password.
	@Test(priority=4)
	public void LoginWithIncorrectEmailAndCorrectPassword() throws InterruptedException {

		LoginPage loginDriver=new LoginPage(driver);
		loginDriver.sendEmailAddress(incorrectEmail);
		loginDriver.sendPasssword(correctPassword);
		loginDriver.tapLoginButton();
		String invalidError=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/password_error_text\"]")).getText();
		Assert.assertEquals(invalidError,"Incorrect username or password.");
	}

	
	//tap on login page with entering correct email address and incorrect password.
	@Test(priority=5)
	public void LoginWithCorrectEmailAndIncorrectPassword() throws InterruptedException {

		LoginPage loginDriver=new LoginPage(driver);
		loginDriver.sendEmailAddress(correctEmail);
		loginDriver.sendPasssword(incorrectPassword);
		loginDriver.tapLoginButton();
		String invalidError=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/password_error_text\"]")).getText();
		Assert.assertEquals(invalidError,"Incorrect username or password.");
	}
	
	//tap on login page with entering correct email address and correct password.
	@Test(priority=6)
	public void LoginWithCorrectEmailAndCorrectPassword() throws InterruptedException {

		LoginPage loginDriver=new LoginPage(driver);
		loginDriver.sendEmailAddress(correctEmail);
		loginDriver.sendPasssword(correctPassword);
		loginDriver.tapLoginButton();
		loginDriver.allowPermission();
		
	}
		
	@Test(priority=7)
	public void successfulLoginValidation() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='More']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_feature_name\" and @text=\"Account\"]")).click();
		String getEmail=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/staff_email\"]")).getText();
		Assert.assertEquals(getEmail, correctEmail);
	}
	
}
