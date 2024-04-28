package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import driverFactory.SetupDriver;

public class GenericUtils  {

	  static WebDriver driver = SetupDriver.setupDriver();
 //
//	public GenericUtils(WebDriver driver) {
//		this.driver = driver;
//		
//		
//	}
	//WebDriver driver = new ChromeDriver();
	public static void brokenlnks() throws Throwable {
		driver.get(PropertyFileReader.getUrl());
		List<WebElement> links =  driver.findElements(By.tagName("a"));
		System.out.println(links.size());
	}
	public static void main(String[] args) throws Throwable {
		brokenlnks();
	}
}
