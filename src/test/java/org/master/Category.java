package org.master;

import java.io.IOException;
import java.time.Duration;

import org.POM.MasterPojo;
import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class Category extends BaseClass {

	public JavascriptExecutor js;

	public static MasterPojo m;

	public static void MasterSection() throws InterruptedException {

		m = new MasterPojo(driver);

		Thread.sleep(5000);

		m.getMastertitle().click();

		Thread.sleep(2000);

	}

	@Test(priority = 2, enabled = true)
	private void Category() throws InterruptedException, IOException {

		login("balcvcybage1@bajajauto.co.in", "Dell@e5400");

		MasterSection();

		m = new MasterPojo(driver);

		Thread.sleep(5000);

		// clicking the Category lable/header from master
		m.getCategoryTitle().click();

		Thread.sleep(2000);

		// scrollling down untill add button is visible
		scrollDown(m.getAddCategoryBtn());

		Thread.sleep(2000);

		// click on Add category button
		m.getAddCategoryBtn().click();

		Thread.sleep(2000);

		// entering category name
		m.getCategorynameTxtboxBtn().sendKeys("Check_category");

		Thread.sleep(2000);

		// fetching category name value from category textbox
		String categoryName = m.getCategorynameTxtboxBtn().getAttribute("value");

		// entering cuttoff mark
		m.getCutofmarkTxtboxBtn().sendKeys("5");

		Thread.sleep(2000);

		// fetching cutoff value from cutoff textbox
		String cutofMark = m.getCutofmarkTxtboxBtn().getAttribute("value");

		// changing the cutoff value datatype from string to Integer
		int cutOffMark = Integer.parseInt(cutofMark);

		// entering Maxmark
		m.getMaxMarkTxtboxBtn().sendKeys("9");

		Thread.sleep(2000);

		// fetching maxmark value from maxmark textbox
		String maxMark = m.getMaxMarkTxtboxBtn().getAttribute("value");

		// changing the maxmark value datatype from string to Integer
		int maximumMark = Integer.parseInt(maxMark);

		String forDealer = "yes";
		String forBranch = "yes";
		String forDealerBranch = "yes";

		if (forDealer.equals("no")) {

			m.getConsiderDealerchkbox().click();

		} else if (forBranch.equals("no")) {

			m.getConsiderBranchchkbox().click();

		} else if (forDealerBranch.equals("yes")) {

			m.getConsiderDealerchkbox().click();

			boolean dealerselected = m.getConsiderDealerchkbox().isSelected();

			System.out.println(dealerselected);

			m.getConsiderBranchchkbox().click();

			boolean branchselected = m.getConsiderBranchchkbox().isSelected();

			System.out.println(branchselected);

		}

		Thread.sleep(2000);

		// clicking on branch checkbox

		Thread.sleep(2000);

		// clicking on save button
		m.getCategorySaveBtn().click();

		Thread.sleep(500);

		try {

			if (m.getSuccessToaster().isDisplayed()) {

				System.out.println("came_2");

				driver.findElement(By.xpath("//a[@class='paginate_button last']")).click();

				Thread.sleep(2000);

				if ((!categoryName.isEmpty()) && (!cutofMark.isEmpty()) && (!maxMark.isEmpty())

						&& ((m.getConsiderDealerchkbox().isSelected()) || (m.getConsiderBranchchkbox().isSelected()))) {

					System.out.println(m.getSuccessToaster().getText());

				} else {

					System.out.println("category created but some mandtory fields are missed");

				}

			}

		} catch (Exception e) {

			try {

				WebElement dealerBranchValidation = driver
						.findElement(By.xpath("//div[text()='Please Consider for Dealer/Branch']"));

				if (dealerBranchValidation.isDisplayed()) {

					if (!m.getConsiderDealerchkbox().isSelected() && !m.getConsiderBranchchkbox().isSelected()) {

						System.out.println(dealerBranchValidation.getText());

					}

				}

			} catch (Exception e2) {

				WebElement markValidation = driver
						.findElement(By.xpath("//div[contains(text(),'greater than Cutt Off')]"));

				// varifying cutoff validation msg is displayed or not
				if (markValidation.isDisplayed()) {

					if (maximumMark <= cutOffMark) {

						System.out.println(markValidation.getText());

					}

				}

			}
		}

	}

	@Test(priority = 3, enabled = true)
	private void subCategory() throws InterruptedException {

		m = new MasterPojo(driver);

		m.getMastertitle().click();

		Thread.sleep(2000);

		// clicking the Category lable/header from master
		m.getCategoryTitle().click();

		Thread.sleep(2000);

		String subCategory = "yes";

		if (subCategory.equals("yes")) {

			m.getSearchTxtbox().sendKeys("Check_category");

			Thread.sleep(2000);

			String subcategoryVal = m.getSearchTxtbox().getAttribute("value");

			m.getSubCategoryBtn().click();

			Thread.sleep(2000);

			String subCategoryCreate = "yes";
			String subCategoryDelete = "yes";

			if (subCategoryCreate.equals("yes")) {

				int subCategoryCount = 5;

				for (int i = 1; i <= subCategoryCount; i++) {

					m.getAddSubCategoryBtn().click();

				}

				Thread.sleep(2000);

				for (int j = 0; j < subCategoryCount; j++) {

					m.getSubCategoryTxtbox().get(j).sendKeys("Test" + j);

				}

				m.getSubSaveBtn().click();

				WebElement subcategoryTstrMsg = driver.findElement(By.xpath("//div[text()='Successfully Added']"));

				System.out.println(subcategoryTstrMsg);

			} else if (subCategoryDelete.equalsIgnoreCase("yes")) {

				m.getSubSearchTxtbx().sendKeys("Test1");

				Thread.sleep(2000);

				m.getSubDeleteBtn().click();

				Thread.sleep(2000);

				m.getSubPopupDeleteBtn().click();

				Thread.sleep(1000);

				System.out.println(m.getDeleteToasterMsg().getText());

			}

		}

	}

}
