package automation.ui.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import automation.ui.commonabstractmethods.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail=driver.findElement(By.id("userEmail"));

	@FindBy(css = ".form-group input")
	WebElement countryDropDown;
	@FindBy(xpath="//section[@class='ta-results list-group ng-star-inserted']/button/span[text()=' India']")
	WebElement indiaContryOption;	
	@FindBy(css=".action__submit")
	WebElement submitActionBtn;
	
	By countryDropDownBy=By.cssSelector(".form-group input");
By toastMsg=By.cssSelector(".toast-title");
	
	public void selectContryFromDropDown(String cName)
	{
		waitForVisibilityOfElementLoacted(countryDropDownBy);
		countryDropDown.sendKeys(cName);
		indiaContryOption.click();		
	}
	
	public OrderDetailsPage clickOnSubmitBtn() 
	{
		submitActionBtn.click();
		return new  OrderDetailsPage(driver);
	}

}
