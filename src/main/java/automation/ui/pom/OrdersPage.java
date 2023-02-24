package automation.ui.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.ui.commonabstractmethods.AbstractComponent;

public class OrdersPage extends AbstractComponent {
	WebDriver driver;

	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail=driver.findElement(By.id("userEmail"));

	@FindBy(xpath = "//tbody/tr/th")
	List<WebElement> orderIds;

	By orderIdsBy=By.xpath("//tbody/tr/th");

	public List<WebElement> getOrderIds()
	{
		waitForVisibilityOfElementLoacted(orderIdsBy);
		return orderIds;
	}
	
	public boolean isOrderIdPresentIntoOrderDetailsPage(String oId)
	{
		boolean flag = false;
		List<WebElement>ids=getOrderIds();
		for (WebElement element : ids) {
			if (element.getText().equals(oId)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
}
