package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPage;

public class Passenger_Page extends AbstractPage {

	private WebDriver driver;

	@FindBy(name="passengerFirstName")
	public WebElement FIRST_NAME;

	@FindBy(name="passengerLastName")
	public WebElement LAST_NAME;

	@FindBy(xpath="//input[@type='submit' and @value='Next']")
	public WebElement NEXT_BUTTON;

	@FindBy(tagName="body")
	public WebElement SOURCE_BODY;

	// Constructor
	public Passenger_Page(WebDriver driver) {
		this.driver = driver;
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}

	// Enter first name and last name of passenger
	public Payment_Page enterInforPassenger(String firstname, String lastname) {
		sendKeyToElement(FIRST_NAME, firstname);
		sendKeyToElement(LAST_NAME, lastname);
		clickToElement(NEXT_BUTTON);

		return new Payment_Page(driver);
	} 
}