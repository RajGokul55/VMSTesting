package com.qa.demo.applicationTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.agiletestware.bumblebee.annotations.Bumblebee;
import com.qa.demo.base.TestBase;


public class FirstScenario_Demo extends TestBase{
	public static String propertyFile = "mydemotest";
	
	@Bumblebee(testplan = "Subject\\webdriver", testlab = "Root\\webdriver", testset = "class annotations")
	
	@BeforeMethod
	public void setUp() {
		propertyFileInitialization(propertyFile);
				initilization();
	}
	
	@Test
	public void FirstTest() {
		System.out.println("This is my first test");
		
	}
	
}
