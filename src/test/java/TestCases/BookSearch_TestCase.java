package TestCases;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModel.BookSearch_POM;

public class BookSearch_TestCase {
	Logger log = Logger.getLogger(BookSearch_TestCase.class);
	@Test(dataProvider ="Valid_BookSearch",dataProviderClass = DataProvider.DP_bookSearch.class,groups = {"SmokeTest","RegressionTest"})
	public void Valid_bookSearch(String TC_ID, String Search_Book, String Exp_Count)
	{
		int i =1;
		System.out.println(i);
		log.info("Execution Starting for Testcase: "+ TC_ID +" Valid_bookSearch" );
		System.out.println(TC_ID+"   "+  Search_Book+"  "+ Exp_Count);
		BookSearch_POM booksearchPOM = new BookSearch_POM();
		booksearchPOM.setBrowser();
		booksearchPOM.Entertext_search(Search_Book);
		booksearchPOM.Click_button_Search_for_book();
		String searchResult = booksearchPOM.gettext_SearchResult();
		String expected = Exp_Count.replace(".0", "");
		if (searchResult.equalsIgnoreCase(expected))
		{
			log.info("Assertion pass");
		}
		else
		{
			log.error("Assertion fail . Execution Terminated");
			Assert.fail();
		}		
		
		
		booksearchPOM.Close_Browser();
		log.info("Execution Ending for Testcase: "+ TC_ID +" Valid_bookSearch");
		i++;
	}

}
