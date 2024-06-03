package org.main;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends BaseClass {

	// @BeforeClass

	// public String userInput = "balcvcybage3@bajajauto.co.in";
	// public String PasswordInput = "Dell@e5400";

	DataFormatter d = new DataFormatter();

	public Schedule s;
	// public int Totaldates;


	@Test(priority = 2, dataProvider = "Datas")
	private void login(String name, String Username, String password) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://bajajdssaudituat.azurewebsites.net/");

		hold(5000);

		maxmizeWindow();

		Thread.sleep(2000);

		System.out.println(name);

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

	@Test(priority = 3, groups = "Schedule",dataProvider = "Datas")
	public void auditSchedule(String entity_type, String entity, String audtemp, String frmdate, String tDate)
			throws InterruptedException {

		s = new Schedule(driver);

		Thread.sleep(5000);

		s.getAuditPlanscheduleLink().click();

		driver.navigate().refresh();

		Thread.sleep(5000);

		s.getAddBtn().click();

		WebElement entityTypeDropdowm = s.getEntityTypeDropdowm();

		Select se = new Select(entityTypeDropdowm);

		se.selectByVisibleText(entity_type);// 1

		Thread.sleep(2000);

		WebElement entityDropdowm = s.getEntityDropdowm();

		Select se2 = new Select(entityDropdowm);

		se2.selectByVisibleText(entity);// 2

		// Assert.assertEquals(false, "Expected Entity is not available");

		Thread.sleep(2000);

		WebElement auditTemplateDropdowm = s.getAuditTemplateDropdowm();

		Select se3 = new Select(auditTemplateDropdowm);

		se3.selectByVisibleText(audtemp);// 3

		// Assert.assertEquals(false, "Expected Template is not available");

		Thread.sleep(2000);

		s.getCalendar().click();

		Thread.sleep(8000);

		String fromDate = frmdate;// 4
		String toDate = tDate;// 5

		WebElement date = driver
				.findElement(By.xpath("//th[text()='Apr 2024']/../../following-sibling::tbody//td[text()='27']"));
		date.click();

		Thread.sleep(3000);

		WebElement date2 = driver
				.findElement(By.xpath("//th[text()='Apr 2024']/../../following-sibling::tbody//td[text()='28']"));
		date2.click();

		Thread.sleep(2000);

		s.getCalendarApplyBtn().click();

		Thread.sleep(2000);

		s.getIsNewChkbx().click();

		Thread.sleep(2000);

		s.getSaveBtn().click();

		Thread.sleep(1000);

		System.out.println(driver.findElement(By.xpath("//div[@class='toast-message']")).getText());

	}

	@DataProvider(name = "Datas")
	public Object[][] credentials() throws IOException {

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

}
