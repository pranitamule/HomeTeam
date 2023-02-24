package automation.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.ui.TestCommonComponent.BaseTest;
import automation.ui.pom.CartPage;
import automation.ui.pom.ProductCatlauge;

public class ErrorValidationTest extends BaseTest {
	@Test
	public void testToVerifyLoginWithIncorrectUserNameAndPwd() {
		landingPage.loginToApplication("abc@gmail.com", "12345678");

		Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");

	}

	@Test
	public void testToVerifyProductGetsAddedToTheCart() {
		String productName = "zara coat 3";
		ProductCatlauge pCatLouge;
		pCatLouge = landingPage.loginToApplication("test45@gmail.com", "Test@123");
		pCatLouge.clickOnAddToCart(productName);
		CartPage cartpage = pCatLouge.clickOnCart();

		Assert.assertTrue(cartpage.isItemPresentIntoCart(productName));
	}

	@Test

	public void testToDataVerify() {
		System.out.println("second test");
	}

	@Test
	public void testNewFeatureOfGit() {
		System.out.println("Hi I am From New");

	}
}
