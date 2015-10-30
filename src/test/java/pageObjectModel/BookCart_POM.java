package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import GenericLibraries.ScreenShots;





public class BookCart_POM  {
	
	WebDriver driver = null;
	public void Entertext_Searchword(String Search_Book)
	{
		driver.findElement(By.id("srchword")).sendKeys(Search_Book);
	}
	public void Click_button_Searchbookbutton()
	{
		driver.findElement(By.className("newsrchbtn")).click();
	}
	
	public void click_img_list_firstbook()
	{
		driver.findElement(By.className("newsrchbtn")).click();
	}
	
	public void Click_button_Buynow()
	{
		driver.findElement(By.cssSelector("div.divbooklist:nth-child(3) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)")).click();
	}
	
	public void Click_button_addtoCartbutton() throws Exception
	{
		driver.findElement(By.cssSelector(".addtocartbtn")).click();
		this.driver= ScreenShots.captureScreenshots(driver);
	}
	
	public String gettext_bookname4mCart()
	{
		return driver.findElement(By.cssSelector(".text_height > span:nth-child(2)")).getText();
		
		
	}
	
	public void Click_link_rediffcom(){
		driver.findElement(By.linkText("rediff.com")).click();
	}
	
	public void Window_popup_handler()
	{
		String parentwindow = driver.getWindowHandle();
		if(driver.getWindowHandles().size()>1)
		{
			for(String x : driver.getWindowHandles())
			{
				if(!x.equalsIgnoreCase(parentwindow))
				{
					driver.switchTo().window(x);
					driver.close();
					break;
				}
			}
			
		}
		driver.switchTo().window(parentwindow);
	}
	
	public void click_icon_deletecart()
	{
		driver.findElement(By.cssSelector(".selected_graybg > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > div:nth-child(2)")).click();
	}
	
	public String gettext_emptycart()
	{
		return driver.findElement(By.cssSelector("div.cart_product:nth-child(1) > span:nth-child(1)")).getText();
	}
	
	public void Click_link_Sign_out()
	{
		driver.findElement(By.linkText("Sign out")).click();
	}
	
	public void Close_browser()
	{
	driver.close();
	}
	
	public void setBrowserobjectreference(WebDriver driver)
	{
		this.driver= driver;
	}

}
