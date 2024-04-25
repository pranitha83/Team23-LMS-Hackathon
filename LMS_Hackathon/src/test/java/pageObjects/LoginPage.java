package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy (id="username") WebElement username;
	@FindBy (id = "password") WebElement password;
	@FindBy (id = "login") WebElement loginButton;
	
	
	 WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserNPassword(String givenusername, String givenpassword) {
		username.sendKeys(givenusername);
		password.sendKeys(givenpassword);
		
		
	}
public void loginBtnClk() {
	loginButton.click();
}
}
