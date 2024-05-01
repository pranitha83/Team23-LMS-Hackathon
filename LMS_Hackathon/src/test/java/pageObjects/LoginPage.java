package pageObjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.junit.Assert;
import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import utilities.LoggerLoad;
import utilities.PropertyFileReader;

public class LoginPage {

	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "login")
	WebElement loginButton;
	@FindBy(tagName = "a")
	List<WebElement> brokenLinks;
	@FindBy(tagName = "body")
	WebElement spelltext;
	@FindBy(className = "image-container")
	WebElement logo;
	@FindBy(xpath = "//p[text()='Please login to LMS application']")
	WebElement signinContent;
	@FindBy(xpath = "//div[@class='signin-content']//input")
	List<WebElement> textFields;
	@FindBy(xpath = "//span[text()='User']")
	WebElement userText;
	@FindBy(xpath = "//span[text()='Password']")
	WebElement passwordText;
	@FindBy(xpath = "//span[text()=' *']")
	WebElement userasterik;
	@FindBy(xpath = "//span[text()=' *']")
	WebElement passwordasterik;
	@FindBy(className = "mat-card-content")
	WebElement alignmentinputfield;
	@FindBy(id = "errormessage")
	WebElement errorMsg;
	@FindBy(xpath = "//mat-form-field[1]//mat-error[@role='alert']")
	WebElement userError;

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterpassword(String givenpassword) {
		password.sendKeys(givenpassword);
	}

//Entering username and password
	public void enterUserNPassword(String givenusername, String givenpassword) {
		username.sendKeys(givenusername);
		password.sendKeys(givenpassword);

	}

	// login click
	public void loginBtnClk() throws InterruptedException {
		loginButton.click();
		Thread.sleep(2000);
	}
//Brokenlinks

	public void brokenLnks() {
		int size = brokenLinks.size();
		if (size == 0) {
			LoggerLoad.info("No Broken Links");
		} else {
			for (int i = 0; i < size; i++) {
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
			HttpsURLConnection httpURLconnection = (HttpsURLConnection) url.openConnection();
			httpURLconnection.setConnectTimeout(5000);
			httpURLconnection.connect();
			if (httpURLconnection.getResponseCode() >= 400) {
				System.out.println(linkUrl + "--" + httpURLconnection.getResponseMessage() + "is a broken link");
			} else {
				System.out.println(linkUrl + "--" + httpURLconnection.getResponseMessage());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void spellCheck() throws IOException {
		// Get the text from the WebElement (assuming `spelltext` is a WebElement
		// representing the text on the web page)
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
					System.out.println("Potential typo at line " + error.getLine() + ", column " + error.getColumn()
							+ ": " + error.getMessage());
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

	public void applicationText(String string) throws TesseractException {
		String expectedText = string;
		// Initialize Tesseract OCR
		String tessDataPath = "C:\\Users\\yours\\git\\Team23-LMS-Hackathon\\LMS_Hackathon\\tessdata";
		System.setProperty("TESSDATA_PREFIX", tessDataPath);
		String path = "./src/test/resources/Test_Data/LMS-logo.jpg";
		ITesseract tesseract = new Tesseract();

		// Set the path to the tessdata directory containing language data
		tesseract.setDatapath(tessDataPath);

		// Optional: Set language for OCR
		tesseract.setLanguage("eng");

		// Perform OCR on the image
		String result = tesseract.doOCR(new File(path));

		// Split the text based on "%;" or "�"
		String[] textParts = result.split("[%�;]");

		// Iterate through the parts to find the relevant text
		// String actualText = null;
		for (String part : textParts) {
			// Check if the part contains "LMS" and not "NumpyNinja"
			if (part.contains("LMS")) {
				// Set the desired text
				String actualText = part.split("€")[0].trim();
				LoggerLoad.info(actualText);
				Assert.assertEquals(expectedText, actualText);
				break; // Exit the loop once "LMS" is found

			}

		}

	}

	public void companyNameText(String string) throws TesseractException {
		String expectedText = string;
		// Initialize Tesseract OCR
		String tessDataPath = "C:\\Users\\yours\\git\\Team23-LMS-Hackathon\\LMS_Hackathon\\tessdata";
		System.setProperty("TESSDATA_PREFIX", tessDataPath);
		String path = "./src/test/resources/Test_Data/LMS-logo.jpg";
		ITesseract tesseract = new Tesseract();

		// Set the path to the tessdata directory containing language data
		tesseract.setDatapath(tessDataPath);

		// Optional: Set language for OCR
		tesseract.setLanguage("eng");

		// Perform OCR on the image
		String result = tesseract.doOCR(new File(path));

		// Split the text based on "%;" or "�"
		String[] textParts = result.split("[%�;]");

		// Iterate through the parts to find the relevant text
		// String actualText = null;
		for (String part : textParts) {
			// Check if the part contains "LMS" and not "NumpyNinja"
			if (part.contains("LMS")) {
				// Set the desired text
				String actualText = part.split("€")[1].trim();
				LoggerLoad.info(actualText);
				Assert.assertEquals(expectedText, actualText);
				break; // Exit the loop once "LMS" is found

			}

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

//Checking user text
	public boolean checkUserTxt() {
		return userText.isDisplayed();

	}

//Checking password text

	public String checkPwrdTxt() {
		return passwordText.getText();
	}

//Checkin user asterik symbol

	public void checkUserAsterik() {
		String textFieldValue = userasterik.getText();
		if (textFieldValue.contains("*")) {
			LoggerLoad.info("Asterisk symbol is present in the User text field.");
		} else {
			LoggerLoad.info("Asterisk symbol is not present in the User text field.");
		}

	}
//checking password asterik

	public void checkPasswordAsterik() throws InterruptedException {
		Thread.sleep(3000);
		String textFieldValue = passwordasterik.getText();
		if (textFieldValue.contains("*")) {
			LoggerLoad.info("Asterisk symbol is present in the password text field.");
		} else {
			LoggerLoad.info("Asterisk symbol is not present in the password text field.");
		}

	}

	public void checkAllignmentOfTextFld() {
		String textFldAllign = alignmentinputfield.getCssValue("text-align");

		Assert.assertEquals("center", textFldAllign);
		LoggerLoad.info("Alignment input field is center position");
	}

//Verify login button is present

	public boolean verifyLogin() {
		return loginButton.isDisplayed();
	}

	public void checkLoginAlign() {
		String loginAlign = loginButton.getCssValue("text-align");
		Assert.assertEquals("center", loginAlign);
	}

	public void checkUserTxtClr() {
		String textColor = userText.getCssValue("color");

		System.out.println(textColor);
		// convert rgba to hex

		String color = Color.fromString(textColor).asHex();
		if (color.equals("#808080")) {
			LoggerLoad.info("User text color is" + "--->" + "gray");

		} else {
			LoggerLoad.info("User text color is" + "--->" + "Not gray");
		}
		Assert.assertEquals("#808080", color);

	}

//public Color convertRGBAToColor(int red, int green, int blue, float alpha) {
//    // Ensure that RGB values are within the valid range (0 to 255)
//    red = Math.min(255, Math.max(0, red));
//    green = Math.min(255, Math.max(0, green));
//    blue = Math.min(255, Math.max(0, blue));
//
//    // Create a Color object with the specified RGB values and alpha value
//    return new Color(red, green, blue, alpha);
//}

//public  Color parseCssColor(String cssColor) {
//    // Parse CSS color string (e.g., "rgba(0, 0, 0, 0.54)")
//    String[] components = cssColor.replace("rgba(", "").replace(")", "").split(",");
//    int red = Integer.parseInt(components[0].trim());
//    int green = Integer.parseInt(components[1].trim());
//    int blue = Integer.parseInt(components[2].trim());
//    float alpha = Float.parseFloat(components[3].trim());
//
//    // Convert RGBA values to Color object
//    return convertRGBAToColor(red, green, blue, alpha);
//    
//    
//}
//public void colorConverter() {
//	ColorConverter converter = new ColorConverter();
//    String textColor = "rgba(0, 0, 0, 0.54)"; // Example CSS color value
//    Color color = converter.parseCssColor(textColor);
//    System.out.println("Color object: " + color);
//}

	public void checkPasswordTxtClr() {
		String textColor = passwordText.getCssValue("color");
		// convert rgba to hex

		String color = Color.fromString(textColor).asHex();

		if (color.equals("#808080")) {
			LoggerLoad.info("User text color is" + "--->" + "gray");

		} else {
			LoggerLoad.info("User text color is" + "--->" + "Not gray");
		}
		Assert.assertEquals("#808080", color);

	}

	public String getErrorMsg() {
		return errorMsg.getText();
	}

	public String getUserError() {

		return userError.getText();
	}

}
