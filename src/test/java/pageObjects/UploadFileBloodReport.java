package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.AbstractComponents;
import driverFactory.BaseClass;
import utilities.ConfigReader;

public class UploadFileBloodReport {

	public static WebDriver driver = BaseClass.getdriver();
	AbstractComponents ac = new AbstractComponents(driver);
	String SFurl = ConfigReader.getApplicationUrl();
	String username = ConfigReader.getUsername();
	String password = ConfigReader.getPassword();
	String filePath=ConfigReader.getFilePath();
	JavascriptExecutor executor = (JavascriptExecutor) driver;

	// Locators

	@FindBy(xpath = "//a[@title='Patients']")
	private static WebElement patient_object;
	@FindBy(xpath = "//a[@id='relatedListsTab__item']")
	private static WebElement RelatedTab;
	@FindBy(xpath = "(//input[@type='file'])[1]")
	private static WebElement upload_btn;
    @FindBy(xpath ="//button[@class='slds-button slds-button--neutral ok desktop uiButton--default uiButton--brand uiButton']")
	private static WebElement doneBtn;
	@FindBy(xpath="//span[@class='toastMessage slds-text-heading--small forceActionsText']")
	private static WebElement uploadAlert;
	@FindBy(xpath="//button[@title='Select a List View: Patients']")
	private static WebElement listView;
	@FindBy(xpath="//span[normalize-space()='Existing Patients List View']")
	private static WebElement existingPatientList;
	@FindBy(xpath="//thead/tr/th[3]/div/span")
	private static WebElement sortToggle;
	@FindBy(xpath="//tbody/tr[1]/th[1]/span[1]/a[1]")
	private static WebElement lastElement;
	
	
	
	// Constructor

	public UploadFileBloodReport() {

		PageFactory.initElements(driver, this);
	}


	public void patientObject_select() {
		
		executor.executeScript("arguments[0].click();", patient_object);

	}
//
//	public void selectListView() {
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();",listView );
//	}
//
//	public void selectExistPatientView() {
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();",existingPatientList );
//	}
//	
//	public void SortDesc()
//	{
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();",sortToggle );
//	}
	public void selectPatientId() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", lastElement);
	}
	
	
	public void ClickRelatedTab() {
		ac.waitForElementToappear(RelatedTab);
		ac.actionClassMoveTo(RelatedTab);
	}

	public void enterFilePath() {
		upload_btn.sendKeys(filePath);
		ac.waitForElementToappear(doneBtn);
		
		driver.findElement(By.xpath("(//span[@class=' label bBody'])[3] ")).click();
	}


	
	public String uploadAlertText() throws InterruptedException
	{
		
		ac.waitForElementToappear(uploadAlert);
	
		return uploadAlert.getText();
		
	}
	
}
