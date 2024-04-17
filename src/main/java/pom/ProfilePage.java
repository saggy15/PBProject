package pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ProfilePage {

	
	@FindBy (xpath = "//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']") private WebElement userName;
	@FindBy(className = "h_l") private WebElement logOutButton;
	public ProfilePage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	public String getActualUserName() throws InterruptedException
	{
	Reporter.log("getting actual user name", true);
	
	String actualUN = userName.getText();
	Reporter.log(actualUN+" this is actual UN", true);
	return actualUN;
	}
	
//	public String getActualUserName2() throws InterruptedException
//	{
//	Reporter.log("getting actual user name", true);
//	
//	String actualUN = userName.getText();
//	Reporter.log(actualUN+" this is actual UN", true);
//	return actualUN;
//	}
	
	public void clickOnLogOutButton() throws InterruptedException
	{
	
	Reporter.log("clicking On LogOutButton", true);
	logOutButton.click();
	}
}
