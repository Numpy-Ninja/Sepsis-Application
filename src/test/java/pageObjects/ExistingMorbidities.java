package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.AbstractComponents;
import driverFactory.BaseClass;
import utilities.ConfigReader;

public class ExistingMorbidities {
	public static WebDriver driver = BaseClass.getdriver();
	AbstractComponents ac = new AbstractComponents(driver);
	String SFurl = ConfigReader.getApplicationUrl();
	String username = ConfigReader.getUsername();
	String password = ConfigReader.getPassword();
	JavascriptExecutor executor = (JavascriptExecutor) driver;

	// Locators

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

	// Existing Morbidity

	@FindBy(xpath = "(//span[@title='High Cholesterol'])[1]")
	private static WebElement ExistingMorbidity;
	@FindBy(xpath = "(//*[name()='path' and contains(@d,'M14 43.7V8')])[1]")
	private static WebElement EmRightArrow;
	@FindBy(xpath = "//button[@title='Undo Existing Morbidities']")
	private static WebElement ExistMorbidityUndo;
	// @FindBy (xpath="(//span[contains(text(),'An option must be selected')]")
	@FindBy(xpath = "(//span[@class='slds-has-error slds-form-element__help'])[1]")
	private static WebElement ErrorMsg;
	@FindBy(xpath = "(//div[@class='slds-dueling-list__options']//li[11]//span[@title='Other'])[1]")
	private static WebElement ExistMorbidityOther;
	@FindBy(xpath = "//input[@name='Comment_Here__c']")
	private static WebElement otherTextBox;
	@FindBy(xpath = "//h3/span[@title='Existing Morbidities']")
	private static WebElement EmTitle;
	
	

	// Existing Infections

	@FindBy(xpath = "//div[@class='slds-dueling-list__options']//li[8]//span[@title='Others']")
	private static WebElement ExistInfectionOther;
	@FindBy(xpath = "(//*[name()='path' and contains(@d,'M14 43.7V8')])[2]")
	private static WebElement EinfRightArrow;
	@FindBy(xpath = "//input[@name='Other_Existing_Infections__c']")
	private static WebElement EinfotherTextBox;

	// Habits

	@FindBy(xpath = "//span[@title='Alcohol']")
	private static WebElement HabitOption;
	@FindBy(xpath = "//span[@title='Drugs']")
	private static WebElement HabitOption1;
	@FindBy(xpath = "(//*[name()='path' and contains(@d,'M14 43.7V8')])[4]")
	private static WebElement HbtRightArrow;

	// Allergy

	@FindBy(xpath = "//input[@type='checkbox' and @name='Allergies__c']")
	private static WebElement AllergyChkbx;
	@FindBy(xpath = "//input[@class='slds-input' and @name='Allergy_Type__c']")
	private static WebElement AllergyTxtbx;

	// Fintness Frequency

	@FindBy(xpath = "(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[14]")
	private static WebElement FitnessDropdown;
	@FindBy(xpath = "//div/lightning-base-combobox-item[2]//span[2]/span[@title='3 to 5 days a week']" )
	private static WebElement option;

	// Surgeries
	@FindBy(xpath = "//input[@name='Surgeries_with_in_6_months__c']")
	private static WebElement surgeryCkBX;
	@FindBy(xpath = "//input[@name='how_to_make_a_text_box_visble_if_a_check__c']")
	private static WebElement surgeryTxtbx;

	// Internation Travel

	@FindBy(xpath = "//input[@name='International_travel_in_last_3_months__c']")
	private static WebElement IntTravelChkbx;
	@FindBy(xpath = "//input[@name='Enter_country_Name__c']")
	private static WebElement IntTravelTxtbx;

	// Immunization

	@FindBy(xpath = "(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[13]")
	private static WebElement ImmunizationDropdown;
	@FindBy(xpath ="//div/lightning-base-combobox-item[2]//span[2]/span[@title='Up to date']")
	private static WebElement ImmunizationOption;

	// Physical Fitness

	@FindBy(xpath = "//div[@class='slds-dueling-list__options']//li//span[@title='Yoga']")
	private static WebElement PhysicalFitnessOption;
	@FindBy(xpath = "(//*[name()='path' and contains(@d,'M14 43.7V8')])[5]")
	private static WebElement PFRightArrow;
	@FindBy(xpath = "(//*[name()='path' and contains(@d,'M38 8.3v35')])[5]")
	private static WebElement PFleftArrow;

	// Family History
	@FindBy(xpath = "(//div/ul/li[1]/div/span/span)[3]")
	private static WebElement FamHistoryOption;
	@FindBy(xpath = "(//button[@title='Move selection to Chosen'])[3]")
	private static WebElement FamHisRightArrow;
	@FindBy(xpath = "(//div[@class='slds-dueling-list__options']//li//span[@title='Diabetes'])[2]")
	private static WebElement FamHistoryOption1;
	@FindBy(xpath = "(//div[@class='slds-dueling-list__options']//li//span[@title='Thyroid'])[2]")
	private static WebElement FamHistoryOption2;
	@FindBy(xpath = "(//button[@title='Move selection to Available'])[3]")
	private static WebElement FamHisLfttArrow;

	// Constructor

	public ExistingMorbidities() {

		PageFactory.initElements(driver, this);
	}

	public void SalesForcelogin_page() {

		driver.get(SFurl);

	}

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
//public void next_btn()
//{
//	JavascriptExecutor executor = (JavascriptExecutor)driver;
//  executor.executeScript("arguments[0].click();",next_btn );
//
//}

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

	public void Name_Status(String status) {
		if (status == "fail") {
			System.out.println("Please enter alphabets");
		} else {
			System.out.println("success");
		}
	}

	public void selectExistingMorbidity() {
		String javascript = "arguments[0].scrollIntoView()";
		executor.executeScript(javascript, ExistingMorbidity);
		ExistingMorbidity.click();
	}

	public void ClickonRightarrow() {
		
		executor.executeScript("arguments[0].scrollIntoView()", EmRightArrow);
		ac.actionClassMoveTo(EmRightArrow);
		//EmRightArrow.click();
	}

	public String getText() {
		return ExistingMorbidity.getText();
	}

	public void ClickOnUndo() {
		executor.executeScript("arguments[0].click();", ExistMorbidityUndo);
	}

	public String validateErrormsg() {
		String errorMsg = ErrorMsg.getText();
		return errorMsg;
	}

	public void ValidateExistMorbidityOther() {
		//ac.actionClassMoveTo(ExistMorbidityOther);
		executor.executeScript("arguments[0].scrollIntoView()", EmTitle);

		executor.executeScript("arguments[0].scrollIntoView()", ExistMorbidityOther);
		ExistMorbidityOther.click();

	}

	public void validateOtherTextbox(String morbidity) {
		otherTextBox.sendKeys(morbidity);
	}

//Existing Infections

	public void ValidateExistInfOther() {

		executor.executeScript("arguments[0].click();", ExistInfectionOther);
	}

	public void clickRightarrow() {

		ac.actionClassMoveTo(EinfRightArrow);
	}

	public void validateOtherTextboxExInf(String infection) {

		EinfotherTextBox.sendKeys(infection);
	}

//Habits

	public void selectHabit() {
		String javascript = "arguments[0].scrollIntoView()";
		executor.executeScript(javascript, HabitOption);
		HabitOption.click();
	}

	public void selectHabitopt() {
		String javascript = "arguments[0].scrollIntoView()";
		executor.executeScript(javascript, HabitOption1);
		HabitOption1.click();
	}

	public void ClickonHbtRightarrow() {

		ac.actionClassMoveTo(HbtRightArrow);
	}

	public String HbtgetText() {
		return HabitOption.getText();

	}

	public String Hbt1getText() {
		return HabitOption1.getText();

	}
//Physical Fitness

	public void selectPFOption()
	{
		String javascript = "arguments[0].scrollIntoView()";
		executor.executeScript(javascript, HabitOption);
	
		ac.actionClassMoveTo(PhysicalFitnessOption);
	}

	public void clickRightArrow() {
		ac.actionClassMoveTo(PFRightArrow);
	}

	
public String fitnessOptgetText() {
		
		return PhysicalFitnessOption.getText();
	}
	

	// Family History

	public void SelMultipleOptions() {
		ac.actionClassShiftHold();
		ac.actionClassMoveTo(FamHistoryOption1);
		ac.actionClassMoveTo(FamHistoryOption2);
		ac.actionClassMoveTo(FamHisRightArrow);
	}

	public void ClkFamHisRightArrow() {
		ac.actionClassMoveTo(FamHisRightArrow);
	}

	public String FamHistoryOption1GetTxt() {
		System.out.println( FamHistoryOption1.getText());
		
		return FamHistoryOption1.getText();
	}

	public String FamHistoryOption2GetTxt() {
		return FamHistoryOption2.getText();

	}

	public void ValidateFamHisLarrowbtn() {
		ac.actionClassMoveTo(FamHistoryOption1);
	}

	public void ClkFHLftArrow() {
		ac.actionClassMoveTo(FamHisLfttArrow);
	}

	// Allergy

	public void clickAllergyBx() {

		String javascript = "arguments[0].scrollIntoView()";
		executor.executeScript(javascript, AllergyChkbx);
		executor.executeScript("arguments[0].click();", AllergyChkbx);
	}

	public void sendTextBx(String allergy) {

		ac.actionClass(AllergyTxtbx, allergy);

	}

	// Fitness Frequency

	public void ClickFitnessDropdown() {
		executor.executeScript("arguments[0].click();", FitnessDropdown);

	}

	public void FitnessDropdownOption() {
		//executor.executeScript("arguments[0].click();", option);
		ac.actionClassMoveTo(option);

	}
	// Surgeries

	public void clickSurgeryCkbx() {
		ac.actionClassMoveTo(surgeryCkBX);
	}

	public void SendTxtSurgeryTxtbx(String surgery) {

		ac.actionClass(surgeryTxtbx, surgery);
	}

	// International travel

	public void clickIntTravelChkbx() {
		executor.executeScript("arguments[0].click();", IntTravelChkbx);

	}

	public void IntTravelTxtBx(String country) {
		ac.actionClass(IntTravelTxtbx, country);
	}
	// Immunization

	public void ClickImmunizationDropdown() {
		executor.executeScript("arguments[0].click();", ImmunizationDropdown);

	}

	public void ImmuneDropdownOption() {

		//executor.executeScript("arguments[0].click();", ImmunizationOption);
		ac.actionClassMoveTo(ImmunizationOption);

	}

	
}
