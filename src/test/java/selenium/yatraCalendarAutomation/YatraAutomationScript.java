package selenium.yatraCalendarAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class YatraAutomationScript {

	@Test
	public void yatraAutomationTestScript() throws InterruptedException {
		// Launch Chrome browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));// synchronizing the webdriver
		driver.get("https://yatra.com/");

		By departureDate = By.xpath("//div[@role='button' and @aria-label='Departure Date inputbox']");
		wait.until(ExpectedConditions.elementToBeClickable(departureDate)).click();

		By calendarMonthsLocator = By.xpath("//div[@class='react-datepicker__month']");

		List<WebElement> calendarMonthsElement = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(calendarMonthsLocator));
		System.out.println(calendarMonthsElement.size());
		By pricesElementsLocator = By.xpath(".//span[contains(@class,'custom-day-content')]");
		Thread.sleep(2000);
		for (WebElement element : calendarMonthsElement) {
			List<WebElement> priceElements = wait.until(d -> element.findElements(pricesElementsLocator));
			int lowestPrice = Integer.MAX_VALUE;
			WebElement priceDateElement=null;
			for (WebElement priceElement : priceElements) {
				String price = priceElement.getText().replace("₹", "").replace(",", "").trim();
				if (price.isEmpty())
					continue;
				System.out.println(price);
				int priceValue = Integer.parseInt(price);
				if (priceValue < lowestPrice) {
					lowestPrice = priceValue;
					priceDateElement = priceElement;
				}
			}
			System.out.println("Lowest price is: " + lowestPrice);
			System.out.println(priceDateElement.findElement(By.xpath(".//../..")).getAttribute("aria-label"));
		}

		driver.quit();
	}

}
