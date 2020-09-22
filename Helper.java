package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	//TakeScreenshot, Alerts,Frames,Windows,Sync issue, JavascriptExecutor, Dropdowns

	public String screenShot(WebDriver driver) {
		
		String dest = "./src/test/resources/Screenshots/SS"+getTimeFormat()+".png";
		TakesScreenshot tss = ((TakesScreenshot)driver);
		File f = tss.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(f, new File(dest));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			System.out.println("Helper->screenshot");
		}
		
		return dest;
	}
	
	   public String getTimeFormat()
	   {
		   SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		   Date curr = new Date();
		   return sdf.format(curr);
	   }

}
