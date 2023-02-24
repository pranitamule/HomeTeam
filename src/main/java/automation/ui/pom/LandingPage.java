package automation.ui.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.ui.commonabstractmethods.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// WebElement userEmail=driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	By toastMsg=By.cssSelector("#toast-container");
	
	public ProductCatlauge loginToApplication(String uEmail,String uPassword)
	{
		userEmail.sendKeys(uEmail);
		password.sendKeys(uPassword);
		submit.click();
		return new ProductCatlauge(driver);
	}
	
	public LandingPage goTO()
	{
		driver.get("https://rahulshettyacademy.com/client");
		return new LandingPage(driver);
	}
	
	public String getErrorMessage()
	{
		waitForVisibilityOfElementLoacted(toastMsg);
		return driver.findElement(toastMsg).getText();
		
	}
	

}
