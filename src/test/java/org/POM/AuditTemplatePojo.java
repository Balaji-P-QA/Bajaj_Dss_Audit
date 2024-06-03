package org.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuditTemplatePojo {

	WebDriver driver;

	public AuditTemplatePojo(WebDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @return the subCategories
	 */
	public List<WebElement> getSubCategories() {
		return subCategories;
	}

	@FindBy(xpath = "//div[@class='audit-add-subcat-list-item']/..//div[@class='category-itemlist']")
	private List<WebElement> subCategories;

}
