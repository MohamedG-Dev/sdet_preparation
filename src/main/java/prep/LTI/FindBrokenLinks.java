package prep.LTI;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindBrokenLinks {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://practice-automation.com/broken-links/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (WebElement link : links) {
			checkBrokenLink(link.getDomAttribute("href"));
		}

		driver.quit();
	}

	public static void checkBrokenLink(String link) {
		try {
			URL url = new URL(link);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int statusCode = connection.getResponseCode();
			if (statusCode >= 400) {
				System.out.println("Broken Link: " + link);
			} else if (statusCode >= 200 && statusCode < 400) {
				System.out.println("Valid Link: " + link);
			}
		} catch (IOException e) {
			System.err.println("Exception Caught: " + e.getMessage());
		}
	}
}
