package utilities;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commons.Constants;

public class ExtentReportManager {

	public ExtentReports extent;

	public ExtentReports getInstance() {
		if (extent == null) {

			// initialize the HtmlReporter
			ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty(Constants.FOLDER_PARENTS) + 
					Constants.PATH_SAVE_FILE_EXTENTREPORT);
			try {
				spark.loadXMLConfig(System.getProperty(Constants.FOLDER_PARENTS) + 
						Constants.PATH_LOAD_FILE_CONFIG_EXTENTREPORT);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// initialize ExtentReports and attach the HtmlReporter
			extent = new ExtentReports();
			extent.attachReporter(spark);
			extent.setSystemInfo(Constants.HOST_NAME, Constants.HOST_NAME_TEXT);
			extent.setSystemInfo(Constants.ENVIRONMENT, Constants.ENVIRONMENT_TEXT);
			extent.setSystemInfo(Constants.TESTER_NAME, Constants.TESTER_NAME_TEXT);
		}

		return extent;
	}
}