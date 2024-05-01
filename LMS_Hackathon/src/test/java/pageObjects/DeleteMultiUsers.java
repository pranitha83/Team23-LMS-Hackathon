package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.SetupDriver;

public class DeleteMultiUsers {

	public WebDriver driver;
	By cmnDltOptn = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");

	public DeleteMultiUsers(WebDriver driver) {
		this.driver = driver;
		this.driver = SetupDriver.Driver();
	}

	public void selectAnyChkBox() {
		driver.findElement(By.xpath("//table//tbody/tr[1]/td[1]//p-tablecheckbox//div//div[2]")).click();
	}

	public boolean commonDltOptnEnabld() {
		return driver.findElement(cmnDltOptn).isEnabled();
	}

	public void getChkBoxOfTheUsrFrmExcl(String fname) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement goToNxtPage = driver.findElement(By.xpath("//p-paginator/div/button[3]"));
		boolean flag = false;
		int rows = driver.findElements(By.xpath("//table//tbody//tr")).size();
		while (flag == false) {
			for (int r = 1; r <= rows; r++) {
				String name = driver.findElement(By.xpath("//table//tbody//tr[" + r + "]//td[3]")).getText();
				if (name.contains(fname)) {
					WebElement chkBx = driver.findElement(
							By.xpath("//table//tbody//tr[" + r + "]//td[1]//p-tablecheckbox//div//div[2]"));
					chkBx.click();
					flag = true;
					break;
				}
			}
			if (!goToNxtPage.isEnabled() || flag == true) {
				break;
			}
			WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(goToNxtPage));
			ele.click();
		}
	}

	public void clickCmnDltOptn() {
		driver.findElement(cmnDltOptn).click();
	}

	public boolean verifySucssDelMsg() throws InterruptedException {
		Thread.sleep(2000);
		String msg = "Users Deleted";
		WebElement alertMsg = driver.findElement(By.xpath("//div[@role='alert']"));
		System.out.println("Alert msg is " + alertMsg.getText());
		return alertMsg.getText().contains(msg);
	}

	public boolean chkUsrIsNtDltd(String fname, String lname) {
		boolean flag = false;
		String fullname = fname + " " + lname;
		List<WebElement> users = driver.findElements(By.xpath("//tr//td[3]"));
		for (WebElement user : users) {
			if (user.getText().equals(fullname)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public void clickMultiChkBoxs(String fname1, String fname2) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement goToNxtPage = driver.findElement(By.xpath("//p-paginator/div/button[3]"));
		boolean flag = false;
		int rows = driver.findElements(By.xpath("//table//tbody//tr")).size();
		
		while (flag == false) {
			try {
			for (int r = 1; r <= rows; r++) {
				String name = driver.findElement(By.xpath("//table//tbody//tr[" + r + "]//td[3]")).getText();
				if (name.contains(fname1) || name.contains(fname2)) {
					WebElement chkBx = driver.findElement(
							By.xpath("//table//tbody//tr[" + r + "]//td[1]//p-tablecheckbox//div//div[2]"));
					chkBx.click();
				}
			}
			WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(goToNxtPage));
			ele.click();
		}
			catch (Exception e) {
				break;
			}
		}
		
	}
	
	public List<String> clikAnyMultiChkBoxs() {
		List<String> names = new ArrayList<String>();
		List<WebElement> chkBoxes = driver.findElements(By.xpath("//tr//td[1]"));
		for (int i=1; i<chkBoxes.size(); i++) {
			if (i<4) {
				chkBoxes.get(i).click();
				String name = driver.findElement(By.xpath("//tr["+i+"]//td[1]//following-sibling::td[2]")).getText();
				names.add(name);
			}
		}
		System.out.println("List of names are"+names);
		return names;
	}
	
	public boolean verifyUsrsAreNtDeletd() {
		boolean flag = false;
		DeleteMultiUsers dltmultiusers = new DeleteMultiUsers(driver);
		List<String> names = dltmultiusers.clikAnyMultiChkBoxs();
		List<WebElement> elemnts = driver.findElements(By.xpath("//tr//td[3]"));
		for (int i = 0; i<elemnts.size(); i++) {
			if (i<3) {
				System.out.println("names in dataTable "+elemnts.get(i).getText());
				names.contains(elemnts.get(i).getText());
				flag = true;
			}
		}
		return flag;
		
	}

}
