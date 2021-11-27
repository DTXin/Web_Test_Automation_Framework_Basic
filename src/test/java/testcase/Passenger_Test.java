package testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.*;
import commons.AbstractTest;
import commons.Constants;

public class Passenger_Test extends AbstractTest{

	private Flight_Page flight;
	private Login_Page login;
	private Passenger_Page passenger;
	private Payment_Page payment;

	@BeforeMethod
	public void init(){
		try {
			login = new Login_Page(driver);
			flight = login.doLogin(Constants.USERNAME, Constants.PASSWORD);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void TC_05_PassengerName() throws InterruptedException {
		try {
			passenger = flight.bookAFlight_OneTrip("Sydney", "New York", "02", "May 2016");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		payment = passenger.enterInforPassenger("Bob", "Tester");
		Assert.assertEquals(payment.getAttributeValue(payment.HOLDER_NAME, "value"), Constants.FULL_NAME);
	}
}