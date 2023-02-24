package automation.ui.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.ui.commonabstractmethods.AbstractComponent;

public class ProductCatlauge extends AbstractComponent {
	WebDriver driver;

	public ProductCatlauge(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail=driver.findElement(By.id("userEmail"));

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	By producsBy = By.cssSelector(".mb-3");
	By pNameBy = By.tagName("b");
	By addToCartBy = By.xpath("//button[text()=' Add To Cart']");
	By toastMsgBy = By.cssSelector("#toast-container");
	By spinnerBy = By.cssSelector(".ng-animating");

	public List<WebElement> getProducts() {
		waitForVisibilityOfElementLoacted(producsBy);
		return products;
	}

	public WebElement getProductByName(String pName) {
		List<WebElement> products = getProducts();
		WebElement actualProd = null;
		for (WebElement prod : products) {
			if (prod.findElement(pNameBy).getText().equalsIgnoreCase(pName)) {
				actualProd = prod;
				break;
			}

		}
		return actualProd;
	}

	public void clickOnAddToCart(String pName) {
		WebElement actualProd = getProductByName(pName);
		actualProd.findElement(addToCartBy).click();
		waitForDisappearSpinner(spinnerBy);
		waitForDisappearToastMsg(toastMsgBy);
	}

}
