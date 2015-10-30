package GenericLibraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser_Handler {
	public WebDriver driver = null;
	
	public void setBrowser() throws Exception
	{
		String browsertype = Configurationfile_Handler.handlepropertyfile("browsertype");
		if (browsertype.equalsIgnoreCase(browsertype))
		{
			driver = new FirefoxDriver();
		}
		else if(browsertype.equalsIgnoreCase(browsertype))
		{
			System.getProperty("webdriver.chrome.driver", Configurationfile_Handler.handlepropertyfile("chromedriver_path"));
			driver = new ChromeDriver();
		}
		else if(browsertype.equalsIgnoreCase(browsertype))
		{
			System.getProperty("webdriver.ie.driver", Configurationfile_Handler.handlepropertyfile("iedriver_path"));
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void Close_driver()
	{
		driver.close();
	}

}
