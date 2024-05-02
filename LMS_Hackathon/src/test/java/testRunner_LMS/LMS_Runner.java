package testRunner_LMS;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin  = {"pretty","html:target/LMS.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},  //cucumber reports
		
		monochrome = true,  //console output color and eliminate junk characters
		tags = "",  //tags from feature file
		features = {"src/test/resources/Features_LMS"}, //location of feature files, we can give this way-->".//features//"
		glue= {"stepDefinitions_LMS","hooks"}) //location of step definition files, gives granural level of info in test result

public class LMS_Runner {

}
