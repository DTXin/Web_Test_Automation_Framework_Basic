package commons;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AbstractPage {

    // Click a element method
	public void clickToElement(WebElement element) {
		element.click();
	}
	
	// Click a element with java script method
	public void clickUsingJavaScriptExecutor(WebDriver driver,WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// Type text to a element method
	public void sendKeyToElement(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	// Click radio button method
	public void chooseARadioElement(WebElement element) {
		element.click();
	}

	// Select item from drop down method
	public void selectItemInDropDown(WebElement element, String item) {
		Select itemInDropDown = new Select(element);
		itemInDropDown.selectByVisibleText(item);
	}

	// Get attribute value of a element
	public String getAttributeValue(WebElement element, String attribueName) {
		return element.getAttribute(attribueName);
	}

	// Get text of a element
	public String getTextElement(WebElement element) {
		return element.getText();
	}

	// Check a element is or not displayed
	public boolean isControlDisplayed(WebElement element, String value) {
		return getTextElement(element).contains(value);
	}
}