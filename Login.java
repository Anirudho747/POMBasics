package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	public WebDriver driver; 
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement uID; 
	
	@FindBy(xpath="//input[@name='password']")
	WebElement pssWrd;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//input[@name='btnReset']")
	WebElement Reset;
	
	public Login(WebDriver driver) {
    
		this.driver = driver;
		PageFactory.initElements(driver,this);
	
	}
	
	
	public void logintoPage(String uname,String password)
	{
		System.out.println(uname);
		System.out.println(password);
		uID.clear();
		uID.sendKeys(uname);
		pssWrd.clear();
		pssWrd.sendKeys(password);
		LoginBtn.click();
	}
	
	public void resetFields()
	{
		Reset.click();
	}

}
