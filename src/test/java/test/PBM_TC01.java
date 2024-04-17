package test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pom.HomePage;
import pom.ProfilePage;
import util.Utility;
//@Listeners(listener.Listener.class)
public class PBM_TC01 extends Base{
	  HomePage home;
	  ProfilePage pro;
	
	  @BeforeClass
	  public void openBrowser() throws InterruptedException, IOException
	  {
		  launchBrowser("chrome");
		  home = new HomePage(driver);
		  pro = new ProfilePage(driver);
		  Utility.waitTime(2000);
		  
	  }
	  @BeforeMethod
	  public void loginTOPolicyBazaar() throws InterruptedException, IOException 
	  {
		  home.clickHomePageOnSignInButton();
		  Utility.waitTime(1000);
		  home.enterMobileNumber(Utility.readDataFromExcel(0, 0));
		  Utility.waitTime(1000);
		  home.clickOnSignInWithPasswordButton();
		  Utility.waitTime(1000);
		  home.enterPassword(Utility.readDataFromExcel(0, 1));
		  Utility.waitTime(1000);
		  
//		  for (int i=0; i<=2; i++)
//		  {
//			  for (int j=0; j<=1; j++)
//			  {
//				  Utility.readDataFromExcel(i, j);
//				  Utility.waitTime(3000);
//				  home.clickOnSignInWithPasswordButton();
//			  }
//		  }
		  
		  
		  home.clickOnSignInButton();
		  Utility.waitTime(2000);
		  home.clickOnMyAccount();
		  Utility.waitTime(5000);
		  home.clickOnMyProfile();
		  //there will me multiple tabs, we need to change selenium focus from main tab to child tab
		  Set<String> allID = driver.getWindowHandles();
		  ArrayList<String>al= new ArrayList<>(allID);
		  String mainTabID = al.get(0);
		  String childTabID = al.get(1);
		  driver.switchTo().window(childTabID);
		  Utility.waitTime(1000);
	  }
	  @Test
	  public void validateUserName() throws EncryptedDocumentException, InterruptedException, IOException
	  {
	  Utility.waitTime(2000);
	  String expUN = Utility.readDataFromExcel(0, 2);
	  String actualUN = pro.getActualUserName();
	  Assert.assertEquals(actualUN, expUN,"TC failed, actual and expected user Names are not matching");
	  Utility.takeScreenshot(driver, "PBM_TC01 "+actualUN );
	  }
//	  @Test
//	  public void validateUserName2() throws EncryptedDocumentException, InterruptedException, IOException
//	  {
//	  Utility.waitTime(2000);
//	  String expUN = Utility.readDataFromExcel(1, 2);
//	  String actualUN = pro.getActualUserName();
//	  Assert.assertEquals(actualUN, expUN,"TC failed, actual and expected user Names are not matching");
//	  Utility.takeScreenshot(driver, "PBM_TC01 "+actualUN );
//	  }
	  @AfterMethod
	  public void logOutFromPolicyBazaar() throws InterruptedException
	  {
		  Utility.waitTime(2000);
		  pro.clickOnLogOutButton();
	  
	  }
	  @AfterClass
	  public void quiteBrowser() throws InterruptedException
	  {
		  closeBrowser();
		  Utility.waitTime(5000);
	  }
  }
  
  

