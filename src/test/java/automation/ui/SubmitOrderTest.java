package automation.ui;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.ui.TestCommonComponent.BaseTest;
import automation.ui.pom.CartPage;
import automation.ui.pom.CheckOutPage;
import automation.ui.pom.LandingPage;
import automation.ui.pom.OrderDetailsPage;
import automation.ui.pom.ProductCatlauge;

public class SubmitOrderTest extends BaseTest {
	@Test
	public void endToEndBasicTest() throws IOException {
		String productName="zara coat 3";
		landingPage.loginToApplication("test45@gmail.com", "Test@123");

		ProductCatlauge pCatLouge = new ProductCatlauge(driver);
		pCatLouge.clickOnAddToCart(productName);
		CartPage cartpage = pCatLouge.clickOnCart();

		Assert.assertTrue(cartpage.isItemPresentIntoCart(productName));
		CheckOutPage cPage = cartpage.clickOnCheckOutBtn();

		cPage.selectContryFromDropDown("india");
		OrderDetailsPage odPage = cPage.clickOnSubmitBtn();

		String actualSuccessMsg = odPage.getSuccessMessgeFromDetailsPage();
		Assert.assertTrue(actualSuccessMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}

}
