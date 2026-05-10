package selenium.yatraCalendarAutomation;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class YatraAutomationScriptOptimized {

	@Test
	public void yatraAutomationTestScript() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://yatra.com/");

		By departureDate = By.xpath("//div[@role='button' and @aria-label='Departure Date inputbox']");
		wait.until(ExpectedConditions.elementToBeClickable(departureDate)).click();

		WebElement currentMonthElement = getMonthElement(wait, 0);
		WebElement nextMonthElement = getMonthElement(wait, 1);
		String lowestPriceCurrentMonth = getLowestPrice(wait, currentMonthElement);
		String lowestPriceNextMonth = getLowestPrice(wait, nextMonthElement);

		compareTwoPrices(lowestPriceCurrentMonth, lowestPriceNextMonth);

		driver.quit();
	}

	public String getLowestPrice(WebDriverWait wait, WebElement monthElement) {
		By pricesElementsLocator = By.xpath(".//span[contains(@class,'custom-day-content')]");
		List<WebElement> priceElements = wait.until(d -> {
			List<WebElement> elements = monthElement.findElements(pricesElementsLocator);
			return elements.size() > 0 ? elements : null;
		});

		Map.Entry<WebElement, Integer> lowestPriceEntry = priceElements.stream()
				.map(element -> {
					String priceText = element.getText().replace("₹", "").replace(",", "").trim();
					return priceText.isEmpty() ? null : Map.entry(element, Integer.parseInt(priceText));
				})
				.filter(Objects::nonNull)
				.min(Map.Entry.comparingByValue())
				.orElseThrow(() -> new NoSuchElementException("No valid price values were available in the calendar"));

		WebElement priceDateElement = lowestPriceEntry.getKey();
		int lowestPrice = lowestPriceEntry.getValue();

		String dateDescription = priceDateElement.findElement(By.xpath(".//../..")).getAttribute("aria-label");
		return dateDescription + " ---- Price is Rs" + lowestPrice;
	}

	public WebElement getMonthElement(WebDriverWait wait, int index) {
		By calendarMonthsLocator = By.xpath("//div[@class='react-datepicker__month']");
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(calendarMonthsLocator)).get(index);
	}

	public void compareTwoPrices(String currentMonthMinmumPrice, String nextMonthMinmumPrice) {
		int currentMonthRsIndex = currentMonthMinmumPrice.indexOf("Rs");
		int nextMonthRsIndex = nextMonthMinmumPrice.indexOf("Rs");

		String currentMonthPrice = currentMonthMinmumPrice.substring(currentMonthRsIndex + 2);
		String nextMonthPrice = nextMonthMinmumPrice.substring(nextMonthRsIndex + 2);

		int currentPrice = Integer.parseInt(currentMonthPrice);
		int nextPrice = Integer.parseInt(nextMonthPrice);

		if (currentPrice < nextPrice) {
			System.out.println("The lowest of two prices is: " + currentMonthMinmumPrice);
		} else if (currentPrice == nextPrice)
			System.out.println("Both the prices are same. Choose what fits best for you!!!");
		else {
			System.out.println("The lowest of two prices is: " + nextMonthMinmumPrice);
		}
	}
}
