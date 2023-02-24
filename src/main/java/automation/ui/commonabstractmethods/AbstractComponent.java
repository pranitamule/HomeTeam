package automation.ui.commonabstractmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.ui.pom.CartPage;
import automation.ui.pom.OrdersPage;

public class AbstractComponent {
	WebDriver driver;
	@FindBy(xpath="//li/button[@routerlink=\"/dashboard/cart\"]")
	WebElement cart;
	@FindBy(xpath="//button[@routerlink=\"/dashboard/myorders\"]")
	WebElement orders;
	
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void waitForVisibilityOfElementLoacted(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForDisappearToastMsg(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
		
	}
	
	public void waitForDisappearSpinner(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public CartPage clickOnCart()
	{
		cart.click();
		return new CartPage(driver);
	}
	
	public OrdersPage clickOnOrders() throws InterruptedException
	{
	
		orders.click();
		return new OrdersPage(driver);
		
	}
	
}
