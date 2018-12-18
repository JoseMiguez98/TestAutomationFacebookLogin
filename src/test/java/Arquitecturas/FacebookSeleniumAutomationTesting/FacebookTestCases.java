package Arquitecturas.FacebookSeleniumAutomationTesting;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Verify;

import junit.framework.Assert;;

public class FacebookTestCases {

	WebDriver driver;
	WebDriverWait wait;

	@Before
	public void initDriver() {
		this.driver = EnviromentManager.getWebDriver();
		this.wait =  new WebDriverWait(driver, 500);
	}

	@SuppressWarnings("deprecation")
	@Test 
	public void testALogin() {
		driver.get("https://www.facebook.com");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginbutton")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginbutton")));

		driver.findElement(By.id("email")).sendKeys("username");
		driver.findElement(By.id("pass")).sendKeys("password");
		driver.findElement(By.id("loginbutton")).click();

		Assert.assertEquals("Facebook", driver.getTitle());
		Verify.verify(driver.getTitle().equals("Facebook"), "You are not logged in");
		
	}
}
