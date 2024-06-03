package org.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Schedule {

	public WebDriver driver;

	public Schedule(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='Audit Plans Schedule']")
	private WebElement auditPlanscheduleLink;

	@FindBy(xpath = "//a[text()='Add ']")
	private WebElement addBtn;

	@FindBy(xpath = "//select[@id='dealer-type']")
	private WebElement entityTypeDropdowm;

	@FindBy(xpath = "//select[@id='dealer']")
	private WebElement entityDropdowm;

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @return the auditPlanscheduleLink
	 */
	public WebElement getAuditPlanscheduleLink() {
		return auditPlanscheduleLink;
	}

	/**
	 * @return the addBtn
	 */
	public WebElement getAddBtn() {
		return addBtn;
	}

	/**
	 * @return the entityTypeDropdowm
	 */
	public WebElement getEntityTypeDropdowm() {
		return entityTypeDropdowm;
	}

	/**
	 * @return the entityDropdowm
	 */
	public WebElement getEntityDropdowm() {
		return entityDropdowm;
	}

	/**
	 * @return the auditTemplateDropdowm
	 */
	public WebElement getAuditTemplateDropdowm() {
		return auditTemplateDropdowm;
	}

	/**
	 * @return the calendar
	 */
	public WebElement getCalendar() {
		return calendar;
	}

	/**
	 * @return the year
	 */
	public List<WebElement> getYear() {
		return year;
	}

	/**
	 * @return the calendarSlider
	 */
	public WebElement getCalendarSlider() {
		return calendarSlider;
	}

	/**
	 * @return the calendarApplyBtn
	 */
	public WebElement getCalendarApplyBtn() {
		return calendarApplyBtn;
	}

	/**
	 * @return the isNewChkbx
	 */
	public WebElement getIsNewChkbx() {
		return isNewChkbx;
	}

	/**
	 * @return the saveBtn
	 */
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	/**
	 * @return the date
	 */
	public List<WebElement> getDate() {
		return date;
	}

	/**
	 * @return the dates
	 */
	public List<WebElement> getDates() {
		return dates;
	}

	@FindBy(xpath = "//select[@id='audit-name']")
	private WebElement auditTemplateDropdowm;

	@FindBy(xpath = "//input[@id='fromtodate']")
	private WebElement calendar;

	@FindBy(xpath = "//th[@class='month']")
	private List<WebElement> year;

	@FindBy(xpath = "//td[@class='weekend available']")
	private List<WebElement> date;
	
	@FindBy(xpath = "//td[contains(@class,'available')]")
	private List<WebElement> dates;
	

	@FindBy(xpath = "//th[@class='next available']")
	private WebElement calendarSlider;

	@FindBy(xpath = "//button[text()='Apply']")
	private WebElement calendarApplyBtn;

	@FindBy(xpath = "//input[@value='isNew']")
	private WebElement isNewChkbx;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtn;

}
