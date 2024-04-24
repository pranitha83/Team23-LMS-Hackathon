package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
	public  WebDriver driver; 


	public PageObjectManager pageobjectmanager; 
	
	public GenericUtils genericutils;
	
	public TestContextSetup() throws IOException {
		
		
		pageobjectmanager=new PageObjectManager(driver);
		genericutils=new GenericUtils(driver);
	}
}


