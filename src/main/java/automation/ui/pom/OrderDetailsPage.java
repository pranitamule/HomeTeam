package automation.ui.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.ui.commonabstractmethods.AbstractComponent;

public class OrderDetailsPage extends AbstractComponent {
	WebDriver driver;

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail=driver.findElement(By.id("userEmail"));

	@FindBy(css = ".hero-primary")
	WebElement successMsg;
	@FindBy(xpath = "//tbody/tr[3]/td[@class='em-spacer-1']/label")
	WebElement orderId;

	
	public String  getSuccessMessgeFromDetailsPage()
	{
		return successMsg.getText();
	}
	
	public String getOrderIdFromDetailsPage()
	{
		return orderId.getText();
	}
	
}
