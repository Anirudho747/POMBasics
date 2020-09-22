package pageObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Helper;
import utility.ReadUtility;

public class BaseClass {
	
   public static WebDriver driver = null;
   ReadUtility ru = new ReadUtility();
   Helper h = new Helper();
   public ExtentReports report;
   public ExtentTest logger;

   @Parameters("browser")
   @BeforeMethod
   public void startup(@Optional("chrome") String browser)
   {
	   if (browser.equalsIgnoreCase("Chrome"))
	   {
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   }
	   else if (browser.equalsIgnoreCase("Mozilla"))
	   {
	   WebDriverManager.firefoxdriver().setup();
	   driver = new FirefoxDriver();
	   }
	   else
	   {
		   WebDriverManager.iedriver().setup();
		   driver = new InternetExplorerDriver();
	   }
	   
	   String src = "./Reports/"+h.getTimeFormat()+"htmlreport.html";
	   ExtentHtmlReporter ehr = new ExtentHtmlReporter(src);
	   report = new ExtentReports();
	   report.attachReporter(ehr);
	   
	   driver.manage().timeouts().pageLoadTimeout(52,TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	   driver.navigate().to(ru.getURL());
	   driver.manage().timeouts().implicitlyWait(700,TimeUnit.SECONDS);
   }
   
   @AfterMethod
   public void tearDown(ITestResult itr)
   {   
	   if(itr.getStatus()==ITestResult.SUCCESS)
	   {
		   h.screenShot(driver);
		   try {
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(h.screenShot(driver)).build());
		} catch (IOException e) {
			System.out.println("Base Class, Tear down");
		}
	   }
	   report.flush();
	   driver.quit();
   }
   


}
