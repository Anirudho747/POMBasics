package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadUtility {

	public Properties prop = null;
	public String path =System.getProperty("user.dir")+"\\src\\test\\resources\\Config\\Configuration.properties";
	
	public ReadUtility() {
		try {
		FileInputStream fis = new FileInputStream(path);
		prop = new Properties();
		prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println("ReadUtility");
		}
	}
	
	public String getUsername()
	{
		return(prop.getProperty("username"));
	}
	
	public String getpassword()
	{
		return(prop.getProperty("password"));
	}
	
	public String getURL()
	{
		return(prop.getProperty("url"));
	}

}
