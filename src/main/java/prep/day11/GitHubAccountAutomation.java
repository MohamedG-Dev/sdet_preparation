package prep.day11;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GitHubAccountAutomation {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://github.com/signup");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		By emailField = By.xpath("//input[@id='email']");
		WebElement emailBox = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
		emailBox.sendKeys("thomas_shelby123@gmail.com");

		By passwordField = By.id("password");
		WebElement passwordBox = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
		passwordBox.sendKeys("!thomas@123!");

		By usernameField = By.id("login");
		WebElement usernameBox = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
		usernameBox.sendKeys("thomas_shelby");

		By countryDropDownButton = By.xpath("//button[contains(@id,'country-dropdown') and @type='button']");
		WebElement countryDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropDownButton));
		countryDropdown.click();

		By dropdownSearchField = By.xpath("//input[contains(@id,'country-dropdown') and @type='search']");
		WebElement dropdownSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownSearchField));
		dropdownSearch.sendKeys("Aruba");

		By countryOption = By.xpath("//span[contains(text(),'Aruba')]/..");
		WebElement countryOptionDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(countryOption));
		countryOptionDropDown.click();

		By userConsentCheckBox = By.id("user_signup[marketing_consent]");
		WebElement userconsentCheckBOX = wait.until(ExpectedConditions.visibilityOfElementLocated(userConsentCheckBox));
		userconsentCheckBOX.click();

	}

}
