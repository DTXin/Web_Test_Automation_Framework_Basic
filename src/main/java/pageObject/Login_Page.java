package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPage;

public class Login_Page extends AbstractPage {

	private WebDriver driver;

	@FindBy(id="username")
	public WebElement USERNAME;

	@FindBy(id="password")
	public WebElement PASSWORD;

	@FindBy(name="commit")
	public WebElement SIGNIN_BUTTON;

	@FindBy(id="flash_alert")
	public WebElement FLASH_ALERT;

	// Constructor.
	public Login_Page(WebDriver driver) {
		this.driver = driver;
		// Initialize Elements.
		PageFactory.initElements(driver, this);
	}

	// Method to login from login page.
	public Flight_Page doLogin(String username, String password) {
		sendKeyToElement(USERNAME, username);
		sendKeyToElement(PASSWORD, password);
		clickToElement(SIGNIN_BUTTON);
		return new Flight_Page(driver);
	}
}