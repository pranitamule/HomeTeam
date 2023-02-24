package automation.ui.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.ui.commonabstractmethods.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail=driver.findElement(By.id("userEmail"));

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartItems;
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkOutBtn;

	public boolean isItemPresentIntoCart(String pName) {
		boolean flag = false;
		for (WebElement item : cartItems) {
			if (item.getText().equalsIgnoreCase(pName)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public CheckOutPage clickOnCheckOutBtn() {
		checkOutBtn.click();
		return new CheckOutPage(driver);
	}

}
