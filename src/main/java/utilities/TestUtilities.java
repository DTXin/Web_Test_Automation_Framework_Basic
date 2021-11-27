package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import commons.AbstractTest;
import commons.Constants;

public class TestUtilities extends AbstractTest{
	
	public static String captureScreenshot(String arg0) throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String path = System.getProperty(Constants.FOLDER_PARENTS) + "/screenshots/" + arg0 + ".png";
		// Create another File object variable which points (refer)
		File destination = new File(path);
		
		// Save screen shot at desired path
		FileUtils.copyFile(scrFile, destination);
		
		return path;
	}
}