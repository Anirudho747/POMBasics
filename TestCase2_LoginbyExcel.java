package testCase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.BaseClass;
import pageObject.Login;
import utility.ExcelDataProvider;

public class TestCase2_LoginbyExcel extends BaseClass {
	
	ExcelDataProvider edp = new ExcelDataProvider();

	@DataProvider(name="dataProd")
	public Object[][] dataProd() {
		
		String src = "./src/test/resources/TestData/Dp.xlsx";
		int rc = edp.getRowCount(src, "S7");
		int cc = edp.getColCount(src, "S7",0);
		
		String dt[][] = new String[rc][cc];
		
		for (int i=1;i<rc;i++)
		{
			for(int j=0;j<cc;j++)
			{
				dt[i-1][j] = edp.getCellData(src, "S7", i, j);
			}
		}
		
		return dt;
	}
	
	@Test(dataProvider="dataProd")
	public void loginLoop(String Username,String password)
	{
		logger = report.createTest("Data Provider");
		System.out.println(Username);
		System.out.println(password);
		Login lg = new Login(driver);
		lg.logintoPage(Username, password);
		logger.pass("Tests happening");
	}

}
