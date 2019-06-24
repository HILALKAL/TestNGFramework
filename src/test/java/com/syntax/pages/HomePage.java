package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class HomePage extends BaseClass {
	@FindBy(xpath = "//li[text()='Dashboard']")
	public WebElement dashboardText;
	
	/*
	 * Click on PIM
Step 3: Click on Add Employee
	 */
	@FindBy(xpath="//span[text()='PIM']")
	public WebElement PIM;
	
	@FindBy(xpath="//span[text()='Add Employee']")
	public WebElement addEmployee;
	
	@FindBy(xpath="//a[contains(@class,'collapsible')]//span[text()='Admin']")
	public WebElement Admin;
	
	@FindBy(xpath="//a[@class='collapsible-header waves-effect waves-orange']//span[text()='Organization']")
	public WebElement Organization;
	
	@FindBy(xpath="//span[text()='Locations']")
	public WebElement Location;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
}