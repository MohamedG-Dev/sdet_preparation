package prep.day19;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IPLWebTableAutomation {
	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.iplt20.com/points-table/men/2025");
		By tableLocator = By.className("ih-td-tab");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		By acceptCookies = By.xpath("//button[contains(@class,'cookie__accept_btn')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookies)).click();
		WebElement pointsTable = wait.until(ExpectedConditions.visibilityOfElementLocated(tableLocator));
		By tbodyLocator = By.id("pointsdata");
		WebElement pointsBody = pointsTable.findElement(tbodyLocator);
		By tableRowLocator = By.tagName("tr");
		List<WebElement> tableRowList = pointsBody.findElements(tableRowLocator);
		System.out.println("Size of the table rows is=> " + tableRowList.size());
		List<TeamPOJO> teamList = new ArrayList<>();
		for (WebElement row : tableRowList) {
			By tableDataRowLocator = By.tagName("td");
			List<WebElement> tabledataList = row.findElements(tableDataRowLocator);
			double nrr = Double.parseDouble(tabledataList.get(7).getText());
			int points = Integer.parseInt(tabledataList.get(10).getText());
			TeamPOJO team = new TeamPOJO(tabledataList.get(0).getText(), tabledataList.get(2).getText(), nrr, points);
			teamList.add(team);
		}
		// find the max point from the teamList
		int maxPoints = teamList.stream().mapToInt(TeamPOJO::getPoints).max().orElse(0);
		TeamPOJO teamMaxNrr = teamList.stream().filter(team -> team.getPoints() == maxPoints)
				.max(Comparator.comparingDouble(i -> i.getNrr())).orElse(null);
		System.out.println(teamMaxNrr);
		driver.quit();
	}
}
