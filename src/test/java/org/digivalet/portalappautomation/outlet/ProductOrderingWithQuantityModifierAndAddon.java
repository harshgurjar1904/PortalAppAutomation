package org.digivalet.portalappautomation.outlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.digivalet.portalappautomation.LoginModule.LoginSuccessfully;
import org.digivalet.portalappautomation.pageObject.android.OutletModule.OutletProductOrdering;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductOrderingWithQuantityModifierAndAddon extends LoginSuccessfully {
	private String outletName;
	private String bookFrom;
	private String unitNo;
	private String residentName;
	private String productName;
	private int productQuantity;
	private String modifierFamily;
	private String modifierName;
	private int modifierQuantity;
	private String addonName;
	private int addonQuantity;
	private String modifierQuantity1;
	private String addonQuantity1;
	

	@DataProvider
	public Object[][] getData() throws IOException{
		List<HashMap<String,String>> data=getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\org\\digivalet\\PortalAppAutomation\\outlet\\outletTestData.json");
		return new Object[][]{{data.get(7)}};
	}
	
	@Test(dataProvider="getData",priority=2)
	public void dataSetter(HashMap<String,String> input) {
		outletName=input.get("outletName");
		bookFrom=input.get("outletInstance");
		unitNo=input.get("unitNo");
		residentName=input.get("residentName");
		productName=input.get("productName");
		productQuantity=Integer.parseInt(input.get("productQuantity"));
		modifierFamily=input.get("modifierFamily");
		modifierName=input.get("modifierName");
		modifierQuantity1=input.get("modifierQuantity");
		modifierQuantity=Integer.parseInt(modifierQuantity1);
		addonName=input.get("addonName");
		addonQuantity1=input.get("addonQuantity");
		addonQuantity=Integer.parseInt(addonQuantity1);
		
	}
	
	@Test(priority=3)
	public void OrderWithQuantityAddonAndModifiers() throws InterruptedException {
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.paragon.sensonicstaff:id/navigation_bar_item_icon_view\"])[5]")).click();
		OutletProductOrdering opo=new OutletProductOrdering(driver);
		opo.findOutlet(outletName);
		opo.tapOnAddButton();
		opo.selectUnitNo(unitNo);
		opo.selectResidentName(residentName);
		opo.selectOutletInstance(bookFrom);
		opo.selectNowSchedule();
		opo.searchOnSearchbar(productName);
		opo.selectProduct();
		opo.increaseCounterTo(productQuantity);
		opo.addQuantityModifiers(modifierFamily,modifierName,modifierQuantity);
		opo.addQuantityAddon(addonName,addonQuantity);
		opo.tapOnAddToCartButton();
		opo.tapOnCartButton(1074,174);
		opo.tapOnAddToCartButton();
		opo.getBookingList();
		opo.BookingVerification(unitNo,residentName,productName,productQuantity,bookFrom);
		opo.modifierAndAddonVerification(modifierQuantity1,modifierName,addonQuantity1,addonName);
	}
	

}
