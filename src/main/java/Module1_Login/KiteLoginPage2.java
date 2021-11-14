package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage2
{
	@FindBy(xpath = "//input[@id='pin']") private WebElement pin;
	@FindBy(xpath = "//button[text()='Continue ']")	private WebElement ctnBtn;
	
	public KiteLoginPage2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpKiteLoginPage2Pin(String Pin)
	{
		pin.sendKeys(Pin);
	}
	
	public void clickKiteLoginPage2ContinueBtn()
	{
		ctnBtn.click();
	}
}
