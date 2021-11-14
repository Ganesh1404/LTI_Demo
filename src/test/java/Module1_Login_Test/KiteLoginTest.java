package Module1_Login_Test;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Library_Files.BaseClass;
import Library_Files.Utility;
import Module1_Login.KiteHomePage;
import Module1_Login.KiteLoginPage1;
import Module1_Login.KiteLoginPage2;



public class KiteLoginTest extends BaseClass
{	KiteLoginPage1 page1;
	KiteLoginPage2 page2;
	KiteHomePage home;
	int TCID;
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
	
	@AfterMethod
	public void  logoutToApplication(ITestResult result) throws IOException
	{
		Reporter.log("logout from application", true);
		if (result.getStatus()==ITestResult.FAILURE) 
		{
			Utility.captureScreenshot(driver, TCID);
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
