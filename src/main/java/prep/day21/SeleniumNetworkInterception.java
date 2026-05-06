package prep.day21;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v145.fetch.Fetch;
import org.openqa.selenium.devtools.v145.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v145.fetch.model.RequestStage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumNetworkInterception {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);
		// Access to devtools
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();// Mandatory
		devTools.send(Fetch.enable(
				Optional.of(List
						.of(new RequestPattern(Optional.of("*"), Optional.empty(), Optional.of(RequestStage.REQUEST)))),
				Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), request -> {
			System.out.println("Intercepted");
			System.out.println(request.getRequest().getMethod());
			System.out.println(request.getRequest().getUrl());
			String url = request.getRequest().getUrl();
			if (url.contains("verify")) {
				// intercept and mock response

				System.out.println("Need to mock this api response!!!");
				String jsonResponse = """
												{
						    "status": "SUCCESS",
						    "message": "Citizen registration verified successfully.",
						    "transaction_id": "MOCK TXN-Shelby",
						    "amount_deducted": "₹00.00 (~$1.00 USD)",
						    "username": "thomas",
						    "timestamp": "2026-03-26T14:07:42.646Z"
						}
												""";
				String base64JSONResponse = Base64.getEncoder()
						.encodeToString(jsonResponse.getBytes(StandardCharsets.UTF_8));
				devTools.send(Fetch.fulfillRequest(request.getRequestId(), 200, Optional.empty(), Optional.empty(),
						Optional.of(base64JSONResponse), Optional.empty()));
			} else {
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.empty(), Optional.empty(),
						Optional.empty(), Optional.empty(), Optional.empty()));
			}
		});

		driver.get("http://mock-api.techwithjatin.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("thomas");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("thomas123");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("registerBtn"))).click();
		System.out.println("Register button is clicked successfully");

	}

}
