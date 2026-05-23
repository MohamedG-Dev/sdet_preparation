package selenium.RedBusSearchFuntionality;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedBusSearchFunctionality {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://www.redbus.in/");

		By sourceButton = By.xpath("//input[@id='srcinput']/ancestor::div[contains(@class,'srcDestWrapper')]");
		wait.until(ExpectedConditions.elementToBeClickable(sourceButton)).click();

		By searchSuggestionSection = By.xpath("//div[contains(@class,'searchSuggestionWrapper')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchSuggestionSection));

		// WebElement activeElement = driver.switchTo().activeElement();
		// activeElement.sendKeys("Mumbai");

		By srcInput = By.id("srcinput");
		selectLocation(wait, srcInput, "mumbai");

		By destinationInput = By.id("destinput");
		selectLocation(wait, destinationInput, "pune");

		By searchButton = By.xpath("//button[contains(@class,'searchButtonWrapper')]");
		wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

		By closeButton = By.xpath("//button[@aria-label='Close']");
		clickIfVisible(wait, closeButton);

		By primoBus = By.xpath("//div[contains(text(),'Primo Bus')]");
		wait.until(ExpectedConditions.elementToBeClickable(primoBus)).click();

		By busRowLocator = By.xpath("//li[contains(@class,'tupleWrapper')]");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(busRowLocator));

		By eveningBus = By.xpath("//div[contains(text(),'18:00-24:00')]");
		wait.until(ExpectedConditions.elementToBeClickable(eveningBus)).click();

		By subTitleLocator = By.xpath("//span[contains(@class,'subtitle')]");
		String resultsText = null;
		if (wait.until(ExpectedConditions.textToBePresentInElementLocated(subTitleLocator, "buses")))
			resultsText = wait.until(ExpectedConditions.visibilityOfElementLocated(subTitleLocator)).getText();
		System.out.println(resultsText);

		By busesName = By.xpath(".//div[contains(@class,'travelsName')]");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		while (true) {
			List<WebElement> rowList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(busRowLocator));
			List<WebElement> endOfRowList = driver.findElements(By.xpath("//span[contains(text(),'End of list')]"));
			if (!endOfRowList.isEmpty())
				break;
			js.executeScript("arguments[0].scrollIntoView({behavior:'smooth'})", rowList.get(rowList.size() - 1));
		}

		List<WebElement> rowList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(busRowLocator));
		System.out.println("List of Buses: " + rowList.size());
		rowList.stream().flatMap(list -> list.findElements(busesName).stream()).map(WebElement::getText)
				.forEach(System.out::println);

		System.out.println("Total Number of Buses loaded with Primo and 18:00-24:00 filter is: " + rowList.size());

		driver.quit();
	}

	public static boolean clickIfVisible(WebDriverWait wait, By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public static void selectLocation(WebDriverWait wait, By locator, String locationName) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(locationName);

		By searchCategory = By.xpath("//div[contains(@class,'searchCategory')]");
		List<WebElement> searchList = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(searchCategory, 2));
		System.out.println(searchList.size());

		By locationsList = By.xpath(".//div[contains(@class,'listHeader')]");
		List<WebElement> listOfLocations = searchList.get(0).findElements(locationsList);

		listOfLocations.stream().filter(location -> location.getText().equalsIgnoreCase(locationName)).findFirst()
				.ifPresent(WebElement::click);
	}

}
