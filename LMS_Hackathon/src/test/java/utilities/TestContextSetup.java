package utilities;

import java.io.IOException;

import driverFactory.SetupDriver;
import pageObjects.LoginPage;
import pageObjects.PageObjectManager;

public class TestContextSetup extends SetupDriver {
	//public  WebDriver driver; 


	public PageObjectManager pageobjectmanager; 
	public LoginPage loginpage;
	public GenericUtils genericutils;
	
	public void getpageObjManager() {
		
		//loginpage = new LoginPage(driver);
		pageobjectmanager=new PageObjectManager(driver);
		//genericutils=new GenericUtils(driver);
	}
}


