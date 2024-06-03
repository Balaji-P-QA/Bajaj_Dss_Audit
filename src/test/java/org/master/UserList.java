package org.master;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.POM.UserListPojo;
import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UserList extends BaseClass {

	UserListPojo u = new UserListPojo(driver);

	@Test
	private void userCreation() throws InterruptedException, IOException {

		login("balcvcybage1@bajajauto.co.in", "Dell@e5400");

		Thread.sleep(2000);

		Category.MasterSection();

		Thread.sleep(3000);

		//zWebElement userList = driver.findElement(By.xpath("//a[text()='User List']"));
		WebElement userList = u.getUserList();
		userList.click();

		Thread.sleep(5000);

		String userListWwork = "Create";

		if (userListWwork.equalsIgnoreCase("Create")) {

			// WebElement addUserBtn = driver.findElement(By.xpath("//a[text()='Add
			// User']"));
			WebElement addUserBtn = u.getAddUserBtn();		
	     	addUserBtn.click();

			Thread.sleep(2000);

			// WebElement name = driver.findElement(By.xpath("//input[@id='Name']"));
			WebElement name = u.getName();
			name.sendKeys("Automation_ASM");

			Thread.sleep(2000);

			// WebElement userName =
			// driver.findElement(By.xpath("//input[@id='txt-username']"));
			WebElement userName = u.getUserName();
			userName.sendKeys("Automation_ASM@mailinator.com");

			Thread.sleep(2000);

			// WebElement code = driver.findElement(By.xpath("//input[@id='Code']"));
			WebElement code = u.getCode();
			code.sendKeys("Automation_ASM_1");

			Thread.sleep(2000);

			// WebElement email = driver.findElement(By.xpath("//input[@id='EmailId']"));
			WebElement email = u.getEmail();
			email.sendKeys("Automation_ASM@mailinator.com");

			Thread.sleep(2000);

			// WebElement contactNumber =
			// driver.findElement(By.xpath("//input[@id='ContactNumber']"));
			WebElement contactNumber = u.getContactNumber();
			contactNumber.sendKeys("9833266711");

			Thread.sleep(2000);

			// WebElement role = driver.findElement(By.xpath("//select[@name='RoleId']"));
			WebElement role = u.getRole();
			Select s = new Select(role);
			s.selectByVisibleText("ASM");

			Thread.sleep(2000);

			// WebElement region =
			// driver.findElement(By.xpath("//select[@name='RegionId']"));
			WebElement region = u.getRegion();
			Select r = new Select(region);
			r.selectByVisibleText("Delhi");

			Thread.sleep(2000);

			// WebElement saveBtn = driver.findElement(By.xpath("//button[text()='Save']"));
			WebElement saveBtn = u.getSaveBtn();
			saveBtn.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			try {

				// WebElement toasterMsg =
				// driver.findElement(By.xpath("//div[@class='toast-message']"));
				WebElement toasterMsg = u.getToasterMsg();

				System.out.println(toasterMsg.getText());

			} catch (Exception e) {

				// List<WebElement> WrngMsg = driver
				// .findElements(By.xpath("//span[@class='text-danger error-msg
				// field-validation-error']"));

				List<WebElement> wrngMsg = u.getWrngMsg();

				for (WebElement WrngMsgs : wrngMsg) {

					System.out.println(WrngMsgs.getText());

				}

			}

		} else if (userListWwork.equalsIgnoreCase("Delete")) {

			// WebElement searchTxtbx =
			// driver.findElement(By.xpath("//input[@type='search']"));
			WebElement searchTxtbx = u.getSearchTxtbx();
			searchTxtbx.sendKeys("Automation_ASM_1");

			Thread.sleep(3000);

			try {

				// WebElement deleteBtn = driver.findElement(By.xpath("//a[text()='Delete']"));
				WebElement deleteBtn = u.getDeleteBtn();
				deleteBtn.click();

				Thread.sleep(2000);

				// WebElement popupDeleteConfirm =
				// driver.findElement(By.xpath("//button[@onClick='deleteUser()']"));
				WebElement popupDeleteConfirm = u.getPopupDeleteConfirm();
				popupDeleteConfirm.click();

				// WebElement deleteMsg =
				// driver.findElement(By.xpath("//div[@class='toast-message']"));
				WebElement deleteMsg = u.getDeleteMsg();

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				System.out.println(deleteMsg.getText());

			} catch (Exception e) {

				System.out.println("Expected User is not available");

			}

		}

	}

}
