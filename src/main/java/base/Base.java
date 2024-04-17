package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import util.Utility;

public class Base {
	
	protected static WebDriver driver;
	public static void launchBrowser(String browser) throws IOException
	{ 
		
		
		if (browser.equals("chrome"))
		{
			Reporter.log("lauching browser", true);
			 driver = new ChromeDriver();
		}else if(browser.equals("firefox"))
		{
			Reporter.log("launching Firefox", true);
			 driver = new FirefoxDriver();
		}
		
		driver.get(Utility.GetProperty("URL"));
		driver.manage().window().maximize();
	}
	
	public static void closeBrowser()
	{
		Reporter.log("Closing browser", true);
		driver.quit();
	}

}
