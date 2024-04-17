package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hpsf.Date;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;

public class Utility {
	
	
	public static String GetProperty(String ProName) throws IOException
	{
		FileInputStream myfile = new FileInputStream("configuration\\config.properties");
		Properties p = new Properties();
		p.load(myfile);
		String property = p.getProperty(ProName);
		return property;
	}
	
	public static String readDataFromExcel(int row, int cell) throws IOException
	{
		FileInputStream file = new FileInputStream("Test Data\\mytest.xlsx");
		String myData = WorkbookFactory.create(file).getSheet("Sheet2").getRow(row).getCell(cell).getStringCellValue();
		return myData;
	}
	
	public static void impliciteWait(WebDriver driver, int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	public static void expliciteWait(WebDriver driver, int time,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitTime(int waitTimeSec) throws InterruptedException
	{
	Thread.sleep(waitTimeSec);
	Reporter.log("waiting for "+waitTimeSec+" milisec", true);
	}

	public static void takeScreenshot(WebDriver driver, String filename) throws IOException {
		
		Reporter.log("taking screenshot", true);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String random = RandomString.make(3);
//		Date date = new Date();
//		SimpleDateFormat dateformat = new SimpleDateFormat("hhmmss");
//		String time = dateformat.format(date);
		File dest= new File("Screenshot\\"+filename+""+random+".png");
		FileHandler.copy(src, dest);
		Reporter.log("Taken screenshot and saved at location--> "+dest, true);
		
	}

}
