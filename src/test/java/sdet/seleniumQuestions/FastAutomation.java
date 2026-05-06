package sdet.seleniumQuestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FastAutomation {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://fast.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		By speedValueLocator = By.id("speed-value");
		By speedUnitLocator = By.id("speed-units");
		String className;
		while (true) {
			WebElement speedValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedValueLocator));
			WebElement speedUnitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedUnitLocator));
			System.out.println(speedValueElement.getText() + " " + speedUnitElement.getText());
			className = speedValueElement.getAttribute("class");
			if (className != null && className.contains("succeeded"))
				break;
		}
		WebElement speedValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedValueLocator));
		WebElement speedUnitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedUnitLocator));
		System.out.println("---------------Final Speed-----------------------");
		System.out.println(speedValueElement.getText() + " " + speedUnitElement.getText());
		driver.quit();
	}

}
