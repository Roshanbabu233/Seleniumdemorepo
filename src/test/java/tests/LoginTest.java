package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;

public class LoginTest extends Base {
	 public WebDriver d;
	Logger log;
	
	
	@Test(dataProvider="getData")
	public void login(String email,String pwd2,String result) throws IOException, InterruptedException
	{
	 
	
	LandingPage land =new LandingPage(d);
	land.MyAccountDropdown().click();
	land.LoginOption().click();
	Thread.sleep(3000);
	
	LoginPage login = new LoginPage(d);
	login.Email().sendKeys(email);
	login.pwd().sendKeys(pwd2);
	login.lbutton().click();
	
	AccountPage a = new AccountPage(d);
	System.out.println(a.Account().isDisplayed());

}
	@BeforeMethod
	public void open() throws IOException
	{
		 log = LogManager.getLogger(LoginTest.class.getName());
		 d = initializedriver();
		 //Log.debug("opening browser");
		 
			
			d.get(p.getProperty("url"));
			log.debug("open");	}
	
	@AfterMethod

	private void closure() {
		d.close();
		
	}
	@DataProvider
	public Object[][] getData()
	{
	Object[][] data= {{"arun.selenium@gmail.com","Second@123","pass"},{"Dummy@tes9t.com","12ytht3244","fail"}};
	return data;
	}
	
	

}
