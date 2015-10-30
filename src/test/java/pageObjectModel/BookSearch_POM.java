package pageObjectModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BookSearch_POM {
	WebDriver driver = null;
	public void setBrowser()
	{
		driver = new FirefoxDriver();
		driver.get("http://books.rediff.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void Entertext_search(String Search_Book)
	{
		driver.findElement(By.xpath(".//*[@id='srchword']")).sendKeys(Search_Book);
	}
	
	public void Click_button_Search_for_book()
	{
		driver.findElement(By.xpath(".//*[@id='wrap']/div[4]/div/div[2]/input[4]")).click();
	}
	
	public String gettext_SearchResult()
	{
		return driver.findElement(By.xpath(".//*[@id='find']")).getText();
	}
	
	public void Close_Browser()
	{
		driver.close();
	}

}
