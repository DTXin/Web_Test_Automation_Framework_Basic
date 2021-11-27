package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.Constants;
import pageObject.Flight_Page;
import pageObject.Login_Page;

public class Login_Test extends AbstractTest {

	private Login_Page login;
	private Flight_Page flight;

	@Test
	public void TC_01_Login_OK() {
		login = new Login_Page(driver);
		flight = login.doLogin(Constants.USERNAME, Constants.PASSWORD);
		Assert.assertTrue(flight.isControlDisplayed(flight.USER_NAV, Constants.USERNAME));
	}

	@Test
	public void TC_02_Login_False() {
		login = new Login_Page(driver);
		flight = login.doLogin(Constants.USERNAME, Constants.PASSWORD_WRONG);
		Assert.assertTrue(flight.isControlDisplayed(login.FLASH_ALERT, Constants.INVALID_EMAIL_OR_PASSWORD));
	}

	@Test
	public void TC_02_Login_False_Sreenshot() {
		login = new Login_Page(driver);
		flight = login.doLogin(Constants.USERNAME, Constants.PASSWORD_WRONG);
		Assert.assertTrue(flight.isControlDisplayed(flight.USER_NAV, Constants.USERNAME));
	}
}