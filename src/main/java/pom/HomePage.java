package pom;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage{
	//Variables //declaration part 
	@FindBy(className = "sign-in") private WebElement homePageSignInButton;
	@FindBy(xpath = "(//input[@type='number'])[2]") private WebElement mobileNumberField;
	@FindBy(xpath = "(//span[text()='Sign in with Password'])[2]") private WebElement signInWithPassword;
	@FindBy(name = "password") private WebElement passwordField;
	@FindBy(xpath = "//a[@id='login-in-with-password']") private WebElement signInButton;
	@FindBy(className = "userprofile") private WebElement myAccount;
	@FindBy(xpath = "//span[text()=' My profile ']") private WebElement myProfile;
	
	//constructor	//Initialization part 
	public HomePage(WebDriver driver)
	{
	PageFactory.initElements(driver,this);
	}
	//methods		//utilization part 
	public void clickHomePageOnSignInButton()
	{
	Reporter.log("clicking on HomePageOnSignIn Button", true);
	homePageSignInButton.click();
	}
	public void enterMobileNumber(String mobNum)
	{
	Reporter.log("entering mobile number", true);
	mobileNumberField.sendKeys(mobNum);
	}
	public void clickOnSignInWithPasswordButton()
	{
	Reporter.log("clicking On SignIn WithPassword Button", true);
	signInWithPassword.click();
	}
	public void enterPassword(String password)
	{
	Reporter.log("entering password", true);
	passwordField.sendKeys(password);
	}
	public void clickOnSignInButton()
	{
	Reporter.log("clicking On SignIn Button", true);
	signInButton.click();
	}
	public void clickOnMyAccount()
	{
	Reporter.log("clicking On MyAccount", true);
	myAccount.click();
	}
	public void clickOnMyProfile()
	{
	Reporter.log("clicking On MyProfile", true);
	myProfile.click();
	}
}
