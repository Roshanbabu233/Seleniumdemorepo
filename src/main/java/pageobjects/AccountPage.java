package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver d;
	public  AccountPage(WebDriver d) {
		this.d=d;
		PageFactory.initElements(d, this);
	}
	@FindBy(xpath="//a[normalize-space()='Account']")
	private WebElement Account ;
	
	public WebElement Account()
	{
		return Account;
	}
	
	
		
		
		
		
		
		
	
	
	

}
