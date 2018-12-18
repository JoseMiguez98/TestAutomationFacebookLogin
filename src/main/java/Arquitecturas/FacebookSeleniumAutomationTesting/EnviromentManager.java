package Arquitecturas.FacebookSeleniumAutomationTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EnviromentManager {
		static WebDriver driver = null;
	
		public static WebDriver getWebDriver() {
			if(driver == null) {
				System.setProperty("webdriver.gecko.driver","/home/jose/Escritorio/jose/eclipse/gecko/geckodriver");

				driver = new FirefoxDriver();	
			}
			return driver;
		}
		
		public static void shutdownDriver() {
			if(driver != null) {
				driver.quit();	
			}
		}
}
