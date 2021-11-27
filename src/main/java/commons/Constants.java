package commons;

public class Constants {
	
	/*
	 * Define constants for set up browser
	 */
	public static final String DRIVER_CHROME = "webdriver.chrome.driver";
	public static final String DRIVER_FIREFOX = "webdriver.gecko.driver";
	public static final String DRIVER_EDGE = "webdriver.edge.driver";
	public static final String CHROME_TEXT = "chrome";
	public static final String FIREFOX_TEXT = "firefox";
	public static final String EDGE_TEXT = "edge";
	public static final String PATH_DRIVER_CHROME = "\\src\\test\\resources\\chromedriver.exe";
	public static final String PATH_DRIVER_FIREFOX = "\\src\\test\\resources\\geckodriver.exe";
	public static final String PATH_DRIVER_EDGE = "\\src\\test\\resources\\msedgedriver.exe";

	/*
	 * Define constants for test case class
	 */
	public static final String FULL_NAME = "Bob Tester";
	public static final String USERNAME = "agileway";
	public static final String PASSWORD = "testwise";
	public static final String PASSWORD_WRONG = "badpass";
	public static final String INVALID_EMAIL_OR_PASSWORD = "Invalid email or password";
	public static final String EXPECTED_FLIGHT_ONETRIP = "2016-05-02 Sydney to New York";;
	public static final String EXPECTED_FLIGHT_RETURNTRIP = "2016-06-04 New York to Sydney";
	public static final String BOOKING_NUMBER = "Booking number";
	public static final String INNERHTML = "innerHTML";

	/*
	 * Define constants for test listener class
	 */
	public static final String TESTCASE_PASS =  "Test case is PASS";
	public static final String TESTCASE_FAIL = "Test case is FAIL";
	
	/*
	 * Define constants for extent report manager class
	 */
	public static final String FOLDER_PARENTS = "user.dir";
	public static final String PATH_SAVE_FILE_EXTENTREPORT = "\\target\\surefire-reports\\html\\extent.html";
	public static final String PATH_LOAD_FILE_CONFIG_EXTENTREPORT = "\\src\\test\\resources\\fileConfig\\ReportsConfig.xml";
	public static final String HOST_NAME = "Host Name: ";
	public static final String HOST_NAME_TEXT = "Practice Selenium WebDriver and Java";
	public static final String ENVIRONMENT = "Environment Required: ";
	public static final String ENVIRONMENT_TEXT = "Java -\r\n"
												+ "Eclipse IDE -\r\n"
												+ "Selenium Webdriver -\r\n"
												+ "TestNG";
	public static final String TESTER_NAME = "User Name";
	public static final String TESTER_NAME_TEXT = "DTXin";

	/*
	 * Define constants for locator of Pages
	 */
	public static final String COMFIRMATION_LOCATOR = "confirmation";
}