package DataProvider;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import GenericLibraries.Configurationfile_Handler;
import GenericLibraries.Xls_Reader;


public class DP_BookCart {
	@DataProvider(name="Dp_addcart")
	public static Object[][] Add_cart() throws Exception
	{
		DP_BookCart login = new DP_BookCart();
		List<String> xl = login.excelReader("A");
		int size = xl.size();
		Object[][] obj = new Object[size][6];
		
		for (int j=0;j<size;j++)
		{
			obj[j][0] = xl.get(j).split(";")[0];
			obj[j][1] = xl.get(j).split(";")[1];
			obj[j][2] = xl.get(j).split(";")[2];
			obj[j][3] = xl.get(j).split(";")[3];
			obj[j][4] = xl.get(j).split(";")[4];
			obj[j][5] = xl.get(j).split(";")[5];
		}
		
		return obj;
	}
	
	@DataProvider(name="Dp_deletecart")
	public static Object[][] delete_cart() throws Exception
	{
		DP_BookCart login = new DP_BookCart();
		List<String> xl = login.excelReader("D");
		int size = xl.size();
		Object[][] obj = new Object[size][6];
		
		for (int j=0;j<size;j++)
		{
			obj[j][0] = xl.get(j).split(";")[0];
			obj[j][1] = xl.get(j).split(";")[1];
			obj[j][2] = xl.get(j).split(";")[2];
			obj[j][3] = xl.get(j).split(";")[3];
			obj[j][4] = xl.get(j).split(";")[4];
			obj[j][5] = xl.get(j).split(";")[5];
		}
		
		return obj;
	}
	

	
	
	public List<String> excelReader(String flag) throws Exception
	{
		
		List<String> ls = new ArrayList<String>();
		Xls_Reader xl = new Xls_Reader(System.getProperty("user.dir")+"\\"+Configurationfile_Handler.handlepropertyfile("xl_filename"));
		int rowCount = xl.getRowCount("Scenario_BookCart");
		
		for(int i =2; i<=rowCount;i++)
		{
			String Status = xl.getCellData("Scenario_BookCart", "Status", i);
			if(Status.equalsIgnoreCase(flag))
				{
					String TC_ID = xl.getCellData("Scenario_BookCart", "TC_ID", i);
					String Uname = xl.getCellData("Scenario_BookCart", "Uname", i);
					String Pwd = xl.getCellData("Scenario_BookCart", "Pwd", i);
					String Search_Book = xl.getCellData("Scenario_BookCart", "Search_Book", i);
					String Quantity = xl.getCellData("Scenario_BookCart", "Quantity", i);
					String Exp_Res = xl.getCellData("Scenario_BookCart", "Exp_Res", i);
					
					ls.add(TC_ID+";"+Uname+";"+Pwd+";"+Search_Book+";"+Quantity+";"+Exp_Res);
				}
		}
		System.out.println("excelReader method complete");
		return ls;
		
	}

}
