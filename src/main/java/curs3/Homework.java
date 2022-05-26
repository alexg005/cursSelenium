package curs3;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import utils.BaseTest;

public class Homework extends BaseTest {

	@Test
	private void theForest() throws InterruptedException {
		List<WebElement> titles = driver.findElements(By.cssSelector("li[class*='sc_tabs_title']"));
		By book = By.cssSelector("div[class*='sc_tabs_content'][aria-hidden='false'] a[href='the-forest']");
		String desiredUrl = "https://keybooks.ro/shop/the-forest/";

		for (int i = 0; i < titles.size(); i++) {
			titles.get(i).click();
			if (i != (titles.size() - 1)) {
				Thread.sleep(1000);
				assertTrue(driver.findElement(book).isDisplayed());
			} else {
				driver.findElement(book).click();
				String currentUrl = driver.getCurrentUrl();
				assertTrue(desiredUrl.equals(currentUrl));
			}
		}
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
