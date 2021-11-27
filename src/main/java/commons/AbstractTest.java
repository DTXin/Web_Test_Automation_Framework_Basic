package commons;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utilities.ExtentReportManager;

public class AbstractTest {

	public static WebDriver driver;
	public static ExtentTest extenttest;
	public static ExtentReportManager manager;
	public static ExtentReports extentreport;

	/*
	 * Setup ExtentReport, ExtentTest
	 */
	@BeforeSuite
	public void setupExtentReport() {
		manager = new ExtentReportManager();
		extentreport  = manager.getInstance();
	}

	/*
	 * Setup Driver
	 */
	public WebDriver setupDriver(String browser){
		// Check if browser is 'chrome' and create driver instance
		if(browser.equalsIgnoreCase(Constants.CHROME_TEXT)) {
			System.setProperty(Constants.DRIVER_CHROME,
					System.getProperty(Constants.FOLDER_PARENTS) + Constants.PATH_DRIVER_CHROME);
			driver = new ChromeDriver();
		}
		// Check if browser is 'firefox' and create driver instance
		else if(browser.equalsIgnoreCase(Constants.FIREFOX_TEXT)) {
			System.setProperty(Constants.DRIVER_FIREFOX,
					System.getProperty(Constants.FOLDER_PARENTS) + Constants.PATH_DRIVER_FIREFOX);
			driver = new FirefoxDriver();
		}
		// Check if browser is 'edge' and create driver instance
		else if(browser.equalsIgnoreCase(Constants.EDGE_TEXT)) {
			System.setProperty(Constants.DRIVER_EDGE,
					System.getProperty(Constants.FOLDER_PARENTS) + Constants.PATH_DRIVER_EDGE);
			driver = new EdgeDriver();
		}
		return driver;
	}

	@Parameters({"browser","url"})
	@BeforeMethod
	public void init(String browser, String url) {
		try {
			driver = setupDriver(browser);
		} catch (Exception e) {
			e.getStackTrace();
		}

		// To open web site from url
		driver.get(url);
		// To maximize browser  
		driver.manage().window().maximize();
		// Implicit wait  
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/*
	 * Close browser when test complete
	 */
	@AfterMethod
	public void quitBrowser() {
		if(driver != null) {
			driver.quit();
		}
	}
}