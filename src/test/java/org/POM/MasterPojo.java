package org.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterPojo {

	public WebDriver driver;

	public MasterPojo(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()=' Master ']")
	private WebElement mastertitle;

	@FindBy(xpath = "//a[text()='Category']")
	private WebElement categoryTitle;

	@FindBy(xpath = "//button[text()='Add Category']")
	private WebElement addCategoryBtn;

	@FindBy(xpath = "//input[@class='default-textbox w-100 cat']")
	private WebElement categorynameTxtboxBtn;

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @return the mastertitle
	 */
	public WebElement getMastertitle() {
		return mastertitle;
	}

	/**
	 * @return the categoryTitle
	 */
	public WebElement getCategoryTitle() {
		return categoryTitle;
	}

	/**
	 * @return the addCategoryBtn
	 */
	public WebElement getAddCategoryBtn() {
		return addCategoryBtn;
	}

	/**
	 * @return the categorynameTxtboxBtn
	 */
	public WebElement getCategorynameTxtboxBtn() {
		return categorynameTxtboxBtn;
	}

	/**
	 * @return the cutofmarkTxtboxBtn
	 */
	public WebElement getCutofmarkTxtboxBtn() {
		return cutofmarkTxtboxBtn;
	}

	/**
	 * @return the maxMarkTxtboxBtn
	 */
	public WebElement getMaxMarkTxtboxBtn() {
		return maxMarkTxtboxBtn;
	}

	/**
	 * @return the considerDealerchkbox
	 */
	public WebElement getConsiderDealerchkbox() {
		return considerDealerchkbox;
	}

	/**
	 * @return the considerBranchchkbox
	 */
	public WebElement getConsiderBranchchkbox() {
		return considerBranchchkbox;
	}

	/**
	 * @return the categorySaveBtn
	 */
	public WebElement getCategorySaveBtn() {
		return categorySaveBtn;
	}

	/**
	 * @return the successToaster
	 */
	public WebElement getSuccessToaster() {
		return successToaster;
	}

	@FindBy(xpath = "//input[@class='default-textbox w-100 cat-cutoff']")
	private WebElement cutofmarkTxtboxBtn;

	@FindBy(xpath = "//input[@class='default-textbox w-100 cat-maxscore']")
	private WebElement maxMarkTxtboxBtn;

	@FindBy(xpath = "//input[@id='is-for-dealer-0']")
	private WebElement considerDealerchkbox;

	@FindBy(xpath = "//input[@id='is-for-branch-0']")
	private WebElement considerBranchchkbox;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement categorySaveBtn;

	/**
	 * @return the searchTxtbox
	 */
	public WebElement getSearchTxtbox() {
		return searchTxtbox;
	}

	/**
	 * @return the subCategoryBtn
	 */
	public WebElement getSubCategoryBtn() {
		return subCategoryBtn;
	}

	/**
	 * @return the addSubCategoryBtn
	 */
	public WebElement getAddSubCategoryBtn() {
		return addSubCategoryBtn;
	}

	/**
	 * @return the subCategoryTxtbox
	 */
	public List<WebElement> getSubCategoryTxtbox() {
		return subCategoryTxtbox;
	}

	/**
	 * @return the subSaveBtn
	 */
	public WebElement getSubSaveBtn() {
		return subSaveBtn;
	}

	@FindBy(xpath = "//div[text()='Successfully Added']")
	private WebElement successToaster;

	
	//sub
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchTxtbox;
	
	/**
	 * @return the subSearchTxtbx
	 */
	public WebElement getSubSearchTxtbx() {
		return subSearchTxtbx;
	}

	/**
	 * @return the subDeleteBtn
	 */
	public WebElement getSubDeleteBtn() {
		return subDeleteBtn;
	}

	@FindBy(xpath = "(//a[text()='SubCategory'])[1]")
	private WebElement subCategoryBtn;
	
	@FindBy(xpath = "//button[text()='Add SubCategory']")
	private WebElement addSubCategoryBtn;
	
	@FindBy(xpath = "//input[@class='default-textbox w-100 cat SubCategory']")
	private List<WebElement> subCategoryTxtbox;
	
	/**
	 * @return the subPopupDeleteBtn
	 */
	public WebElement getSubPopupDeleteBtn() {
		return subPopupDeleteBtn;
	}

	/**
	 * @return the deleteToasterMsg
	 */
	public WebElement getDeleteToasterMsg() {
		return deleteToasterMsg;
	}

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement subSaveBtn;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement subSearchTxtbx;
	
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement subDeleteBtn;
	
	@FindBy(xpath = "//button[@id='delete']")
	private WebElement subPopupDeleteBtn;
	
	@FindBy(xpath = "//div[text()='SubCategory Successfully Deleted']")
	private WebElement deleteToasterMsg;
	
	
}
