package TestCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModel.Login_POM;

public class LoginTestcase {
	Logger log = Logger.getLogger(LoginTestcase.class);
	//@Test(dataProvider = "DP_validlogin",dataProviderClass =DataProvider.DP_Login.class, groups = {"SmokeTest"} )
	public void valid_login(String TC_ID, String Uname, String Pwd, String exp_result) throws Exception
	{
		int i =1;
		System.out.println(i);
		//System.out.println(TC_ID +"   "+Uname+"  "+Pwd+ "   "+exp_result);
		
		/*Login_POM pom = new Login_POM();
		pom.setBrowser();
		pom.Click_SignIn();
		pom.Enter_text_logid(Uname);
		pom.Enter_Text_Pwd(Pwd);
		pom.Click_button_login();*/
		
		LoginTestcase valid_login = new LoginTestcase();
		Login_POM commonComp_valid_Login = valid_login.commonComp_Login(Uname, Pwd);
		String valid_login_actual = commonComp_valid_Login.getText_linkedtext_valid_login();
		//Assert.assertEquals(valid_login_actual, exp_result);
		if (valid_login_actual.equalsIgnoreCase(exp_result))
		{
			log.info("Assertion pass");
		}
		else
		{
			log.error("Assertion fail . Execution Terminated");
			Assert.fail();
		}	
		commonComp_valid_Login.Click_linktext_SignOut();
		commonComp_valid_Login.Close_browser();
		
		i++;
		
	}
	
	//********************************************************************
		//Common Process Component
	
	public Login_POM commonComp_Login(String Uname , String Pwd) throws Exception
	{
		Login_POM pom = new Login_POM();
		pom.setURL();
		pom.Click_SignIn();
		pom.Enter_text_logid(Uname);
		pom.Enter_Text_Pwd(Pwd);
		pom.Click_button_login();
		
		return pom;
	}
	
	
	
	//*******************************************************************
	
	
	
	@Test(dataProvider = "DP_Invalidlogin",dataProviderClass =DataProvider.DP_Login.class,groups = {"RegressionTest"} )
	public void Invalid_login(String TC_ID, String Uname, String Pwd, String exp_result) throws Exception
	{
		int i =1;
		System.out.println(i);
		//System.out.println(TC_ID +"   "+Uname+"  "+Pwd+ "   "+exp_result);
		
		/*Login_POM pom = new Login_POM();
		pom.setBrowser();
		pom.Click_SignIn();
		pom.Enter_text_logid(Uname);
		pom.Enter_Text_Pwd(Pwd);
		pom.Click_button_login();*/
		LoginTestcase Invalid_login = new LoginTestcase();
		Login_POM commonComp_Invalid_Login = Invalid_login.commonComp_Login(Uname, Pwd);
		String Invalid_login_actual = commonComp_Invalid_Login.getText_Invalid_login();
		Assert.assertEquals(Invalid_login_actual, exp_result);
		commonComp_Invalid_Login.Close_browser();
		
		i++;
		
	}

}
