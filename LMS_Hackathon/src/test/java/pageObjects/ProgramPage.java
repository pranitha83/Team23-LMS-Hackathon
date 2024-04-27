package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import driverFactory.SetupDriver;


public class ProgramPage {
	
public WebDriver driver;
	
	public ProgramPage(WebDriver driver) 
	{
		this.driver=driver;
		this.driver=SetupDriver.Driver();
	}
	
	/* WebDriver driver;

		public ProgramPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}*/
	
	By UserName=By.id("username");
	By Password=By.id("password");
	By ClickLogin=By.id("login");
	By NewProgram =By.xpath("//*[text()='A New Program']");
	By Cancelbutton =By.xpath("//*[text()='Cancel']");
	By Savebutton =By.xpath("//*[text()='Save']");
	By PopupClose = By.xpath("//*[@class='p-dialog-header-close-icon ng-tns-c132-8 pi pi-times']");
	By programName =By.id("programName");
	By programDescription = By.id("programDescription");
	By Status = By.className("p-radiobutton-box");
	By ProNameRequired = By.xpath("//*[text()='Program name is required.']");
	By ProDescRequired = By.xpath("//*[text()='Description is required.']");
	By statusrequied=By.xpath("//*[text()='Status is required.']");
	
	public void NewProgram() {
		driver.findElement(NewProgram).click();
		}
	
	public void Username() {
	driver.findElement(UserName).sendKeys("sdetorganizers@gmail.com");
	   }
	public void Password() {
	driver.findElement(Password).sendKeys("UIHackathon@02");
	}
	public void ClickLogin() {
	driver.findElement(ClickLogin).click();
	}
	public String Cancelbutton() {
	return driver.findElement(Cancelbutton).getText();
	}
	public String Savebuttongettext() {
	return driver.findElement(Savebutton).getText();
	}
	public boolean  PopupClose() {
		return driver.findElement(PopupClose).isDisplayed();
		}
	public boolean  proNamedisplay() {
	return driver.findElement(By.id("programName")).isDisplayed();
	}
	public boolean  proDesdisplay() {
	return driver.findElement(By.id("programDescription")).isDisplayed();
	}
	public boolean  Statusdisplay() {
	 return driver.findElement(Status).isDisplayed();
	}
	public void Savebuttonclick() {
		 driver.findElement(Savebutton).click();;
		}
	public String ProNameRequired() {
	return driver.findElement(ProNameRequired).getText();
	}
	public String ProDescRequired() {
	return driver.findElement(ProDescRequired).getText();
	}
	public String statusrequied() {
   return driver.findElement(statusrequied).getText();
	}
	
	public void  onlyenterproname() {
		 driver.findElement(By.id("programName")).sendKeys("Java");
		}
	
	public void  onlyenterproDes() {
		driver.findElement(By.id("programDescription")).sendKeys("Team23");
		}


}
