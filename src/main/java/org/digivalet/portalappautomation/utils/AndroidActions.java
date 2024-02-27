package org.digivalet.portalappautomation.utils;

import io.appium.java_client.android.AndroidTouchAction;
import org.openqa.selenium.By;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

public class AndroidActions extends AppiumUtils {
	public AndroidDriver driver;
	public AndroidActions(AndroidDriver driver) {
		this.driver=driver;
	}
	
	public void scrollToText(String value) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+value+"\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_name\" and @text='"+value+"']")).click();
	}
	public void scrollToText1(String value) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+value+"\"));"));
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

//	public void scroll(double startPercentage, double endPercentage) {
//		Dimension size = driver.manage().window().getSize();
//		int startX = (int) (size.width * 0.5);
//		int startY = (int) (size.height * startPercentage);
//		int endY = (int) (size.height * endPercentage);
//		TouchAction touchAction = new TouchAction(driver);
//		touchAction.press(PointOption.point(startX, startY))
//				.moveTo(PointOption.point(startX, endY))
//				.release()
//				.perform();
//	}

//	//Vertical Swipe by percentages
//	public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
//		Dimension size = driver.manage().window().getSize();
//		int anchor = (int) (size.width * anchorPercentage);
//		int startPoint = (int) (size.height * startPercentage);
//		int endPoint = (int) (size.height * endPercentage);
//		new TouchAction(driver)
//				.press(point(anchor, startPoint))
//				.waitAction(waitOptions(ofMillis(1000)))
//				.moveTo(point(anchor, endPoint))
//				.release().perform();
//	}

	public void scroll(int startX, int startY, int endX, int endY) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("mobile:touchAction", "{\"action\":\"press\",\"options\":{\"x\":" + startX + ",\"y\":" + startY + "}}");
		js.executeScript("mobile:touchAction", "{\"action\":\"moveTo\",\"options\":{\"x\":" + endX + ",\"y\":" + endY + "}}");
		js.executeScript("mobile:touchAction", "{\"action\":\"release\"}");
	}


}
