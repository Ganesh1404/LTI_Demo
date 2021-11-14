package Module1_Login_Test;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Library_Files.BaseClass;
import Library_Files.Utility;
import Module1_Login.KiteHomePage;
import Module1_Login.KiteLoginPage1;
import Module1_Login.KiteLoginPage2;



public class KiteLoginTest1 extends BaseClass
{	KiteLoginPage1 page1;
	KiteLoginPage2 page2;
	KiteHomePage home;
	int TCID;
	Reporter logger = null;
	@BeforeClass
	public void openBrowser() throws IOException
	{
		Reporter.log("open browser", true);
		initializeBrowser(null);
		
		page1=new KiteLoginPage1(driver);
		page2=new KiteLoginPage2(driver);
		home=new KiteHomePage(driver);
	}
	
	private void initializeBrowser(Object object) {
		// TODO Auto-generated method stub
		
	}

	@BeforeMethod
	public void  loginToApplication() throws EncryptedDocumentException, IOException
	{
		Reporter.log("login to application", true);
		page1.inpKiteLoginPage1Username(Utility.getPropertyFileData("UN"));
		page1.inpKiteLoginPage1Password(Utility.getPropertyFileData("PWD"));
		page1.clickKiteLoginPage1LoginBtn();
		page2.inpKiteLoginPage2Pin(Utility.getPropertyFileData("PIN"));
		page2.clickKiteLoginPage2ContinueBtn();
	}

	@Test
	public void verifyUserID() throws EncryptedDocumentException, IOException
	{
		Reporter.log("verify User ID: ", true);
		String actUserID=home.verifyKiteHomePageUserID();
		String expUserID=Utility.getTestData(1, 3);
		
		Assert.assertEquals(actUserID, expUserID,"act & exp user id are diffrent:");
		TCID=300;
		
	}
	@Test
	public void passTest() {
		Reporter.log("Pass Test: ", true);
		Assert.assertTrue(true);
		logger.log("The test case passTest has passed");
		TCID=400;
	}
	
	@Test
	public void failTest() {
		Reporter.log("Failed Test: ", true);
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		
		driver.get("https://blazedemo.com");
		String URL=driver.getCurrentUrl();
		Assert.assertEquals(URL, "abc");
		logger.log("Test case failTest has failed");
		TCID=500;
	}
	
	@Test
	public void skipTest() {
		Reporter.log("Skip Test: ", true);
		throw new SkipException("Skipping this method as it is not ready for testing");
	}
	
	@AfterMethod
	public void  logoutToApplication(ITestResult result) throws IOException
	{
		Reporter.log("logout from application", true);
		if (result.getStatus()==ITestResult.FAILURE) 
		{
			Utility.captureScreenshot(driver, TCID);
		}
		else if(result.getStatus()==ITestResult.SKIP){
			logger.log("Test Case skipped is: "+result.getName());
		}
		
	

	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Reporter.log("close browser", true);
		page1 =null;
		page2=null;
		home = null;
		Thread.sleep(3000);
		driver.close();
	}
}