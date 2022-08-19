package selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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

class Ensyu3Test {

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
		driver.get("https://rakuplus.jp/"); //ラクプラス立ち上げ
		
		//user名入力
		 WebElement element = driver.findElement(By.name("log"));
		 element.sendKeys("mail");
		 //pwd入力
		WebElement element2 = driver.findElement(By.name("pwd"));
		element2.sendKeys("pwd");
		//ログインボタンクリック　
		WebElement click = driver.findElement(By.name("wp-submit"));
		click.click();
		
		
		
		
		//QAエンジニアへ移動
		WebElement qa = driver.findElement(By.cssSelector("#sgb-css-id-7 > div > a:nth-child(4) > span:nth-child(1) > img"));
		qa.click();
		
		//List<WebElement>で名前（漢字）（ひらがな）　写真のURL取得
		List<WebElement> nameList = driver.findElements(By.cssSelector(".big"));
		List<WebElement> hiraganaList = driver.findElements(By.cssSelector(".has-text-align-center.has-text-color"));
		
		//画像取得処理
		List<WebElement> imgGetList = driver.findElements(By.cssSelector(".wp-block-image img"));
	 
		//System.out.println(imgGetList.get(1));
//		List<WebElement> imgList;
//		for(WebElement img : imgGetList) {
//			if(img.)
//		}
		
			for(int i = 0 ; i < nameList.size(); i++) {
				WebElement name = nameList.get(i);
				WebElement hiragana = hiraganaList.get(i);
				WebElement img = imgGetList.get(i);
				String imgSrc = img.getAttribute("src");
				//WebElement img = imgList.get(i);
				//System.out.println(name.getText());
				//System.out.println("名前 [" + name.getText() +"]" + "   ふりがな [" + hiragana.getText()+"]");
				System.out.println("名前" + name.getText() + " ふりがな" + hiragana.getText() + " 画像" + imgSrc);
			}
	}
//		
}


