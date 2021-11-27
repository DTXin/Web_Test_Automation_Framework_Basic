package testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.Flight_Page;
import pageObject.Login_Page;
import pageObject.Passenger_Page;
import commons.AbstractTest;
import commons.Constants;

public class Flight_Test extends AbstractTest {

	private Login_Page login;
	private Flight_Page flight;
	private Passenger_Page passenger;

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
	public void TC_03_Flight_One_Trip() {
		try {
			passenger = flight.bookAFlight_OneTrip("Sydney", "New York", "02", "May 2016");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Assert.assertTrue(passenger.isControlDisplayed(passenger.SOURCE_BODY,Constants.EXPECTED_FLIGHT_ONETRIP));
	}

	@Test
	public void TC_04_Flight_Return_Trip(){
		try {
			passenger = flight.bookAFlight_ReturnTrip("Sydney", "New York", "02", "May 2016", "04", "June 2016");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Assert.assertTrue(passenger.isControlDisplayed(passenger.SOURCE_BODY,Constants.EXPECTED_FLIGHT_ONETRIP));
		Assert.assertTrue(passenger.isControlDisplayed(passenger.SOURCE_BODY,Constants.EXPECTED_FLIGHT_RETURNTRIP));
	}
}