package DataProvider;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import GenericLibraries.Xls_Reader;

public class DP_bookSearch {
	
	@DataProvider(name ="Valid_BookSearch")
	public static Object[][] Valid_bookSearch_DP()
	{
		DP_bookSearch booksearch = new DP_bookSearch();
		List<String> xl_list = booksearch.excel_reader("P");
		Object[][] obj = new Object[xl_list.size()][3];
		
		for(int i=0;i<xl_list.size();i++)
		{
			obj[i][0] =xl_list.get(i).split(";")[0];
			obj[i][1] =xl_list.get(i).split(";")[1];
			obj[i][2] =xl_list.get(i).split(";")[2];
		}
		
		return obj;
		
	}
	
	public List<String> excel_reader(String Key)
	{
		Xls_Reader xl = new Xls_Reader(System.getProperty("user.dir")+"\\Test_Data.xlsx");
		int rowCount = xl.getRowCount("Scenario_BookSearch");
		List<String> list = new ArrayList<String>();
		for(int i=2;i<=rowCount;i++)
		{
			if(xl.getCellData("Scenario_BookSearch", "Status", i).equalsIgnoreCase(Key))
			{
				String TC_ID = xl.getCellData("Scenario_BookSearch", "TC_ID", i);
				String Search_Book = xl.getCellData("Scenario_BookSearch", "Search_Book", i);
				String Exp_Count = xl.getCellData("Scenario_BookSearch", "Exp_Count", i);
				list.add(TC_ID+";"+Search_Book+";"+Exp_Count);
			}
		}
		
		return list;
		
	}

}
