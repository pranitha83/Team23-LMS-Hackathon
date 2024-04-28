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
	By PronameSpecialcharerrormsg = By.xpath("//*[text()='This field should start with an alphabet, no special char and min 2 char.']");
	By ProDesSpecialcharerrormsg = By.xpath("//*[text()='This field should start with an alphabet and min 2 char.']");
	By Programpopupclose = By.xpath("//*[@class='p-dialog-header-close-icon ng-tns-c132-3 pi pi-times']");
	By Capturingfooterentry = By.xpath("//*[@class='p-paginator-current ng-star-inserted']");
	
	//Edit Program
		By Editbutton= By.xpath("//div[@class='p-datatable-wrapper ng-star-inserted']/table/tbody/tr[1]/td[5]/div/span/button[1]/span[1]");
		By inactive = By.xpath("//*[@id='category' and @class='ng-untouched ng-pristine ng-valid']/div[1]/div[2]");
	
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
	
	public void  onlyclickstatus() {
		driver.findElement(Status).click();
		}
	public void  PronameSpecialchar() {
		 driver.findElement(programName).sendKeys("Java$");
		}
	public String PronameSpecialcharerrormsg() {
		 return driver.findElement(PronameSpecialcharerrormsg).getText();
		}
	public void  ProDesSpecialchar() {
		driver.findElement(programDescription).sendKeys("@@");
		}
	public String ProDesSpecialcharerrormsg() {
		 return driver.findElement(ProDesSpecialcharerrormsg).getText();
		}

	public void  Programpopupclose() {
		 driver.findElement(Programpopupclose).click();
		}
	
	public String Capturingfooterentry() {
		 return driver.findElement(Capturingfooterentry).getText();
		}
	
	
	public void CancelbuttonClick() {
		 driver.findElement(Cancelbutton).click();
		}
	
	public void EnterProNameandDesc(String givenprogramname, String givenprodesc) {
		 driver.findElement(programName).sendKeys(givenprogramname);
		 driver.findElement(programDescription).sendKeys(givenprodesc);
	}
		
	//============================================EditProgram===========================================================
			public void Editclick() {
			driver.findElement(Editbutton).click();
			}
			
			public void ProNameclear() {
				driver.findElement(programName).clear();
				}
			public void ProNameupdate() {
				driver.findElement(programName).sendKeys("Cucumb234");
				}
			public void ProDescclear() {
				 driver.findElement(programDescription).clear();
				}
			public void ProDescupdate() {
				 driver.findElement(programDescription).sendKeys("Team234Selenium");
				}
			public void Statuschange() {
			 driver.findElement(inactive).click();
			}	
		


}
