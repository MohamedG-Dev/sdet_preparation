package sdet.seleniumQuestions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadFileToSpecificLocation {

	public static void main(String[] args) throws InterruptedException {
		String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "downloads";
		File file = new File(filePath);
		if (!file.exists()) {
			System.out.println("downloads folder is not present");
			if (file.mkdirs()) {
				System.out.println("Created a folder named downloads");
			}
		}

		Map<String, Object> preferences = new HashMap<>();
		preferences.put("download.default_directory", filePath);// --
		preferences.put("download.prompt_for_download", false);// --
		preferences.put("download.directory_upgrade", true);
		preferences.put("safebrowsing.enabled", true);
		preferences.put("safebrowsing.disable_download_protection", true);
		preferences.put("profile.default_content_settings.popups", 0);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://github.com//sakinala/AutomationTesting/raw/master/samplefile.pdf");
		// driver.get("https://get.jenkins.io/war-stable/2.555.1/jenkins.war");
		
		//check if the file has been downloaded successfully
		File downloadedFile = new File(filePath,"samplefile.pdf");
		int timeout = 10;
		int elapsedTime =0;
		while(elapsedTime<=timeout&&!downloadedFile.exists()) {
			Thread.sleep(1000);
			elapsedTime++;
			System.out.println("waiting for the file to download");
		}
		
		if(downloadedFile.exists())
			System.out.println("File is downloaded");
		else
			System.err.println("File could not be downloaded!!!");
		
		downloadedFile.delete();
		
		if(!downloadedFile.exists())
			System.out.println("Downloaded file is deleted successfully");
		else
			System.err.println("Downloaded file was not deleted");
		
		driver.quit();

	}

}
