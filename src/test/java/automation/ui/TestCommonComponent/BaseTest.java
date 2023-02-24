package automation.ui.TestCommonComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import automation.ui.pom.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initializeTest() throws IOException {

		Properties prop = new Properties();
		String userDir = System.getProperty("user.dir");
		String filePath = userDir + "//src//main//java//automation//ui//resources//Global.properties";
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}

	@BeforeMethod
	public void launchApplication() throws IOException {
		driver = initializeTest();
		landingPage = new LandingPage(driver);
		landingPage.goTO();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
