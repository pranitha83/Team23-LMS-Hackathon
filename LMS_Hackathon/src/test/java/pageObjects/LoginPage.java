package pageObjects;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.LoggerLoad;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
public class LoginPage {

	@FindBy (id="username") WebElement username;
	@FindBy (id = "password") WebElement password;
	@FindBy (id = "login") WebElement loginButton;
	@FindBy (tagName = "a") List<WebElement> brokenLinks;
	@FindBy (tagName = "body") WebElement spelltext;
	@FindBy (className ="image-container") WebElement logo;
	@FindBy (xpath = "//p[text()='Please login to LMS application']") WebElement signinContent;
	@FindBy(xpath = "//div[@class='signin-content']//input") List<WebElement> textFields;
	 WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//Entering username and password
	public void enterUserNPassword(String givenusername, String givenpassword) {
		username.sendKeys(givenusername);
		password.sendKeys(givenpassword);
		
		
	}
	//login click
public void loginBtnClk() {
	loginButton.click();
}
//Brokenlinks

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
//Verify
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


public void spellCheck() throws IOException {
    // Get the text from the WebElement (assuming `spelltext` is a WebElement representing the text on the web page)
    String pageText = spelltext.getText();
System.out.println(pageText);
    // Initialize LanguageTool with American English
    JLanguageTool languageTool = new JLanguageTool(new AmericanEnglish());

    try {
        // Perform spell check on the page text
        List<RuleMatch> errors = languageTool.check(pageText);

        // Output errors
        if (errors.isEmpty()) {
            System.out.println("No spelling mistakes found.");
        } else {
            System.out.println("Spelling mistakes found:");
            for (RuleMatch error : errors) {
                // Print the error message and context
                System.out.println("Potential typo at line " + error.getLine() + ", column " + error.getColumn() + ": " + error.getMessage());
                System.out.println("Context: " + error.getShortMessage());
                System.out.println("Suggested correction: " + error.getSuggestedReplacements());
                System.out.println("---");
            }
        }
    } catch (IOException e) {
        // Handle IO exceptions
        e.printStackTrace();
    }
}
//Logocheck

public boolean checkImageAlignment() {
	// String
	// actualImageSrc="https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/assets/img/LMS-logo.jpg";
	int logoLeftX = logo.getLocation().getX();

	// Check if the logo is on the left side of the page (assuming a threshold of 10
	// pixels)
	if (logoLeftX <= 10) {
		System.out.println("Logo is on the left side of the page.");
		return true;
	} else {
		System.out.println("Logo is not on the left side of the page.");
		return false;
	}
}

//logo text
public void logoText() {
	 try {
         // Capture screenshot of the logo element
         File screenshotFile = logo.getScreenshotAs(OutputType.FILE);

         // Use Tesseract to perform OCR on the screenshot
         Tesseract tesseract = new Tesseract();
         // Set the tessdata path if necessary
         // tesseract.setDatapath("path/to/tessdata");

         // Perform OCR on the screenshot
         String extractedText = tesseract.doOCR(screenshotFile);
         System.out.println("Extracted text from logo: " + extractedText);
     } catch (TesseractException e) {
         System.out.println("Error performing OCR: " + e.getMessage());
     }
}

//signinContent
public String signinContentText() {
	return signinContent.getText();
}
//textfields

public int checkTxtFields() {
	 return textFields.size();
}
}