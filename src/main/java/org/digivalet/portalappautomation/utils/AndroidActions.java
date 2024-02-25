package org.digivalet.portalappautomation.utils;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidActions extends AppiumUtils {
	public AndroidDriver driver;
	public AndroidActions(AndroidDriver driver) {
		this.driver=driver;
	}
	
	public void scrollToText(String value) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+value+"\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_name\" and @text='"+value+"']")).click();
	}
	
	public void openFeature(String featureName) {
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_feature_name\" and @text='"+featureName+"']")).click();
	}
	
	public void tapOnAddButton() {
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Add\"]")).click();
	}
	
	public void searchOnSearchbar(String value){
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.paragon.sensonicstaff:id/search_bar\"]")).sendKeys(value);
	}
	
	public void tapOnCoordinate(int x, int y) {

		 TouchAction touchAction = new TouchAction(driver);
		 touchAction.tap(PointOption.point(x, y))
		 .perform();
	}
	
	
	
}
