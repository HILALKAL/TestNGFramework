package com.syntax.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class AddLocationPage extends BaseClass {

	@FindBy(xpath="//a[@class='btn-floating btn-large waves-effect waves-light']")
	public WebElement add;
	
	@FindBy(css="input[id='name']")
	public WebElement name;
	
	@FindBy(xpath="//div[@id='countryCode_inputfileddiv']//div[@class='select-wrapper initialized']//input")
	public WebElement Country;
	
	@FindBy(xpath="//div[@id='countryCode_inputfileddiv']//div[@class='select-wrapper initialized']//ul")
	public WebElement CountryList;
	
	@FindBy(css="input[id='city']")
	public WebElement City;
	
	@FindBy(css="input[id='zipCode']")
	public WebElement ZipCode;
	
	@FindBy(xpath="//a[contains(@class,'primary-btn')]")
	public WebElement SaveBtn;
	
	@FindBy(xpath="//tbody/tr/td[2]")
	public List<WebElement> LocationList;
	
	public AddLocationPage() {
		
		PageFactory.initElements(driver, this);
	}

}
