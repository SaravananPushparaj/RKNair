package pageObjectModel;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import GenericLibraries.Browser_Handler;
import GenericLibraries.Configurationfile_Handler;
import GenericLibraries.ScreenShots;

public class Login_POM extends Browser_Handler {
		
		public Login_POM() throws Exception
		{
			setBrowser();
		}
		
		public void setURL() throws Exception
		{
			driver.get(Configurationfile_Handler.handlepropertyfile("URL"));
		}
		
		public void Click_SignIn()
		{
			driver.findElement(By.linkText("Sign In")).click();
		}
		
		public void Enter_text_logid(String Uname)
		{
			driver.findElement(By.name("logid")).sendKeys(Uname);
		}
		
		public void Enter_Text_Pwd(String Pwd)
		{
			driver.findElement(By.name("pswd")).sendKeys(Pwd);
		}
		
		public void Click_button_login() throws Exception
		{
			driver.findElement(By.xpath("html/body/table[2]/tbody/tr[1]/td/table[2]/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/table/tbody/tr[6]/td[2]/input")).click();
			this.driver = ScreenShots.captureScreenshots(driver);
			
		}
		
		public String getText_linkedtext_valid_login()
		{
			return driver.findElement(By.xpath("//a[@href='http://mypage.rediff.com/profile/myprofile']")).getText();
		}
		
		public String getText_Invalid_login()
		{
			return driver.findElement(By.xpath("html/body/table[2]/tbody/tr[1]/td/table[1]/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/font/b")).getText();
		}
		
		public void Click_linktext_SignOut()
		{
			driver.findElement(By.linkText("Sign Out")).click();
		}
		
		public void Close_browser()
		{
			Close_driver();
		}
		
		public WebDriver getbrowser()
		{
			return driver;
		}
		
		
	

}
