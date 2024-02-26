package org.digivalet.portalappautomation.utils;

import java.awt.Dimension;

import org.openqa.selenium.By;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
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
	
//	public void scrollToBottom() {
//        org.openqa.selenium.Dimension size = driver.manage().window().getSize();
//        int startX = size.width / 2;
//        int startY = (int) (size.height * 0.8); // Start from 80% of the height
//        int endY = (int) (size.height * 0.2);   // End at 20% of the height
//
//        TouchAction touchAction = new TouchAction(driver);
//        touchAction.press(PointOption.point(startX, startY))
//                   .waitAction()
//                   .moveTo(PointOption.point(startX, endY))
//                   .release()
//                   .perform();
//    }
}
