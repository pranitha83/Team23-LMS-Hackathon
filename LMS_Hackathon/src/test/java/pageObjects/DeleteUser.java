package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.SetupDriver;

public class DeleteUser {
	public WebDriver driver;
	By yesFrmAlert = By.xpath("//div[@class='p-dialog-footer ng-tns-c133-9 ng-star-inserted']//button[2]");
    By noFrmAlert = By.xpath("//div[@class='p-dialog-footer ng-tns-c133-9 ng-star-inserted']//button[1]");
    By alrtBox = By.xpath("//div[@class='ng-trigger ng-trigger-animation ng-tns-c133-9 p-dialog p-confirm-dialog p-component ng-star-inserted']");
	By closeFrmAlert = By.xpath("//div[@class='p-dialog-header-icons ng-tns-c133-9']//button[1]");
    
    public DeleteUser(WebDriver driver) {
		this.driver = driver;
		this.driver = SetupDriver.Driver();
	}

	public void clickDeleteBtn() {
		driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]/div/span/button[2]")).click();
	}

	public boolean isAlertBoxPresent() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Alert");
		WebElement alert = driver.findElement(alrtBox);
		String alertMsgs = alert.getText();
		System.out.println(alertMsgs);
		return alertMsgs.contains("Yes") && alertMsgs.contains("No") && alertMsgs.contains("Confirm");
				
	}
	
	public void getUserFrmExcel(String fname) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement goToNxtPage = driver.findElement(By.xpath("//p-paginator/div/button[3]"));
		boolean flag = false;
		int rows = driver.findElements(By.xpath("//table//tbody//tr")).size();
		while (flag == false) {
			for (int r = 1; r <= rows; r++) {
				String name = driver.findElement(By.xpath("//table//tbody//tr[" + r + "]//td[3]")).getText();
				if (name.contains(fname)) {
					WebElement dltBtn = driver
							.findElement(By.xpath("//table//tbody//tr[" + r + "]//td[6]//div//span//button[2]"));
					dltBtn.click();
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
	
	public void clickYesOptn() {
		driver.findElement(yesFrmAlert).click();
	}
	
	public void clickNoOptn() {
		driver.findElement(noFrmAlert).click();
	}
	
	public boolean verifySucssDelMsg(String msg) throws InterruptedException {
		Thread.sleep(2000);
		WebElement alertMsg = driver.findElement(By.xpath("//div[@role='alert']"));
		return alertMsg.getText().contains(msg);
	}
	
	public boolean chkUsrAftrDeletn(String fname, String lname) {
		List<WebElement> users = driver.findElements(By.xpath("//table//tbody//td[3]"));
		boolean flag = false;
		for (WebElement user : users) {
			if (user.getText().equals (fname+" "+lname)) {
				flag = false;
			}
			else {
				flag = true;
			}
		}
		return flag;
		
	}
	
	public boolean isAlertBoxDisappear() throws InterruptedException {
		Thread.sleep(2000);
		//return !driver.findElement(alrtBox).isDisplayed();
		boolean verifyAlrtBox = true;
		try {
			driver.findElement(alrtBox);
			verifyAlrtBox = false;
		}
		catch (NoSuchElementException e) {
			verifyAlrtBox = true;
		}
		return verifyAlrtBox;
	}
	
	public void clickClseBtn() {
		driver.findElement(closeFrmAlert).click();
	}

}
