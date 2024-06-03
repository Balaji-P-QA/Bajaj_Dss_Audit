package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.POM.LoginPojo;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

public class BaseClass {

	public static WebDriver driver;
	DataFormatter d = new DataFormatter();

	public void launchBrowser(String Browsername) {

		if (Browsername.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver();

		} else if (Browsername.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver();

		} else {

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new FirefoxDriver();

		}

	}

	public void launchURL(String url) {

		driver.get(url);

	}

	public void maxmizeWindow() {
		driver.manage().window().maximize();

	}

	public void minimizeWindow() {
		driver.manage().window().minimize();

	}

	public void closeBrowser() {

		driver.close();

	}

	public void quitBrowser() {

		driver.quit();

	}

	public void hold(int time) throws InterruptedException {

		Thread.sleep(time);

	}

	public void wait(int sec) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));

	}

	public void scrollDown(WebElement scrlocation) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", scrlocation);

	}

	public void scrollUp(WebElement scrlocation) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", scrlocation);

	}

	public void click(WebElement scrlocation) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", scrlocation);

	}

	public Object[][] datas() throws IOException {

		File f = new File("C:\\Users\\balaji.p\\eclipse-workspace 2\\DSS_Audit\\DataStorage\\DSS_Credentials.xlsx");

		FileInputStream fin = new FileInputStream(f);

		Workbook b = new XSSFWorkbook(fin);

		Sheet s = b.getSheetAt(0); // Cre

		int rowsCount = s.getPhysicalNumberOfRows();

		// System.out.println(rowsCount);

		Row r = s.getRow(0);

		short columnCount = r.getLastCellNum();

		// System.out.println(columnCount);

		Object data[][] = new Object[rowsCount - 1][columnCount];

		for (int i = 0; i < rowsCount - 1; i++) {

			Row r1 = s.getRow(i + 1);

			for (int j = 0; j < columnCount; j++) {

				Cell c = r1.getCell(j);

				data[i][j] = d.formatCellValue(c);

			}

		}

		return data;

	}

	public String SS(String testcaseName) throws IOException {

		TakesScreenshot tk = (TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir")+"//Reports"+testcaseName+".png");
		FileUtils.copyFile(src, des);
		return System.getProperty("user.dir")+"//Reports"+testcaseName+".png";
		
	}
	
	

	public void login(String Username,String password) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://bajajdssaudituat.azurewebsites.net/");

		hold(5000);

		maxmizeWindow();

		Thread.sleep(2000);

		System.out.println(Username);
		System.out.println(password);

		LoginPojo l = new LoginPojo(driver);

		l.getTxtField().sendKeys(Username);

		Thread.sleep(2000);

		l.getNextBtnField().click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String usernameValue = l.getUsernameField().getAttribute("value");

		if (usernameValue.equals(Username)) {

			System.out.println("Username is passed properly");

		} else {

			System.out.println("Username is got differetnt which user has been entered");

		}

		l.getPasswordInputField().get(0).sendKeys(password);

		Thread.sleep(2000);

		l.getSignInBtn().get(0).click();

		Thread.sleep(5000);

		if (l.getNumberOftimeTxt().isDisplayed()) {

			String dontshowAgain = "No";

			if (dontshowAgain.equalsIgnoreCase("Yes")) {

				l.getDontShowAgainChkbox().get(0).click();

				l.getYesBtn().click();

				Thread.sleep(2000);

			} else {

				l.getNoBtn().click();

				Thread.sleep(4000);

			}

		}

		String currentUrl = driver.getCurrentUrl();

		if (currentUrl.equals("https://bajajdssaudituat.azurewebsites.net/")) {

			System.out.println("Logged in successfully");

		}

	}
	
	

}
