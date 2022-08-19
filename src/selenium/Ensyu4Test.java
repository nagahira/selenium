package selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Ensyu4Test {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {

		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver");
		WebDriver driver = new ChromeDriver();// chromDriver作成
		driver.get("http://www.e-procurement.metro.tokyo.lg.jp/index.jsp");// 東京都電子...へ遷移
		// ポップアップ「OK」クリック
		WebElement ok = driver.findElement(By.cssSelector(".msg_area button"));
		ok.click();
		// 入札情報サービスクリック
		WebElement service = driver
				.findElement(By.cssSelector("#category_menu > ul > li.cat_menu_1 > a:nth-child(1) > img"));
		service.click();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> id = set.iterator();
		// １ページ目
		String win1 = id.next();
		// ２ページ目
		String win2 = id.next();
		// ２ページ目で操作
		driver.switchTo().window(win2);
		// 発注予定情報クリック
		WebElement order = driver.findElement(By.cssSelector("#topMenuBtn03 > a"));
		order.click();

		// 情報を入力（下部の日付 令和4年8月19日から令和4年8月30日まで）
		WebElement startY = driver.findElement(By.cssSelector(
				"body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table.searchCond > tbody > tr:nth-child(17) > td > input[type=text]:nth-child(2)"));
		startY.sendKeys("4");
		WebElement startM = driver.findElement(By.cssSelector(
				"body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table.searchCond > tbody > tr:nth-child(17) > td > input[type=text]:nth-child(3)"));
		startM.sendKeys("8");
		WebElement startD = driver.findElement(By.cssSelector(
				"body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table.searchCond > tbody > tr:nth-child(17) > td > input[type=text]:nth-child(4)"));
		startD.sendKeys("19");
		WebElement finalY = driver.findElement(By.cssSelector(
				"body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table.searchCond > tbody > tr:nth-child(17) > td > input[type=text]:nth-child(8)"));
		finalY.sendKeys("4");
		WebElement finalM = driver.findElement(By.cssSelector(
				"body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table.searchCond > tbody > tr:nth-child(17) > td > input[type=text]:nth-child(9)"));
		finalM.sendKeys("8");
		WebElement finalD = driver.findElement(By.cssSelector(
				"body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table.searchCond > tbody > tr:nth-child(17) > td > input[type=text]:nth-child(10)"));
		finalD.sendKeys("30");
		// 送信ボタンクリック
		WebElement submit = driver.findElement(By.cssSelector(
				"body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table:nth-child(2) > tbody > tr > td > a"));
		submit.click();
		// データ抽出

		List<WebElement> trList = driver
				.findElements(By.cssSelector("body > div.contents > div > form > table.list-data > tbody > tr"));
		int count = 0;
		for (WebElement tr : trList) {
			if (count > 0) {
				List<WebElement> tdList = tr.findElements(By.tagName("td"));
				System.out.println("日付  " + tdList.get(0).getText() + " 契約番号 " +  tdList.get(1).getText() + "  件名  " +  tdList.get(2).getText());
			}
			count++;
		}

	}
}
