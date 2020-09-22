package testCase;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageObject.Login;
import pageObject.BaseClass;
import utility.Helper;
import utility.ReadUtility;

public class TestCase1_Login extends BaseClass {
	
	ReadUtility ru = new ReadUtility();
	
	@Test(priority=1)
	public void Logintopage() {
		
		Reporter.log("Test Started",true);
		logger = report.createTest("Login 1");
		Login lg = new Login(driver);
        Helper h = new Helper();
        Reporter.log("Screenshot Taken",true);
        h.screenShot(driver);
		lg.logintoPage(ru.getUsername(), ru.getpassword());
		logger.info("Information for Login Test");
		logger.pass("Login Test Passed");
		Reporter.log("Test Over",true);
		
	}
	
	@Test(priority=2)
	public void LogOutOfPage() {
		
		Login lg = new Login(driver);
		logger = report.createTest("Logout 2");
		logger.info("Information for Logout Test");
		logger.fail("Login Test Failed");
		
	}

}
