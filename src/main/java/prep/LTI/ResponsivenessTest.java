package prep.LTI;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ResponsivenessTest {

	private WebDriver driver;
	private WebDriverWait wait;
	private Map<String, Dimension> deviceMap = new HashMap<>() {
		{
			put("pixel", new Dimension(412, 915));
			put("tablet", new Dimension(912, 1368));
			put("desktop", new Dimension(1280, 800));
		}
	};

	@BeforeMethod(description = "Launching Chrome Browser")
	public void setup() {

		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
				+ "java" + File.separator + "prep" + File.separator + "LTI" + File.separator + "responsiveness.html");

	}

	@Test(description = "check if webpage is responsive or not")
	public void responsiveTest() {
		for (Map.Entry<String, Dimension> entry : deviceMap.entrySet()) {
			if (entry.getKey().equalsIgnoreCase("pixel")) {
				System.out.println("Running Tests for pixel");
				driver.manage().window().setSize(entry.getValue());
				WebElement hamburgerIcon = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile-hamburger")));
				Assert.assertTrue(hamburgerIcon.isDisplayed(), "Hamburger Menu is not displayed for the pixel device");
				hamburgerIcon.click();
				WebElement homeOption = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-target='Home']")));
				Assert.assertTrue(homeOption.isDisplayed(),
						"Home option is not displayed when clicked on Hamburger menu");
			} else if (entry.getKey().equalsIgnoreCase("tablet")) {
				System.out.println("Running Tests for tablet");
				driver.manage().window().setSize(entry.getValue());
				WebElement homeOption = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-target='Home']")));
				Assert.assertTrue(homeOption.isDisplayed(),
						"Home option is not displayed in the navigation for Tablet View");
			} else if (entry.getKey().equalsIgnoreCase("desktop")) {
				System.out.println("Running Tests for desktop");
				driver.manage().window().setSize(entry.getValue());
				WebElement homeOption = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-target='Home']")));
				Assert.assertTrue(homeOption.isDisplayed(),
						"Home option is not displayed in the navigation for Desktop View");
			}

		}
		
		driver.quit();
	}
}
