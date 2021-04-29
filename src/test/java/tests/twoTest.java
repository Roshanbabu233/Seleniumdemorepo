package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Resources.Base;

public class twoTest extends Base {
	public WebDriver d;
	@Test
	
	public void twotest() throws IOException, InterruptedException
	{
		 d = initializedriver();
		d.get("http://tutorialsninja.com/demo/");
		Thread.sleep(3000);
		d.close();
	}

}
