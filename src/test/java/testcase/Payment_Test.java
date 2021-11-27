package testcase;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.*;
import commons.AbstractTest;
import commons.Constants;

public class Payment_Test extends AbstractTest {

	private Flight_Page flight;
	private Login_Page login;
	private Passenger_Page passenger;
	private Payment_Page payment;

	@BeforeMethod
	public void init(){
		login = new Login_Page(driver);
		flight = login.doLogin(Constants.USERNAME, Constants.PASSWORD);
		try {
			passenger = flight.bookAFlight_OneTrip("Sydney", "New York", "02", "May 2016");
			payment = passenger.enterInforPassenger("Bob", "Tester");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Test case pay using visa card
	 */
	@Test
	public void TC_06_PayWithVisaCard() throws InterruptedException{
		// Choose visa card from radio button
		payment.chooseVisaCard();
		// Enter information of customer.
		payment.enterInforPayment("John Citizen", "4242424242424242", "02", "2014");
		// Click pay now button
		payment.clickUsingJavaScriptExecutor(driver, payment.PAYNOW);

		// Waiting 20 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		  .withTimeout(Duration.ofSeconds(20))
		  .pollingEvery(Duration.ofSeconds(5))
		  .ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				// Click pay now button and waiting a element display.
				return driver.findElement(By.id(Constants.COMFIRMATION_LOCATOR));
			}
		});
		Thread.sleep(3000);
		Assert.assertTrue(element.getAttribute(Constants.INNERHTML).contains(Constants.BOOKING_NUMBER));
	}

	/*
	 * Test case pay using master card
	 */
	@Test
	public void TC_07_PayWithMasterCard() throws InterruptedException {
		// Choose master card from radio button
		payment.chooseMasterCard();
		// Enter information of customer.
		payment.enterInforPayment("John Citizen", "51234567798746546", "07", "2017");
		// After click pay now button, waiting a element display
		payment.clickUsingJavaScriptExecutor(driver, payment.PAYNOW);

		// Waiting 20 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		  .withTimeout(Duration.ofSeconds(20))
		  .pollingEvery(Duration.ofSeconds(5))
		  .ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				// Click pay now button and waiting a element display.
				return driver.findElement(By.id(Constants.COMFIRMATION_LOCATOR));
			}
		});
		Thread.sleep(3000);
		Assert.assertTrue(element.getAttribute(Constants.INNERHTML).contains(Constants.BOOKING_NUMBER));
	}
}