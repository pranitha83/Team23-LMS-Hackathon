package driverFactory;

import java.time.Duration;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.PropertyFileReader;

public class SetupDriver {
	public static WebDriver driver;
	static ResourceBundle rb; // for reading properties file
	static String br; // for storing browser name

	private static WebDriver getDriver()  {
		//rb = ResourceBundle.getBundle("config");
		//br = rb.getString("browser");
		try {
			br =  PropertyFileReader.getbrowser();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (br.equalsIgnoreCase("CHROME")) {
			driver = new ChromeDriver();
		} else if (br.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (br.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		//driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;

	}

	public static WebDriver Driver() {

		return driver;

	}

	public void openPage(String url) {
		driver.get(url);
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	
	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void setupDriver() {
		if (driver == null) {
			getDriver();
		}

	}

	public static void TearDown() {
		if (driver != null) {

			driver.quit();
		}

	}

	public static String url() {
		return driver.getCurrentUrl();

	}
	
}
