package org.digivalet.portalappautomation.pageObject.android.OutletModule;

import static org.testng.Assert.assertEquals;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;

import org.digivalet.portalappautomation.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class OutletProductOrdering extends AndroidActions{

	AndroidDriver driver;
	
	public OutletProductOrdering(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/edit_unit_number\"]")
	private WebElement unitNoFieldLocator;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/edit_order_for\"]")
	private WebElement bookForLocator;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_outlet_name\"]")
	private WebElement bookFromLocator;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@resource-id=\"com.paragon.sensonicstaff:id/rb_order_now\"]")
	private WebElement nowScheduleLocator;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/add_to_cart_btn\"]")
	private WebElement addToCartButtonLocator;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"Cart\"]")
	private WebElement cartButtonLocator;
	
	
	@AndroidFindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.paragon.sensonicstaff:id/start_counter\"]")
	private List<WebElement> counterLocator;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id=\"com.paragon.sensonicstaff:id/plus\"]")
	private WebElement counterPlusButtonLocator;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id=\"com.paragon.sensonicstaff:id/minus\"]")
	private List<WebElement> counterMinusButtonLocator;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.paragon.sensonicstaff:id/root_view\"]")
	private List<WebElement> bookingListLocator;
	
	
//	@BeforeMethod
//	public void goToLoginPage() {
//		
//	}
	
	
	
	public void findOutlet(String outletName) {
		openFeature(outletName);
	}
	
	public void selectUnitNo(String unitNo) throws InterruptedException {
		if(!unitNoFieldLocator.getText().contains(unitNo)) {
			unitNoFieldLocator.click();
			scrollToText(unitNo);	
		}
		
	}
	
	public void selectResidentName(String residentName) throws InterruptedException {
		if(!bookForLocator.getText().contains(residentName)) {
		bookForLocator.click();
		scrollToText(residentName);
	}
	}
	
	public void selectOutletInstance(String bookFrom) throws InterruptedException {
		if(!bookFromLocator.getText().contains(bookFrom)) {
		bookFromLocator.click();
		scrollToText(bookFrom);
	}
	}
	
	public void selectNowSchedule() {
		nowScheduleLocator.click();
		
	}
	
	
	public void selectProduct() {
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_product_name\"]")).click();
	}
	
	public void tapOnAddToCartButton() {
//		driver.findElements(By.xpath("//android.widget.FrameLayout[@resource-id=\"com.paragon.sensonicstaff:id/design_bottom_sheet\"]/android.view.ViewGroup/android.widget.FrameLayout")).get(0).click();
		addToCartButtonLocator.click();
	}

	public void tapOnCartButton(int x, int y) {
//        tapOnCoordinate(x,y);s
        
		cartButtonLocator.click();
	}
	
	public void increaseCounterTo(int value) {
		int temp=1;
		while(temp<value) {
			counterPlusButtonLocator.click();
			temp++;
		}
	}
	
	public void tapOnCounter(int index) {
		System.out.println("\nsize is"+counterLocator.size());
//		counterLocator.get(index).click();
		
	}
	
	public void getBookingList() throws InterruptedException {
//		scrollToBottom();
		System.out.println("size  "+bookingListLocator.size());
		int s=bookingListLocator.size();
		bookingListLocator.get(s-1).click();
		
	}
	
	public void BookingVerification(String unitNo,String residentName, String productName, int productQuantity, String bookFrom) {
		
		String getUnitNo=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_room_name\"]")).getText();
		String getResidentName=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_resident_name\"]")).getText();
		String getProductName=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_product_name\"]")).getText().substring(0,productName.length());
		int getProductQuantity=Integer.parseInt(driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_product_quantity\"]")).getText().substring(0,1));
		String getBookingFrom=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.paragon.sensonicstaff:id/label_outlet_name\"]")).getText();
		boolean isMatch=(getUnitNo.contains(unitNo) && getResidentName.contains(residentName) && getProductName.contains(productName) && getProductQuantity== productQuantity && getBookingFrom.contains(bookFrom))?true :false;

		boolean a=getUnitNo.contains(unitNo);
		boolean b=getResidentName.contains(residentName) ;
		boolean c=getProductName.contains(productName);
		boolean d=getProductQuantity== productQuantity;
		boolean e=getBookingFrom.contains(bookFrom);
		
		System.out.println("\n"+ a + b +c+d+e+"\n");
		
		System.out.println("\n"+getUnitNo+getResidentName+ getProductName+getProductQuantity+getBookingFrom+"\n");
		
		Assert.assertEquals(isMatch, true);
	}
	
	
	
	public void modifierAndAddonVerification(Object... params) {
		
		WebElement parentElement=driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.paragon.sensonicstaff:id/addOn_modifier_rv\"]"));
		List<WebElement> childElements = parentElement.findElements(By.className("android.widget.TextView"));
		int size=params.length;
		int temp=0;
		boolean flag=true;
		while(temp<size) {
			String str=childElements.get(temp).getText();
			System.out.println(str);
			System.out.println((String)params[temp]);
			if(!str.contains((String)params[temp])) {
				System.out.println(str);
				System.out.println((String)params[temp]);
				flag=false;
			}
			Assert.assertTrue(flag);
			temp++;
		}
		
		
	}




	public void addQuantityModifiers(String modifierFamily, String modifierName, int modifierQuantity) throws InterruptedException {
		WebElement parentElement=driver.findElement(By.id("com.paragon.sensonicstaff:id/modifier_family_rv"));
		List<WebElement> childElement = parentElement.findElements(By.className("android.view.ViewGroup"));
		int modifierFamilyNo = childElement.size();
		System.out.println("\nmodifierFamilyNo "+modifierFamilyNo);
		int temp=0;
		while(temp<modifierFamilyNo) {
			List<WebElement> superChildElements = childElement.get(temp).findElements(By.className("android.widget.TextView"));
			List<WebElement> radioButtonSelector = childElement.get(temp).findElements(By.className("android.widget.ImageView"));
			int s1=superChildElements.size();
			int s2=radioButtonSelector.size();

			System.out.println("\ns1 "+s1);
			System.out.println("\ns2 "+s2);

			System.out.println(superChildElements.get(0).getText());
			if(superChildElements.get(0).getText().contains(modifierFamily)) {
				int temp1=2;
				int temp2=0;
				while(temp1<s1) {
					String getmodifierName=superChildElements.get(temp1).getText();
					if(getmodifierName.contains(modifierName)) {
						System.out.println("getmodifierName "+getmodifierName);
						radioButtonSelector.get(temp2).click();
						int temp3=1;

						while(temp3<modifierQuantity) {
							driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.paragon.sensonicstaff:id/plus\"])[2]")).click();
							temp3++;
						}
						break;
					}
					if(!superChildElements.get(temp1).getText().contains("$")) {
						temp2++;
					}

					temp1+=1;
				}
				break;
			}
			temp++;
		}
	}

	
	
	
	public void addQuantityModifiers1(String modifierFamily, String modifierName, int modifierQuantity) throws InterruptedException {
		WebElement parentElement=driver.findElement(By.id("com.paragon.sensonicstaff:id/modifier_family_rv"));
		List<WebElement> childElement = parentElement.findElements(By.className("android.view.ViewGroup"));
		int modifierFamilyNo = childElement.size();
		System.out.println("\nmodifierFamilyNo "+modifierFamilyNo);
		int temp=0;
		while(temp<modifierFamilyNo) {
			List<WebElement> superChildElements = childElement.get(temp).findElements(By.className("android.widget.TextView"));
			List<WebElement> radioButtonSelector = childElement.get(temp).findElements(By.className("android.widget.ImageView"));
			List<WebElement> Elements1 = childElement.get(temp).findElements(By.className("androidx.recyclerview.widget.RecyclerView"));
			
			
			int s1=superChildElements.size();
			int s2=radioButtonSelector.size();

			System.out.println("\ns1 "+s1);
			System.out.println("\ns2 "+s2);
			
			System.out.println(superChildElements.get(0).getText());
			if(superChildElements.get(0).getText().contains(modifierFamily)) {
			int temp1=2;
			int temp2=0;
					while(temp1<s1) {
						String getmodifierName=superChildElements.get(temp1).getText();
						if(getmodifierName.contains(modifierName)) {
							System.out.println("getmodifierName "+getmodifierName);
							radioButtonSelector.get(temp2).click();
							int temp3=1;
							
							List<WebElement> counterSelector = childElement.get(temp).findElements(By.className("android.widget.LinearLayout"));
							int s4=counterSelector.size();
							List<WebElement> counterPlusSelector=counterSelector.get(7).findElements(By.className("android.widget.ImageView"));
						
							
							while(temp3<modifierQuantity) {
								System.out.println("size s4= "+s4);
								counterPlusSelector.get(1).click();
//								driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.paragon.sensonicstaff:id/plus\"])[2]")).click();
								temp3++;
							}
							break;
						}
						if(!superChildElements.get(temp1).getText().contains("$")) {
						temp2++;
						}
						
						temp1+=1;
					}
				break;
			}
			temp++;
		}
		}
	
	

	
	public void addBooleanModifiers(String modifierFamily, String modifier) {

		WebElement parentElement=driver.findElement(By.id("com.paragon.sensonicstaff:id/modifier_family_rv"));
		List<WebElement> childElement = parentElement.findElements(By.className("android.view.ViewGroup"));
		int modifierFamilyNo = childElement.size();
		System.out.println("\nmodifierFamilyNo "+modifierFamilyNo);
		int temp=0;
		while(temp<modifierFamilyNo) {
			List<WebElement> superChildElements = childElement.get(temp).findElements(By.className("android.widget.TextView"));
			List<WebElement> radioButtonSelector = childElement.get(temp).findElements(By.className("android.widget.ImageView"));
			int s1=superChildElements.size();
			int s2=radioButtonSelector.size();
			int temp3=0;
			System.out.println("\ns1 "+s1);
			int temp1=0;
			System.out.println(superChildElements.get(0).getText());
			if(superChildElements.get(0).getText().contains(modifierFamily)) {
				temp1+=2;
				
				while(temp1<s1) {
					if(superChildElements.get(temp1).getText().contains(modifier)) {
						System.out.println(superChildElements.get(temp1).getText());
						radioButtonSelector.get(temp3).click();
						break;
					}
					temp1++;
					if(!superChildElements.get(temp1).getText().contains("$")) {
					temp3++;
					}
				}
			break;
			}
			temp++;
		}
		
		}
	
	
	
	public void addBooleanAddon(String addonName) {
//		scroll(0.5,0.5);
		WebElement parentElement=driver.findElement(By.id("com.paragon.sensonicstaff:id/add_ons_rv"));
		
		List<WebElement> childElements = parentElement.findElements(By.className("android.widget.LinearLayout"));
		int s1= childElements.size();
		int temp=0;
		System.out.println("\nsize s1= "+s1);
		
		while(temp<s1) {
		List<WebElement> superChildElements = childElements.get(temp).findElements(By.className("android.widget.TextView"));
		int s2=superChildElements.size();
		System.out.println("size s2= "+s2);
		List<WebElement> radioButtonSelector = childElements.get(temp).findElements(By.className("android.widget.ImageView"));
		int s3=radioButtonSelector .size();
		System.out.println("size s3= "+s3);
		
		if(superChildElements.get(0).getText().contains(addonName)) {
			System.out.println("addon name"+superChildElements.get(0).getText());
			radioButtonSelector.get(0).click();
			break;
		}
		temp++;
		}

	}
	
	public void addQuantityAddon(String addonName, int addonQuantity) throws InterruptedException {
//
//		Thread.sleep(3000);
		scroll(542,348,480,2024);
		WebElement parentElement=driver.findElement(By.id("com.paragon.sensonicstaff:id/add_ons_rv"));
		
		List<WebElement> childElements = parentElement.findElements(By.className("android.widget.LinearLayout"));
		int s1= childElements.size();
		int temp=0;
		System.out.println("\nsize s1= "+s1);
		
		while(temp<s1) {
		List<WebElement> superChildElements = childElements.get(temp).findElements(By.className("android.widget.TextView"));
		int s2=superChildElements.size();
		System.out.println("size s2= "+s2);
		List<WebElement> radioButtonSelector = childElements.get(temp).findElements(By.className("android.widget.ImageView"));
		int s3=radioButtonSelector .size();
		System.out.println("size s3= "+s3);
		
		if(superChildElements.get(0).getText().contains(addonName)) {
			System.out.println("addon name"+superChildElements.get(0).getText());
			radioButtonSelector.get(0).click();
			int temp1=1;
			List<WebElement> counterSelector = childElements.get(temp).findElements(By.className("android.widget.LinearLayout"));
			int s4=counterSelector.size();
			List<WebElement> counterPlusSelector=counterSelector.get(5).findElements(By.className("android.widget.ImageView"));
			while(temp1<addonQuantity) {
				System.out.println("size s4= "+s4);
				counterPlusSelector.get(1).click();
//				driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.paragon.sensonicstaff:id/plus\"])[2]")).click();
				temp1++;
			}
			
			break;
		}
		temp++;
		}
	}
	

}
