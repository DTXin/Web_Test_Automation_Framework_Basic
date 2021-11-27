package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPage;

public class Payment_Page extends AbstractPage {

	WebDriver driver;

	@FindBy(name="holder_name")
	public WebElement HOLDER_NAME;

	@FindBy(name="card_number")
	public WebElement CARD_NUMBER;

	@FindBy(name="expiry_month")
	public WebElement EXPIRY_MONTH;

	@FindBy(name="expiry_year")
	public WebElement EXPIRY_YEAR;

	@FindBy(xpath="//input[@type='submit' and @value='Pay now']")
	public WebElement PAYNOW;

	@FindBy(xpath="//input[@name='card_type' and @value='visa']")
	public WebElement VISA_CARD;

	@FindBy(xpath="//input[@name='card_type' and @value='master']")
	public WebElement MASTER_CARD;

	// Constructor
	public Payment_Page(WebDriver driver) {
		this.driver = driver;
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}

	// Method enter information to payment
	public void enterInforPayment(String holder_name, String card_number, String expiry_month, String expiry_year) {
		sendKeyToElement(HOLDER_NAME, holder_name);
		sendKeyToElement(CARD_NUMBER, card_number);
		selectItemInDropDown(EXPIRY_MONTH, expiry_month);
		selectItemInDropDown(EXPIRY_YEAR, expiry_year);
	}

	// Click to choose visa card type
	public void chooseVisaCard() {
		chooseARadioElement(VISA_CARD);
	}

	// Click to choose master card type
	public void chooseMasterCard() {
		chooseARadioElement(MASTER_CARD);
	}
}