package org.main;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scroll {

	WebDriver driver;

	@BeforeClass
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.axisbank.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	}

	@AfterClass
	public void teardown() {

	//	driver.quit();

	}

	@Test
	private void testcase1() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scroll(0,100)");

	}

}
