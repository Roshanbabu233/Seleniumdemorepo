package stepdef;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Resources.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;

public class Login extends Base {
	 WebDriver d;
	 LandingPage land;
	 LoginPage login;
	 AccountPage a;

	@Given("^Open any Browser$")
	public void open_any_browser() throws IOException {
	 d= initializedriver();

	}

	@And("^Navigate to Login page$")
	public void navigate_to_login_page() throws InterruptedException {
		d.get(p.getProperty("url"));
		 land =new LandingPage(d);
		land.MyAccountDropdown().click();
		login = new LoginPage(d);
		login.lbutton().click();
		Thread.sleep(3000);
	}

	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void user_enters_username_as_something_and_password_as_something_into_the_fields(String email,
			String pwd2) {
		login.Email().sendKeys(email);
		login.pwd().sendKeys(pwd2);
		

	}

	@And("^User clicks on Login button$")
	public void user_clicks_on_login_button() {
		login.lbutton().click();

	}

	@Then("^Verify user is able to successfully login$")
	public void verify_user_is_able_to_successfully_login() {
		a = new AccountPage(d);
		Assert.assertTrue(a.Account().isDisplayed());

	}
	@After
	public void close()
	{
		d.close();
	}

}
