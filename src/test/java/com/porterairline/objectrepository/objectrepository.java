package com.porterairline.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.porterairline.resources.base;

public class objectrepository extends base {
	
	@FindBy(id="departureCity")
    WebElement depature;
	
	@FindBy(id="arrivalCty")
	WebElement arraival;
	
	@FindBy(id="pickStart")
	WebElement startdate;
	
	@FindBy(id="pickEnd")
	WebElement enddate;
	
	@FindBy(id="submitFlighSearch")
	WebElement submit;
	
	
	
	
	public objectrepository()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getDepature() {
		return depature;
	}

	public WebElement getArraival() {
		return arraival;
	}
	
	public WebElement getStartdate() {
		return startdate;
	}

	public WebElement getEnddate() {
		return enddate;
		
	}
	public WebElement getSubmit() {
		return submit;
	}
	
	


}
