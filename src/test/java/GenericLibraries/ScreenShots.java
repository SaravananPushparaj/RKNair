package GenericLibraries;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {
	
	public static WebDriver captureScreenshots(WebDriver driver) throws Exception
	{
		WebDriver browser = driver; 
		TakesScreenshot scr = (TakesScreenshot)browser;
		File screenshotAs = scr.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("C:\\screenshot.png"));
		return driver;
	}
	

}
