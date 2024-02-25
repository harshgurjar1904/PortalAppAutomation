package org.digivalet.portalappautomation.pageObject.android.LoginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	
	AndroidDriver driver;
	public LoginPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
//	driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.paragon.sensonicstaff:id/label_email_address\"]")).sendKeys(emailAddress); 
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\"com.paragon.sensonicstaff:id/label_email_address\"]")
	private WebElement emailFieldLocator;

	

//	driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.paragon.sensonicstaff:id/label_password\"]")).sendKeys(password);
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\"com.paragon.sensonicstaff:id/label_password\"]")
	private WebElement passwordlocator;
	

//	driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/btn_login\"]")).click();	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/btn_login\"]")
	private WebElement loginButtonLocator;
	
//	driver.findElement(By.xpath(".//android.widget.Button[@text='Allow']")).click();
	@AndroidFindBy(xpath=".//android.widget.Button[@text='Allow']")
	private WebElement allowPermissionLocator;
	
	
	public void sendEmailAddress(String emailAddress) {
		emailFieldLocator.sendKeys(emailAddress);
	}

	public void sendPasssword(String password) {
		passwordlocator.sendKeys(password);
	}
	
	public void tapLoginButton() {
		loginButtonLocator.click();
	}
	
	public void allowPermission() {
		allowPermissionLocator.click();
	}
	
}
