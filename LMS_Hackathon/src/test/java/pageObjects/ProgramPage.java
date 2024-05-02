package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.SetupDriver;


public class ProgramPage {
	
public WebDriver driver;
Alert alert;
	

 public ProgramPage(WebDriver driver) 
	{
		this.driver=driver;
		this.driver=SetupDriver.Driver();
	}
	
	//Add Program
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
		
	//Delete Program
	By Deletebutton= By.xpath("//div[@class='p-datatable-wrapper ng-star-inserted']/table/tbody/tr[1]/td[5]/div/span/button[2]/span[1]");
	By DeleteYes = By.xpath("//*[text()='Yes']");
	By DeleteNo = By.xpath("//*[text()='No']");
	By Deletemessage = By.xpath("//*[@class='p-confirm-dialog-message ng-tns-c133-4']");
	By DeletePopupClose = By.xpath("//*[@class='pi pi-times ng-tns-c133-4']");
	
	//Pagination
		By nextpagesingle =By.xpath("//*[@class='p-paginator-next p-paginator-element p-link p-ripple']");
		By firstpagesingle =By.cssSelector("span[class='p-paginator-icon pi pi-angle-left']");
		By lastpagedouble =By.cssSelector("span[class='p-paginator-icon pi pi-angle-double-right']");
		By startpagedouble =By.xpath("//*[@class='p-paginator-icon pi pi-angle-double-left']");
	
		 //Multiple Delete
		  
		  By Multipledelsingle = By.xpath("//app-program[@class='ng-star-inserted']/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]");
		  By ToprowDelete = By.xpath("/html/body/app-root/app-program/div/mat-card/mat-card-title/div[2]/div[1]/button/span[1]");
		  By Multipledelpopupmessage = By.xpath("//*[@class='p-confirm-dialog-message ng-tns-c133-19']");
		  By TopDelCheckboxclick = By.xpath("//div[@class='p-checkbox-box']");
		  
		  //Navigation
		  By Program = By.id("program");
		  By Batch = By.id("batch");
		  By User = By.id("user");
		  By Logout = By.id("logout");
		  
		  //Sorting
		  By Programnamesort = By.xpath("//*[@class='p-datatable-thead']/tr/th[2]/p-sorticon/i");
		  By ProgramDescsort = By.xpath("//*[@class='p-datatable-thead']/tr/th[3]/p-sorticon/i");
		  By Programstatussort = By.xpath("//*[@class='p-datatable-thead']/tr/th[4]/p-sorticon/i");
		  By programnamesortgettext =  By.xpath("//*[@class='p-datatable-tbody']/tr/td[2]");
		  By programDescsortgettext =  By.xpath("//*[@class='p-datatable-tbody']/tr/td[3]");
		  By programstatussortgettext =  By.xpath("//*[@class='p-datatable-tbody']/tr/td[4]");
		  
		  
		
	//===================================AddProgram=====================================================
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
	
	public void AlertProgramcreation() {
	try {
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.alertIsPresent());
	     alert = driver.switchTo().alert();
	    System.out.println("AlertMessage :"  +alert.getText());
	    alert.accept();
	    Assert.assertTrue(alert.getText().contains("Successful Program Created"));
	} catch (Exception e) {
	    //exception handling
	}
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
			
			public void AlertProgramUpdate() {
			try {
			    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			    wait.until(ExpectedConditions.alertIsPresent());
			     alert = driver.switchTo().alert();
			    System.out.println("AlertMessage :"  +alert.getText());
			    alert.accept();
			    Assert.assertTrue(alert.getText().contains("ProgramUpdated"));
			} catch (Exception e) {
			    //exception handling
			}
			}
			
			//=========================================DeleteProgram========================================================================
			
			public void DeleteClick() {
				driver.findElement(Deletebutton).click();
				}
			public boolean DeleteYes() {
			return driver.findElement( DeleteYes).isDisplayed();
			}
			
			public boolean DeleteNo() {
				
				 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(DeleteNo));
				 return element.isDisplayed();
				
				}
			public  boolean Deletemessage() {
				
				 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Deletemessage));
				 return element.isDisplayed();
			
	            }
			public void DeleteYesClick() {
				 driver.findElement( DeleteYes).click();
				}
			public void DeleteNoClick() {
				 driver.findElement(DeleteNo).click();
				}
			public void DeletePopupClose() {
				 driver.findElement(DeletePopupClose).click();
				}
			
			//====================================Pagination========================================================
			
			public void Nextpageclick() 
			    {
				 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(nextpagesingle));
				  element.click();
				}
			
			public boolean Nextpagelinkisenabled() 
			  {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(nextpagesingle));
				 return element.isEnabled();
				}
			
			public void lastpageclick()
			{
				
				 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(lastpagedouble));
				  element.click();
				
			}
			
			public void firstpageclick()
			   {
				
				 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(firstpagesingle));
				  element.click();
				
				}
			public void startpageclick() 
			     {
				
				  WebElement element = driver.findElement(startpagedouble);
				  Actions actions = new Actions(driver);
				  actions.moveToElement(element).click().perform();
				
				}
			
			public boolean Previouspagelinkisenabled() 
			  {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				 WebElement element = wait.until(ExpectedConditions.elementToBeClickable( firstpagesingle));
				 return element.isEnabled();
				
				}
			
			//====================================================Multiple delete=========================================	
			
			public void Multipledelsingleclick() {
				 driver.findElement(Multipledelsingle).click();
				}
			
			public boolean ToprowDeleteisenabled() {
				 return driver.findElement(ToprowDelete).isEnabled();
				}
			public void ToprowDeleteClick() {
				 driver.findElement(ToprowDelete).click();
				}
			
			public String Multipledelpopupmessage() {
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Multipledelpopupmessage));
				 return element.getText();
				}
			public void TopDelCheckboxclick() {
				 driver.findElement(TopDelCheckboxclick).click();
				}
			
			//===============================================Navigation===========================================
			

		       public void Clickmodulelink(String module) {
					
					 switch(module) {
					case "Program" :  
						 driver.findElement(Program).click();
					 case "Batch"	: 
						 driver.findElement(Batch).click();
					case "User"	: 
						 driver.findElement(User).click();
					 case "Logout" :				 
						 driver.findElement(Logout).click();
					 }
		        }
	
		     //============================================Sorting=========================================================
		       
				
		       public void Programnamesort() {
					 driver.findElement(Programnamesort).click();
					}
			
		       public void ProgramDescsort() {
					 driver.findElement(ProgramDescsort).click();
					}
		       public void Programstatussort() {
					 driver.findElement(TopDelCheckboxclick).click();
					}
		       
		       public List<String> programnamesortgettext() {
		         
		    	   //Capature all the webelements in the list
		    	List<WebElement> elementlist = driver.findElements(programnamesortgettext);
		    	
		    	 //Capature the webelements(text) in to original list
		    	List<String> originallist = elementlist.stream().map(s->s.getText()).collect(Collectors.toList());
		    	
		    	 //Sort of the original list from 3
		    	List<String> Sortedlist = originallist.stream().sorted().collect(Collectors.toList());
		    	
		    	 //Compare original list to sorted list
		         Assert.assertFalse(originallist.equals(Sortedlist));
				
		         return Sortedlist;
				 }
	      
		       
		       public List<String> programDescsortgettext() {

			    	   List<WebElement> elementlist = driver.findElements(programDescsortgettext);
			    	
			    List<String> originallist = elementlist.stream().map(s->s.getText()).collect(Collectors.toList());
			    	
			 List<String> Sortedlist = originallist.stream().sorted().collect(Collectors.toList());
			    	
			         Assert.assertFalse(originallist.equals(Sortedlist));
			         
			         return Sortedlist;
			       
		       }
		      
		       
		}
