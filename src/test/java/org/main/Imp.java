package org.main;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.POM.LoginPojo;
import org.POM.Schedule;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v120.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Imp extends BaseClass {

	public Schedule s;
	public String c1;
	public String c2;
	public String c3;
	public String c4;
	public String c5;
	public int c6;
	public int c7;

	@Parameters("browser")
	@Test(priority = 1)
	public void logins(String browser) throws InterruptedException, IOException {

		DataFormatter d = new DataFormatter();

		File f = new File("C:\\Users\\balaji.p\\eclipse-workspace 2\\DSS_Audit\\DataStorage\\DSS_Credentials.xlsx");

		FileInputStream fin = new FileInputStream(f);

		Workbook b = new XSSFWorkbook(fin);

		Sheet sh = b.getSheetAt(0);

		Row r1 = sh.getRow(1);

		Cell c11 = r1.getCell(0);
		c1 = c11.getStringCellValue();

		Cell c22 = r1.getCell(1);
		c2 = c22.getStringCellValue();

		Cell c33 = r1.getCell(2);
		c3 = c33.getStringCellValue();

		Cell c44 = r1.getCell(3);
		c4 = c44.getStringCellValue();

		Cell c55 = r1.getCell(4);
		c5 = c55.getStringCellValue();

		Cell c66 = r1.getCell(5);
		c6 = (int) c66.getNumericCellValue();

		Cell c77 = r1.getCell(6);
		c7 = (int) c77.getNumericCellValue();

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {

						driver = new FirefoxDriver();

		}

		driver.get("https://bajajdssaudituat.azurewebsites.net/");

		hold(5000);

		maxmizeWindow();

	}

	@Test(priority = 2)
	private void login() throws InterruptedException, IOException {

		Thread.sleep(3000);

		LoginPojo l = new LoginPojo(driver);

		System.out.println(c1);

		l.getTxtField().sendKeys(c1);

		Thread.sleep(2000);

		l.getNextBtnField().click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		System.out.println(c2);

		l.getPasswordInputField().get(0).sendKeys(c2);

		Thread.sleep(2000);

		l.getSignInBtn().get(0).click();

		Thread.sleep(2000);

		l.getDontShowAgainChkbox().get(0).click();

		Thread.sleep(2000);

		l.getYesBtn().click();

	}

	@Test(priority = 3)
	public void auditSchedule() throws InterruptedException {

		s = new Schedule(driver);

		Thread.sleep(5000);

		s.getAuditPlanscheduleLink().click();

		driver.navigate().refresh();

		Thread.sleep(5000);

		s.getAddBtn().click();

		WebElement entityTypeDropdowm = s.getEntityTypeDropdowm();

		Select se = new Select(entityTypeDropdowm);

		se.selectByVisibleText(c3);// 1

		Thread.sleep(2000);

		WebElement entityDropdowm = s.getEntityDropdowm();

		Select se2 = new Select(entityDropdowm);

		se2.selectByVisibleText(c4);// 2

		Thread.sleep(2000);

		WebElement auditTemplateDropdowm = s.getAuditTemplateDropdowm();

		Select se3 = new Select(auditTemplateDropdowm);

		se3.selectByVisibleText(c5);// 3

		Thread.sleep(2000);

		s.getCalendar().click();

		Thread.sleep(8000);

		int fromDate = c6;// 4

		int toDate = c7;// 5

		WebElement date = driver.findElement(
				By.xpath("//th[text()='May 2024']/../../following-sibling::tbody//td[text()='" + fromDate + "']"));
		date.click();

		Thread.sleep(3000);

		WebElement date2 = driver.findElement(
				By.xpath("//th[text()='May 2024']/../../following-sibling::tbody//td[text()='" + toDate + "']"));
		date2.click();

		Thread.sleep(2000);

		s.getCalendarApplyBtn().click();

		Thread.sleep(2000);

		s.getIsNewChkbx().click();

		Thread.sleep(2000);

		s.getSaveBtn().click();

		Thread.sleep(1000);

		System.out.println(driver.findElement(By.xpath("//div[@class='toast-message']")).getText());

		Assert.assertEquals(false, "Making script fail");

	}

}
