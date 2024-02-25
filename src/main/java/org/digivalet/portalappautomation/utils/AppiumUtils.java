package org.digivalet.portalappautomation.utils;

import java.io.File;
import org.openqa.selenium.By;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	
	public List<HashMap<String,String>> getJsonData(String jsonFilePath) throws IOException{
	
		String jsonContent=FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){});
		return data;
		
	}
	
	public AppiumDriverLocalService startAppiumServer(String systemUserName,String ipAddress, int portNO) {
		//below code is used to start the appium server through code 		
		AppiumDriverLocalService service= new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\"+systemUserName+"\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress(ipAddress).usingPort(portNO).build();
		
		service.start(); //start the server
		return service;
	}
	
//	public void gotScreen(String s1,String s2,AndroidDriver driver) {
//	//adb shell dumpsys window | find "mCurrentFocus" - run this command to get the package name and activity name
//			Activity activity=new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
//			((AndroidDriver) driver).startActivity(activity);
//			
//			//  mCurrentFocus=Window{694b4df u0 com.paragon.sensonicstaff/com.paragon.sensonicstaff.ui.activities.outletrequestadd.OutletRequestAddActivity}
//	}
	
	
}
