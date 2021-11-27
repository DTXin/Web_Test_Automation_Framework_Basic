package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPage;

public class Flight_Page extends AbstractPage{

	private WebDriver driver;

	@FindBy(xpath="//input[@name='tripType' and @value='oneway']")
	private WebElement ONE_TRIP;

	@FindBy(xpath="//input[@name='tripType' and @value='return']")
	private WebElement RETURN_TRIP;

	@FindBy(name="fromPort")
	private WebElement FROM_PORT;

	@FindBy(name="toPort")
	private WebElement TO_PORT;

	@FindBy(name="departDay")
	private WebElement DEPARTING_DAY;

	@FindBy(name="departMonth")
	private WebElement DEPARTING_MONTH;

	@FindBy(name="returnDay")
	private WebElement RETURN_DAY;

	@FindBy(name="returnMonth")
	private WebElement RETURN_MONTH;

	@FindBy(xpath="//input[@type='submit']")
	private WebElement CONTINUE;

	@FindBy(id="user_nav")
	public WebElement USER_NAV;

	// Constructor
	public Flight_Page(WebDriver driver) {
		this.driver = driver;
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}

	// Book a Flight One Trip
	public Passenger_Page bookAFlight_OneTrip(String from_port, String to_port, 
			String depart_day, String depart_month) {
		// Click one trip radio
		chooseARadioElement(ONE_TRIP);
		selectItemInDropDown(FROM_PORT, from_port);
		selectItemInDropDown(TO_PORT, to_port);
		selectItemInDropDown(DEPARTING_DAY, depart_day);
		selectItemInDropDown(DEPARTING_MONTH, depart_month);
		
		clickToElement(CONTINUE);
		return new Passenger_Page(driver);
	}

	// Book a Flight Return Trip
	public Passenger_Page bookAFlight_ReturnTrip(String from_port, String to_port, String depart_day, 
			String depart_month, String return_day, String return_month) {
		// Click return trip radio
		chooseARadioElement(RETURN_TRIP);
		selectItemInDropDown(FROM_PORT, from_port);
		selectItemInDropDown(TO_PORT, to_port);
		selectItemInDropDown(DEPARTING_DAY, depart_day);
		selectItemInDropDown(DEPARTING_MONTH, depart_month);
		selectItemInDropDown(RETURN_DAY, return_day);
		selectItemInDropDown(RETURN_MONTH, return_month);
		
		clickToElement(CONTINUE);
		return new Passenger_Page(driver);
	} 
}