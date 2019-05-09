package com.porterairline.stepdefinition;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.By;

import com.porterairline.objectrepository.objectrepository;
import com.porterairline.resources.base;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class stepdefinition extends base{
	objectrepository objrep;
	String depaturedate;
	String arraivaldate;
	
	@Before()
	
	public void openbrowser() throws IOException
	{
		
		base.launchbrowser();
	}
	
	
	@Given("The user is in the book tickets page")
	public void the_user_is_in_the_book_tickets_page() {
	  String title= driver.getTitle();
	  String orgtitle="Book flights today and save | Porter Airlines, Official Website"; 
	  Assert.assertEquals(orgtitle, title);
	    
	}

	@Then("The use renters all the details")
	public void the_use_renters_all_the_details() throws IOException, InterruptedException {
		objrep=new objectrepository();
		objrep.getDepature().sendKeys("Charleston (CHS)");
		objrep.getArraival().sendKeys("Montréal (YUL)"); 
		Thread.sleep(2000);
		//objrep.getStartdate().click();
		driver.findElement(By.xpath(prop.getProperty("calenderxpathfull1"))).sendKeys("15/05/2019");
		Thread.sleep(2000);
		//frame();
		//objrep.getEnddate().click();
		driver.findElement(By.xpath(prop.getProperty("calanderxpathfull2"))).sendKeys("30/05/2019");
	}

	@Then("The user clicks the find flights button")
	public void the_user_clicks_the_find_flights_button() {
	   objrep.getSubmit().click();
	    
	}
	
	@After()
	public void closebrowser() throws IOException
	{
		base.screenshot();
		driver.close();
	}

	
	
}
