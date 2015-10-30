package TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;


import pageObjectModel.BookCart_POM;
import pageObjectModel.Login_POM;





public class BookCart_TestCase {
	
	//@Test(dataProvider = "Dp_addcart",dataProviderClass=DataProvider.DP_BookCart.class)
	public void addTocart(String TC_ID, String Uname , String Pwd , String Search_Book , String Quantity, String Exp_Res) throws Exception
	{
		LoginTestcase login = new LoginTestcase();
		Login_POM commonComp_Login = login.commonComp_Login(Uname, Pwd);
		WebDriver driver = commonComp_Login.getbrowser();
		BookCart_POM addcart = new BookCart_POM();
		addcart.setBrowserobjectreference(driver);
		addcart.Entertext_Searchword(Search_Book);
		addcart.Click_button_Searchbookbutton();
		addcart.click_img_list_firstbook();
		addcart.Click_button_Buynow();
		addcart.Click_button_addtoCartbutton();
		String actual = addcart.gettext_bookname4mCart();
		Assert.assertEquals(actual, Exp_Res);
		addcart.Click_link_rediffcom();
		addcart.Window_popup_handler();
		addcart.Click_link_Sign_out();
		addcart.Close_browser();		
		
	}
	
	
	@Test(dataProvider = "Dp_deletecart",dataProviderClass=DataProvider.DP_BookCart.class)
	public void deleteTocart(String TC_ID, String Uname , String Pwd , String Search_Book , String Quantity, String Exp_Res) throws Exception
	{
		LoginTestcase login = new LoginTestcase();
		Login_POM commonComp_Login = login.commonComp_Login(Uname, Pwd);
		WebDriver driver = commonComp_Login.getbrowser();
		BookCart_POM addcart = new BookCart_POM();
		addcart.setBrowserobjectreference(driver);
		addcart.Entertext_Searchword(Search_Book);
		addcart.Click_button_Searchbookbutton();
		addcart.click_img_list_firstbook();
		addcart.Click_button_Buynow();
		addcart.Click_button_addtoCartbutton();
		addcart.click_icon_deletecart();
		String actual = addcart.gettext_emptycart();
		Assert.assertEquals(actual, Exp_Res);
		addcart.Click_link_rediffcom();
		addcart.Window_popup_handler();
		addcart.Click_link_Sign_out();
		addcart.Close_browser();		
		
	}

}
