package pageObjects;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.LoggerLoad;

public class LoginPage {

	@FindBy (id="username") WebElement username;
	@FindBy (id = "password") WebElement password;
	@FindBy (id = "login") WebElement loginButton;
	@FindBy (tagName = "a") List<WebElement> brokenLinks;
	
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
public void brokenLnks() {
	int size = brokenLinks.size();
	if (size==0) {
		LoggerLoad.info("No Broken Links");
	}
	else {
		for(int i=0; i<size; i++) {
			WebElement e = brokenLinks.get(i);
			String url = e.getAttribute("href");
			verifyLinks(url);
			
		}
		
	}
	
}

public void verifyLinks(String linkUrl) {
	
	
	
	try {
		URL url = new URL(linkUrl);
		HttpsURLConnection httpURLconnection = (HttpsURLConnection)url.openConnection();
		httpURLconnection.setConnectTimeout(5000);
		httpURLconnection.connect();
		if (httpURLconnection.getResponseCode()>=400) {
			System.out.println(linkUrl+"--"+httpURLconnection.getResponseMessage()+"is a broken link");
		}
		else {
			System.out.println(linkUrl+"--"+httpURLconnection.getResponseMessage());
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
