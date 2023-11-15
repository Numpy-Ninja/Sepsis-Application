package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.BaseClass;
import driverFactory.AbstractComponents;
import utilities.ConfigReader;

public class Vitals{
	public static WebDriver driver = BaseClass.getdriver();
	AbstractComponents ac = new AbstractComponents(driver);
	String SFurl = ConfigReader.getApplicationUrl();
	String username = ConfigReader.getUsername();
	String password = ConfigReader.getPassword();
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	
	
	//Locators - Login
	@FindBy(id = "username")
	private static WebElement user;
	@FindBy(id = "password")
	private static WebElement pwd;
	@FindBy(id = "Login")
	private static WebElement login_button;
	@FindBy(xpath = "//div[@class='slds-icon-waffle']")
	private static WebElement waffle_btn;
	@FindBy(xpath = "//p[contains(.,'Sepsis')]")
	private static WebElement sepsisApp;
	@FindBy(xpath = "//a[@title='Patients']")
	private static WebElement patient_object;
	@FindBy(xpath = "//div[contains(text(),'New')]")
	private static WebElement new_btn;
	@FindBy(xpath = "//span[contains(.,'Next')]")
	private static WebElement next_btn;
	@FindBy(xpath = "//input[@name='First_Name__c']")
	private static WebElement first_name;
	@FindBy(xpath = "//input[@name='Last_Name__c']")
	private static WebElement last_name;

	
	//Locators Medication
	@FindBy (xpath= "//input[@name='Current_Medication__c']")
	private static WebElement CurrentMedication;
	
	//Locators - Vitals
	//@FindBy(className= "slds-truncate") WebElement Vitals;
	@FindBy(xpath = "//input[@name='Temperature__c']") 
	private static WebElement Temperature;
	@FindBy(xpath = "//input[@name='Heart_Rate__c']") 
	private static WebElement HeartRate;
	@FindBy (xpath = "//input[@name='Respiratory_Rate__c']") 
	private static WebElement RespiratoryRate;
	@FindBy (xpath = "//input[@name='BP__c']") 
	private static WebElement BP;
	@FindBy (xpath = "(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[15]") 
	private static WebElement GlucoseDropdown;
	@FindBy (xpath = "(//lightning-base-combobox[1]/div[1]/div[1]/div[1]/button[1])[13]") 
	private static WebElement GlucoseOption;
	@FindBy (xpath = "//input[@name='Glucose_Value__c']") 
	private static WebElement GlucoseValue;
	@FindBy (xpath = "//input[@name='White_Blood_Cells_Leukocyte__c']") 
	private static WebElement WBCcount;
	
	
	//Constructor
	
			public Vitals() {
		        
				PageFactory.initElements(driver, this);
			}

			public void SalesForcelogin_page() {

				driver.get(SFurl);

			}
			
	//Login Methods
			
			public void Login(String username, String password) {
				ac.waitForElementToappear(user);
				user.clear();
				user.sendKeys(username);
				ac.waitForElementToappear(pwd);
				pwd.clear();
				pwd.sendKeys(password);
			}
			
			public void login_button() {
				login_button.click();
			}
			
			public void waffle_click() {
				ac.waitForElementToappear(waffle_btn);
				waffle_btn.click();
			}
			
			public void sepsisApp_click() {
				// waitForElementToappear(sepsisApp);
				sepsisApp.click();
			}
			
			public void patientObject_select() {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", patient_object);
			}
			
			public void selectNew() {
				ac.waitForElementToappear(new_btn);
				new_btn.click();
			}
			
			public void enterFirstName(String First_Name) {
				ac.waitForElementToappear(first_name);
				first_name.clear();
				first_name.sendKeys(First_Name);
			}
			public void enterLastName(String Last_Name) {
				ac.waitForElementToappear(last_name);
				last_name.clear();
				last_name.sendKeys(Last_Name);
			}
			
			
			
			//Medication Methods
			
			public void MedicationClick() {
				String javascript = "arguments[0].scrollIntoView()";
				executor.executeScript(javascript, CurrentMedication);
				CurrentMedication.click();
			}
			
			public void medicatiovalue(String mdvalue) {
				CurrentMedication.sendKeys(mdvalue);
			}
			
			
	//Vitals Methods
			
			public void VitalsTempClick() {
				Temperature.click();
			}
			
			
			public void VitalsTemp(String temperature2) {
				Temperature.sendKeys(temperature2);
			}
			
			public void VitalsHeartRate(String heartrate) {
			
				HeartRate.sendKeys(heartrate);
			}
			
			public void VitalsRespiratoryRate(String respiratoryrate) {
				RespiratoryRate.sendKeys(respiratoryrate);
			}
	 
			public void VitalsBP(String bp) {
				BP.sendKeys(bp);
			}
			
			public void VitalsGlucoseDropdown() {
				
				GlucoseDropdown.click();
			}
			
			public void VitalsGlucoseOption() {
				
				GlucoseOption.click();
			}
			
			public void VitalsGlucoseValue(String gv) {
				
				GlucoseValue.sendKeys(gv);
			}
			
			
			public void VitalsWBCcount(String wbc) {
				WBCcount.sendKeys(wbc);
			}

			public void HearrateClick() {
				HeartRate.click();
				
			}

			public void respiratoryclick() {
				RespiratoryRate.click();
				
			}

			public void VitalsBPClick() {
				// TODO Auto-generated method stub
				BP.click();
				
			}

			public void VitalsGlucoseclick() {
				GlucoseValue.click();
				
			}

			public void wbcclick() {
				// TODO Auto-generated method stub
			//		WBCcount.click();
				ac.actionClassMoveTo(WBCcount);
			}
			
			
			
			

}
