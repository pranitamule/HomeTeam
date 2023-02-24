package automation.ui;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {
	WebDriver driver;

	@Test
	public void endToEndBasicTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("test45@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Test@123");
		driver.findElement(By.id("login")).click();
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		for (WebElement p : products) {
			if (p.findElement(By.tagName("b")).getText().equalsIgnoreCase("zara coat 3")) {
				p.findElement(By.xpath("//button[text()=' Add To Cart']")).click();
				break;
			}
		}

		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
		driver.findElement(By.xpath("//li/button[@routerlink=\"/dashboard/cart\"]")).click();
		List<WebElement> cartItems = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean flag = false;
		for (WebElement item : cartItems) {
			if (item.getText().equalsIgnoreCase("zara coat 3")) {
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag);

		driver.findElement(By.xpath("//button[text()='Checkout']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".form-group input")));
		driver.findElement(By.cssSelector(".form-group input")).sendKeys("India");
		driver.findElement(
				By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button/span[text()=' India']"))
				.click();
		driver.findElement(By.cssSelector(".action__submit")).click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".toast-title")));

		String text = driver.findElement(By.cssSelector(".hero-primary")).getText();
		String orderId = driver.findElement(By.xpath("//tbody/tr[3]/td[@class='em-spacer-1']/label")).getText();

		driver.findElement(By.xpath("//button[@routerlink=\"/dashboard/myorders\"]")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody/tr/th")));
		List<WebElement> OrderIds = driver.findElements(By.xpath("//tbody/tr/th"));
		boolean f=false;
		for (WebElement element : OrderIds) {
			if (element.getText().equals(orderId)) {
				f = true;
				break;
			}
		}
		Assert.assertTrue(f);
	}

}
