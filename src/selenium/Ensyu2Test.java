package selenium;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Ensyu2Test {

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
		WebDriver driver = new ChromeDriver(); //ChromeDriverの作成
		driver.get("http://www.google.com/xhtml"); //get()でブラウザ起動
		 //検索テキストボックスに"Selenium"を入力
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium");
		searchBox.sendKeys(Keys.ENTER);
		WebElement elem = driver.findElement(By.cssSelector(".DKV0Md "));
		System.out.println(elem.getText());
//		List<WebElement> elementList = driver.findElements(By.className("NJo7tc Z26q7c UK95Uc uUuwM"));
//		for (WebElement elem : elementList) {
//			System.out.println(elem);
//		}
	}

}
