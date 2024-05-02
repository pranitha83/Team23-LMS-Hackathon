package utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.SetupDriver;

import java.text.Collator;
import java.time.Duration;
import java.util.ArrayList;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
public class GenericUtils  {
	static WebDriver driver;
	   // SetupDriver driver = new SetupDriver();
      
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	
		
	}
//	
	
	public static boolean assertSortedByAscendingOrder(List<WebElement> elements) {

	    List<String> elementTexts = new ArrayList<>();

	    // Extract text from web elements
	    for (WebElement element : elements) {
	        elementTexts.add(element.getText());
	    }

	    // Check if the elements are sorted in ascending order
	    for (int i = 0; i < elementTexts.size() - 1; i++) { 
	        String currentText = elementTexts.get(i);
	        String nextText = elementTexts.get(i + 1);

	        // Compare current and next text
	        if (currentText.compareTo(nextText) > 0) {
	            return false; // Not sorted in ascending order
	        }
	    }

	    return true; // Sorted in ascending order
	}

	
	
	 public static boolean assertSortedByAscendingOrderStrings(List<WebElement> elements,int groupSize) {

		 
		 Collator collator = Collator.getInstance(Locale.US);
	        collator.setStrength(Collator.SECONDARY);

	        for (int i = 0; i <= elements.size() - groupSize; i++) {
	            List<String> currentGroup = new ArrayList<>();
	            for (int j = 0; j < groupSize; j++) {
	                currentGroup.add(elements.get(i + j).getText());
	            }

	            List<String> sortedGroup = currentGroup.stream()
	                .sorted((s1, s2) -> {
	                    if (isSpecialCharacterOrNumber(s1) && !isSpecialCharacterOrNumber(s2)) {
	                        return -1; // s1 (special character or number) should come before s2 (letter)
	                    } else if (!isSpecialCharacterOrNumber(s1) && isSpecialCharacterOrNumber(s2)) {
	                        return 1; // s1 (letter) should come after s2 (special character or number)
	                    } else {
	                        return collator.compare(s1, s2); // Regular comparison using collator
	                    }
	                })
	                .collect(Collectors.toList());

	            if (!currentGroup.equals(sortedGroup)) {
	                return false;
	            }
	        }
	        return true;
	 }

	 
	 public static boolean assertSortedByDescendingOrderStrings(List<WebElement> elements, int groupSize) {
	        Collator collator = Collator.getInstance(Locale.US);
	        collator.setStrength(Collator.SECONDARY);

	        for (int i = 0; i <= elements.size() - groupSize; i++) {
	            List<String> currentGroup = new ArrayList<>();
	            for (int j = 0; j < groupSize; j++) {
	                currentGroup.add(elements.get(i + j).getText());
	            }

	            List<String> sortedGroup = currentGroup.stream()
	                .sorted((s1, s2) -> {
	                    if (s1.equals(s2)) {
	                        return 0; // Ignore comparison if strings are equal
	                    }
	                    if (isSpecialCharacterOrNumber(s1) && !isSpecialCharacterOrNumber(s2)) {
	                        return 1; // s1 (special character or number) should come after s2 (letter)
	                    } else if (!isSpecialCharacterOrNumber(s1) && isSpecialCharacterOrNumber(s2)) {
	                        return -1; // s1 (letter) should come before s2 (special character or number)
	                    } else {
	                        return collator.compare(s2, s1); // Compare in reverse order using collator
	                    }
	                })
	                .collect(Collectors.toList());

	            if (!currentGroup.equals(sortedGroup)) {
	                return false;
	            }
	        }
	        return true;
	    }
	 
	 private static boolean isSpecialCharacterOrNumber(String s) {
		 if (s == null || s.isEmpty()) {
		        return false; // Handle null or empty strings
		    }
	        char firstChar = s.charAt(0);
	        return !Character.isLetter(firstChar) || Character.isDigit(firstChar);
	    }

	public static boolean assertSortedByDescendingOrder(List<WebElement> elements ) {

		  List<String> elementTexts = new ArrayList<>();

		    // Extract text from web elements
		    for (WebElement element : elements) {
		        elementTexts.add(element.getText());
		    }

		    // Check if the elements are sorted in ascending order
		    for (int i = 0; i < elementTexts.size() - 1; i++) { 
		        String currentText = elementTexts.get(i);
		        String nextText = elementTexts.get(i + 1);

		        // Compare current and next text
		        if (currentText.compareTo(nextText) < 0) {
		            return false; // Not sorted in ascending order
		        }
		    }

		    return true; // Sorted in ascending order
		}

	public static void waitForElement(WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(element));
	}
	
}
	


