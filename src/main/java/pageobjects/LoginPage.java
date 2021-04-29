package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver d;

	public LoginPage(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(id = "input-email")
	private WebElement Email;
	@FindBy(id = "input-password")
	private WebElement pwd;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement lbutton;

	public WebElement Email() {
		return Email;
	}

	public WebElement pwd() {
		return pwd;
	}
	public WebElement lbutton()
	{
		return lbutton;
	}

}
