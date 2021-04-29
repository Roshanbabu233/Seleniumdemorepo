package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver d;
	public  LandingPage(WebDriver d) {
		this.d=d;
		PageFactory.initElements(d, this);
	}
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement MyAccountDropdown ;
	@FindBy(linkText="Login")
	private WebElement LoginOption;
	public WebElement MyAccountDropdown()
	{
		return MyAccountDropdown;
	}
	public WebElement LoginOption()
	{
		return LoginOption;
	}
	
	
		
		
		
		
		
		
	
	
	

}
