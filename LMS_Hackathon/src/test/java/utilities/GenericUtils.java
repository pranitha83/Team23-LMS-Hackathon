package utilities;


import org.openqa.selenium.WebDriver;

import driverFactory.SetupDriver;


public class GenericUtils {
	
	 TestContextSetup context;
	 SetupDriver setupdriver;
	  public WebDriver driver;
     
      
	public GenericUtils(TestContextSetup context) {
		
		this.context=context;
		this.driver=SetupDriver.Driver();
		
}
		
	}
	
	


