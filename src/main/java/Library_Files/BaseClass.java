package Library_Files;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	public WebDriver driver;
	

	public void initializeBrowser(String browserName) throws IOException
	{	
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ganes\\eclipse-workspace\\Selenium\\Browsers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();	
		driver=new ChromeDriver(options);
		
		driver.get(Utility.getPropertyFileData("URL"));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
}
