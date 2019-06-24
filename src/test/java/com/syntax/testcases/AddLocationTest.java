package com.syntax.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.AddLocationPage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;
import com.syntax.utils.Constans;
import com.syntax.utils.ExcelUtility;

/*
 * Test Case: Add Location
1. Login to OrangeHRM
2. From Admin --> Organization select Locations
3. Add 5 different locations by providing complete required details (Use data provider)
4. Save location and verify it has been successfully saved.
 */
public class AddLocationTest extends BaseClass{
	
	@Test(dataProvider="Add location")
	public void addLocation(String name,String location,String city,String zip,String screenShot) throws InterruptedException{
		
		LoginPage login=new LoginPage();
		HomePage home=new HomePage();
		AddLocationPage loc=new AddLocationPage();
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		
		CommonMethods.click(home.Admin);
		CommonMethods.click(home.Organization);
		CommonMethods.click(home.Location);
		Thread.sleep(2000);
		CommonMethods.click(loc.add);
		
		CommonMethods.sendText(loc.name, name);
		CommonMethods.click(loc.Country);
		CommonMethods.selectList(loc.CountryList, location);
		CommonMethods.sendText(loc.City, city);
		CommonMethods.sendText(loc.ZipCode, zip);
		CommonMethods.click(loc.SaveBtn);
		CommonMethods.takeScreenshot(screenShot);
		
		CommonMethods.waitForElementBeClickable(loc.LocationList.get(0), 20);
		boolean locationtext=loc.LocationList.get(0).isDisplayed();
		Assert.assertTrue(locationtext);
		System.out.println("Successfully add location");
		
	}
//	@DataProvider(name="Data Location")
//	public Object[][] getDataLocation(){
//		ExcelUtility obj=new ExcelUtility();
//		obj.openExcel(Constans.XL_FILEPATH, addLocation);
//		
//		int rows =obj.getRowNum();
//		int cols=obj.getColNum(0);
//		
//		
//		Object [][] data=new Object
//	}
//	
	
	@DataProvider(name="Add location")
	public Object[][] getdata(){
		
		Object [][] data=new Object[5][5];
		
		data [0][0]="East Office";
		data [0][1]="Bolivia";
		data [0][2]="dddd";
		data [0][3]="11111";
		data [0][4]="1.screen";
		
		data [1][0]="South Office";
		data [1][1]="Brazil";
		data [1][2]="eeeee";
		data [1][3]="22222";
		data [1][4]="2.screen";
		
		data [2][0]="White Office";
		data [2][1]="Germany";
		data [2][2]="ffff";
		data [2][3]="33333";
		data [2][4]="3.screen";
		
		data [3][0]="Black Office";
		data [3][1]="Spain";
		data [3][2]="gggg";
		data [3][3]="44444";
		data [3][4]="4.screen";
		
		data [4][0]="Blue Office";
		data [4][1]="Turkey";
		data [4][2]="ttttt";
		data [4][3]="55555";
		data [4][4]="5.screen";
		
		return data;
	}

}
