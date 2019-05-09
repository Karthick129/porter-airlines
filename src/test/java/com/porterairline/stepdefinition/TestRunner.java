package com.porterairline.stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="D:\\Karthick java\\Porterairline\\src\\test\\resources\\features\\bookticket.feature",
		glue= {"com.porterairline.stepdefinition"}
		//format= {"pretty","html:test-output"}
		)

public class TestRunner {

}
