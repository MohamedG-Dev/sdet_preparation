package prep.day15;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TakingScreenshot {

	public static void main(String[] args) throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		TakesScreenshot screenshot = (TakesScreenshot) (driver);
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./screenshots/screenshot.png"));
		System.out.println(takeScreenshot("google", driver));

	}

	public static String takeScreenshot(String screenshotName, WebDriver driver) {
		TakesScreenshot screenshot = (TakesScreenshot) (driver);
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy HH-mm-ss");
		String timeStamp = simpleDateFormat.format(date);
		String screenshotDestinationPath = "./screenshots/" + screenshotName + " - " + timeStamp + ".png";
		File screenshotFile = new File(screenshotDestinationPath);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotDestinationPath;
	}

}
