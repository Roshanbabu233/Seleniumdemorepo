package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public Properties p;
	WebDriver d;

	public WebDriver initializedriver() throws IOException {
		p = new Properties();
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\data.properties";
		FileInputStream fis = new FileInputStream(path);
		p.load(fis);
		String browsername = p.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			d = new ChromeDriver();

		} else if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			d = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			d = new InternetExplorerDriver();
		}
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return d;

	}


public String  takeScreenshot(String testName,WebDriver d) throws IOException
{
	File SourceFile =((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
	 String  destinationFilePath = System.getProperty("user.div")+"\\screenshots\\"+testName+".png";
	FileUtils.copyFile(SourceFile, new File(destinationFilePath));
	return destinationFilePath;
}
}
