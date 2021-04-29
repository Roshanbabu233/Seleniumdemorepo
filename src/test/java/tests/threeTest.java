package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Resources.Base;

public class threeTest extends Base {
	 public WebDriver d;
	
	@Test
	
	public void threetest() throws IOException, InterruptedException
	{
		System.out.println("Roshan updated");
		 d = initializedriver();
		d.get("http://tutorialsninja.com/demo/");
		Thread.sleep(3000);
		Assert.assertTrue(false);
		
		
	}
	@AfterMethod
	public void close()
	{
		d.close();
	}

}
