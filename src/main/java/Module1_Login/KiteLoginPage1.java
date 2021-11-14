package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage1
{
	@FindBy(xpath = "//input[@id='userid']") private WebElement un;
	@FindBy(xpath = "//input[@id='password']") private WebElement pwd;
	@FindBy(xpath = "//button[text()='Login ']") private WebElement login;
	
	public KiteLoginPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpKiteLoginPage1Username(String Username)
	{
		un.sendKeys(Username);
	}
	
	public void inpKiteLoginPage1Password(String Password)
	{
		pwd.sendKeys(Password);
	}
	
	public void clickKiteLoginPage1LoginBtn()
	{
		login.click();
	}


}
