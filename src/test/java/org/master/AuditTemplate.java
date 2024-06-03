package org.master;

import java.io.IOException;
import java.util.List;

import org.POM.AuditTemplatePojo;
import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AuditTemplate extends BaseClass {

	public AuditTemplatePojo a;

	@Test
	private void createTemplate() throws InterruptedException, IOException {

		a = new AuditTemplatePojo(driver);

		login("balcvcybage1@bajajauto.co.in", "Dell@e5400");

		Thread.sleep(3000);

		Category.MasterSection();

		WebElement auditTemplate = driver.findElement(By.xpath("//a[text()='Audit Template']"));
		auditTemplate.click();

		Thread.sleep(5000);

		String createTemplate = "no";

		if (createTemplate.equalsIgnoreCase("Yes")) {

			WebElement addAuditTemplate = driver.findElement(By.xpath("//button[text()='Add Audit Template']"));
			addAuditTemplate.click();

			Thread.sleep(3000);

			WebElement templateNameTxtbox = driver.findElement(By.xpath("//input[@id='audit-name-new']"));

			scrollDown(templateNameTxtbox);

			Thread.sleep(2000);

			templateNameTxtbox.sendKeys("Automation_001");

			Thread.sleep(2000);

			WebElement auditType = driver.findElement(By.xpath("//select[@id='ddl-audit-type-new']"));
			Select s = new Select(auditType);
			s.selectByVisibleText("MD Workshop - Dlr");

			Thread.sleep(2000);

			WebElement saveBtn = driver.findElement(By.xpath("//input[@id='save-btn']"));
			saveBtn.click();

			WebElement toasterMsg = driver.findElement(By.xpath("//div[@class='toast-message']"));

			System.out.println(toasterMsg.getText());

			Thread.sleep(3000);

		}

		String createQuestion = "Yes";

		if (createQuestion.equalsIgnoreCase("Yes")) {

			WebElement lastpgNavgnt = driver.findElement(By.xpath("(//a[@class='page-link'])[4]"));
			lastpgNavgnt.click();

			Thread.sleep(2000);

			List<WebElement> editBtns = driver.findElements(By.xpath("//a[@title='Update']"));
			int lastEditBtn = editBtns.size() - 1;
			editBtns.get(lastEditBtn).click();

			List<WebElement> categoryList = driver.findElements(By.xpath("//div[@class='category-itemlist']"));

			for (int i = 0; i < categoryList.size(); i++) {

				WebElement categoriesName = categoryList.get(i);

				String categoryName = categoriesName.getText();

				String CategoryName = "Inter_1";

				if (CategoryName.equalsIgnoreCase(categoryName)) {

					categoriesName.click();

					WebElement subCategoryTitle = driver.findElement(By.xpath("//span[text()='SUB CATEGORIES']"));

					scrollUp(subCategoryTitle);

					String subCategory = "Create";

					// List<WebElement> subCategories = a.getSubCategories();

					List<WebElement> subCategories = driver.findElements(
							By.xpath("//div[@class='audit-add-subcat-list-item']/..//div[@class='category-itemlist']"));

					for (int j = 0; j < subCategories.size(); j++) {

						String eachCategoryName = subCategories.get(j).getText();

						System.out.println("1" + eachCategoryName);

						String a[] = new String[5];
						a[0] = "Sub_2";
						a[1] = "Sub_1";
						a[2] = "Sub_3";

						if (a[j].equalsIgnoreCase(eachCategoryName)) {

							subCategories.get(j).click();

							String questionCreation = "Yes";

							if (questionCreation.equalsIgnoreCase("Yes")) {

								WebElement qstnTxtbx = driver.findElement(By.xpath("//input[@id='question-text']"));
								qstnTxtbx.sendKeys(subCategories.get(j).getText() + " Is Question_1?");

								Thread.sleep(2000);

								WebElement optnType = driver.findElement(By.xpath("//select[@id='option-type']"));
								Select s = new Select(optnType);
								s.selectByVisibleText("Yes/No");

								Thread.sleep(2000);

								WebElement isCriticalNew = driver
										.findElement(By.xpath("(//label[@class='chk-box-label'])[2]"));

								JavascriptExecutor js = (JavascriptExecutor) driver;
								js.executeScript("arguments[0].click()", isCriticalNew);

								Thread.sleep(2000);

								WebElement yesScoreTxtbx = driver.findElement(By.xpath("(//input[@type='number'])[1]"));
								yesScoreTxtbx.sendKeys("10");

								Thread.sleep(2000);

								WebElement requirementTxtbx = driver
										.findElement(By.xpath("//input[@id='requirement-text']"));

								requirementTxtbx.sendKeys("Automation_Requirement");

								Thread.sleep(2000);

								WebElement scoringGuidelineTxtbx = driver
										.findElement(By.xpath("//input[@id='scoring-guideline']"));

								scoringGuidelineTxtbx.sendKeys("Automation_ScroingGuideline");

								WebElement addQuestionBtn = driver.findElement(By.xpath("//button[@type='submit']"));
								addQuestionBtn.click();

								WebElement cancelQtnTab = driver
										.findElement(By.xpath("//li[@onClick='CancelQuestions()']"));
								cancelQtnTab.click();

								Thread.sleep(3000);
								// (//input[@id='option-text2'])[1]

								// button[@onClick='AddOption()']

							}

						}

					}

				}

			}

		}

	}

}
