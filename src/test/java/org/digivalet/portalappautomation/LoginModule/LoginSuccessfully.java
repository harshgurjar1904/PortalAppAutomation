package org.digivalet.portalappautomation.LoginModule;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.digivalet.portalappautomation.Setup.BaseClass;
import org.digivalet.portalappautomation.pageObject.android.LoginPage.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginSuccessfully extends BaseClass{
	
	@DataProvider
	public Object[][] getLoginData() throws IOException{
		
		List<HashMap<String,String>> data=getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\org\\digivalet\\portalappautomation\\LoginModule\\loginTestData.json");
		return new Object[][]{{data.get(0)}};
	}
	
	@Test(dataProvider="getLoginData",priority=1)
	public void SuccessfullLogin(HashMap<String,String> input) throws InterruptedException{
		LoginPage  loginPage=new LoginPage(driver);
		
	
//		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.paragon.sensonicstaff:id/label_email_address\"]")).sendKeys(emailAddress); 
		loginPage.sendEmailAddress(input.get("emailAddress"));
				
//		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.paragon.sensonicstaff:id/label_password\"]")).sendKeys(password);
		loginPage.sendPasssword(input.get("password"));
		
//		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/btn_login\"]")).click();
		loginPage.tapLoginButton();

//		driver.findElement(By.xpath(".//android.widget.Button[@text='Allow']")).click();
		loginPage.allowPermission();
	}
}
