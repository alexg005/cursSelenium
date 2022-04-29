package curs2;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeWork {
	WebDriver driver;
	By buttonLogin = By.cssSelector("li[class=menu_user_login]");
	By emailInput = By.cssSelector("div[class*=login_field]");
	By passwordInput = By.cssSelector("div[class*=password_field]");
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://keybooks.ro/");
		
		
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();		
	}
	
	@Test
	public void checkLogin() {
		boolean found;
		found = driver.findElement(buttonLogin).isDisplayed();
		System.out.println("Login button is present? : " + found);
		assertTrue(found);
		
		found = !driver.findElement(emailInput).isDisplayed();
		System.out.println("Login input field is present? : " + !found);
		assertTrue(found);
		
		found = !driver.findElement(passwordInput).isDisplayed();
		System.out.println("Password input field is present? : " + !found);
		assertTrue(found);
		
		driver.findElement(buttonLogin).click();
		
		found = driver.findElement(emailInput).isDisplayed();
		System.out.println("Login input field is present? : " + found);
		assertTrue(found);
		
		found = driver.findElement(passwordInput).isDisplayed();
		System.out.println("Password input field is present? : " + found);
		assertTrue(found);
	}		
}
