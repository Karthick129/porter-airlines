package com.porterairline.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.io.Files;


public class base {
	public static Properties prop;
	public static WebDriver driver;
	//public static WebElement date;
	public static boolean flag;
	public static int year;
	public static int month;
	public static int date;
	
	public static void loaddata() throws IOException
	{
		prop=new Properties();
		String datapath="D:\\Karthick java\\Porterairline\\src\\test\\resources\\properties\\bookticket.properties";
		FileInputStream fis=new FileInputStream(datapath);
		prop.load(fis);
		
	}
	public static void launchbrowser() throws IOException
	{   
		base.loaddata();
		String chromedriver=prop.getProperty("chrome1");
		String chromepath=prop.getProperty("chrome2");
		String firefoxdriver=prop.getProperty("firefox1");
		String firefoxpath=prop.getProperty("firefox2");
		String iedriver=prop.getProperty("ie1");
		String iepath=prop.getProperty("ie2");
		String launchbrowser=prop.getProperty("browser");
		String launchurl=prop.getProperty("url");
		if(launchbrowser.equals("chrome"))
		{
			System.setProperty(chromedriver, chromepath);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(launchbrowser.equals("firefox"))
		{
			System.setProperty(firefoxdriver,firefoxpath);
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if(launchbrowser.equals("ie"))
		{
			System.setProperty(iedriver,iepath);
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		driver.get(launchurl);
		driver.manage().window().maximize();
		
		}
	public static String getdate() {
		Calendar now=Calendar.getInstance();
		year=now.get(Calendar.YEAR);
		month=now.get(Calendar.MONTH)+1;
		date=now.get(Calendar.DATE);
		String d=Integer.toString(date);
		String m=Integer.toString(month);
		String y=Integer.toString(year);
		String ddmmyy=d+"."+m+"."+y;
		return ddmmyy;
	}
	
	public static int frame()
	{
		int total=0;
		int size=driver.findElements(By.tagName("iframe")).size();
		System.out.println("SIZE IS"+size);
		driver.findElement(By.xpath(prop.getProperty("calenderxpathfull"))).click();
		
		
		for(int frame=0;frame<size;frame++)
		{
			driver.switchTo().frame(frame);
			total=driver.findElements(By.xpath(prop.getProperty("calenderxpathfull"))).size();
			System.out.println("TOTAL IS"+total);
			driver.switchTo().defaultContent();
			
			
		}
		 
		 return total;
		 
		
		
	}
	public static void screenshot() throws IOException
	{
	String screenshotdate=base.getdate();
	TakesScreenshot ts=(TakesScreenshot)base.driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	Files.copy(source,new File("D:\\Karthick java\\Porterairline\\screenshots\\screenshots"+screenshotdate+" .png"));
	}
}


