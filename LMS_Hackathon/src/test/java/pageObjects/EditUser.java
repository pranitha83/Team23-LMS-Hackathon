package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.SetupDriver;

public class EditUser {
	public WebDriver driver;
	By editBtn = By.xpath("//table//tbody//tr[1]//td[6]//div//span//button[1]");
	By userDtailsPopUp = By.xpath("//div[@class='ng-tns-c132-6 p-dialog-content']");
	By phoneNum = By.xpath("//input[@data-placeholder='Phone no']");
	By emailAddress = By.xpath("//input[@type='email']");
	By timeZone = By.xpath("//input[@data-placeholder='Time Zone']");
	By lastName = By.xpath("//input[@data-placeholder='Last name']");
	By firstName = By.xpath("//input[@data-placeholder='First name']");
	By linkedUrl = By.xpath("//input[@data-placeholder='LinkedIn Url']");
	By middleName = By.xpath("//input[@data-placeholder='Middle name']");
	By locatn = By.xpath("//input[@data-placeholder='Location']");
	By underGrad = By.xpath("//input[@data-placeholder='Under Graduate']");
	By postGrad = By.xpath("//input[@data-placeholder='Post Graduate']");
	By cancelBtn = By.xpath("//form/mat-card//mat-card-actions//button[1]");
	By submitBtn = By.xpath("//button[@type='submit']");
	By successMsg = By.xpath("//div[@role='alert']");
	By errMsg = By.xpath("//div[@role='alert']");

	public EditUser(WebDriver driver) {
		this.driver = driver;
		this.driver = SetupDriver.Driver();
	}

	public void clickEditBtn() {
		driver.findElement(editBtn).click();
	}

	public boolean verifyUserDtailsPopUp() {
		return driver.findElement(userDtailsPopUp).isDisplayed();
	}

	public void getDataFrmExcel(String fname) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement goToNxtPage = driver.findElement(By.xpath("//p-paginator/div/button[3]"));
		boolean flag = false;
		int rows = driver.findElements(By.xpath("//table//tbody//tr")).size();
		while (flag == false) {
			for (int r = 1; r <= rows; r++) {
				String name = driver.findElement(By.xpath("//table//tbody//tr[" + r + "]//td[3]")).getText();
				if (name.contains(fname)) {
					WebElement edtBtn = driver
							.findElement(By.xpath("//table//tbody//tr[" + r + "]//td[6]//div//span//button[1]"));
					edtBtn.click();
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

	public void updateFields() throws InterruptedException {
		driver.findElement(phoneNum).clear();
		driver.findElement(phoneNum).sendKeys("2341234560");
		driver.findElement(emailAddress).clear();
		driver.findElement(emailAddress).sendKeys("Sde@gmail.com");
		driver.findElement(timeZone).clear();
		driver.findElement(timeZone).sendKeys("EST");
	}

	public boolean verifySuccessMsg(String msg) throws InterruptedException {
		Thread.sleep(1000);
		WebElement sucMsg = driver.findElement(successMsg);
		System.out.println("SuccessMsg is " + sucMsg.getText());
		return driver.findElement(successMsg).getText().contains(msg);
	}

	public void updateFieldsWithInvalidValues() {
		driver.findElement(phoneNum).clear();
		driver.findElement(phoneNum).sendKeys("2341");
		driver.findElement(emailAddress).clear();
		driver.findElement(emailAddress).sendKeys("erf@gmail.com");
		driver.findElement(timeZone).clear();
		driver.findElement(timeZone).sendKeys("IndianTime");
	}
	// table/tbody/tr/td[4]

	public boolean verifyErrMsg() throws InterruptedException {
		Thread.sleep(2000);
		WebElement sucMsg = driver.findElement(errMsg);
		System.out.println("ErrorMsg is " + sucMsg.getText());
		String msg = "Failed to update user, as 'TimeZone' is invalid !!";
		return driver.findElement(errMsg).getText().contains(msg);
	}

	public void updateMandFields() throws InterruptedException {
		driver.findElement(phoneNum).clear();
		driver.findElement(phoneNum).sendKeys("2341345456");
		driver.findElement(emailAddress).sendKeys("erf@gmail.com");
		driver.findElement(locatn).clear();
		driver.findElement(locatn).sendKeys("India");
	}

	public boolean checkFielsUpdatd(String fname, String lname) {
		String fullname = fname + " " + lname;
		WebElement location = driver.findElement(By.xpath("//td[text()='" + fullname + "']//following-sibling::td[1]"));
		System.out.println("Location is " + location.getText());
		WebElement phonenum = driver.findElement(By.xpath("//td[text()='" + fullname + "']//following-sibling::td[2]"));
		System.out.println("Phone Num Is " + phonenum.getText());
		if (location.getText().equals("India") && phonenum.getText().equals("2341345456")) {
			return true;
		} else {
			return false;
		}
	}

	public void updateOptinalFields() {
		driver.findElement(middleName).clear();
		driver.findElement(middleName).sendKeys("Patel");
		driver.findElement(emailAddress).sendKeys("ewq@gmail.com");
		driver.findElement(underGrad).clear();
		driver.findElement(underGrad).sendKeys("BE");
		driver.findElement(postGrad).clear();
		driver.findElement(postGrad).sendKeys("ME");
		driver.findElement(timeZone).clear();
		driver.findElement(timeZone).sendKeys("PST");
	}

	public void updateWithNumAndChars() {
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys("123$");
		driver.findElement(middleName).clear();
		driver.findElement(middleName).sendKeys("562");
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys("$$32");
		driver.findElement(locatn).clear();
		driver.findElement(locatn).sendKeys("123");
		driver.findElement(emailAddress).sendKeys("sdq@g");
		driver.findElement(timeZone).clear();
		driver.findElement(timeZone).sendKeys("123$");
		driver.findElement(linkedUrl).clear();
		driver.findElement(linkedUrl).sendKeys("1234");
	}

	public void clickEdtBtnOfTheUsr(String fullname) {
		fullname = "fname" + " " + "lname";
		WebElement editButtn = driver
				.findElement(By.xpath("//td[text()='" + fullname + "']//following-sibling::td[3]//div//span//button"));
		editButtn.click();
	}

	public void clickCancelBtn() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement ele = driver.findElement(cancelBtn);
		js.executeScript("arguments[0].click();", ele);
	}

	public boolean verifyNoPopUp() throws InterruptedException {
		Thread.sleep(2000);
		boolean displayStatus;
		try {
			driver.findElement(userDtailsPopUp).isDisplayed();
			displayStatus = false;
		} catch (NoSuchElementException e) {
			displayStatus = true;
		}
		return displayStatus;
	}

	public boolean chkUsrNtChanged(String fname, String lname, String locatn, String phnnum) throws InterruptedException {
		Thread.sleep(2000);
		String fullname = fname + " " + lname;
		WebElement FullName = driver.findElement(By.xpath("//td[text()='" + fullname + "']"));
		WebElement Locatn = driver.findElement(By.xpath("//td[text()='" + fullname + "']//following-sibling::td[1]"));
		WebElement PhoneNum = driver.findElement(By.xpath("//td[text()='" + fullname + "']//following-sibling::td[2]"));
		if (FullName.getText().equals(fullname) && Locatn.getText().equals(locatn)
				&& PhoneNum.getText().equals(phnnum)) {
			return true;
		} else {
			return false;
		}
	}

}
