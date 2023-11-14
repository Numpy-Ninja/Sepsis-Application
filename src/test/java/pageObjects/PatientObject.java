package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.AbstractComponents;
import driverFactory.BaseClass;
import utilities.ConfigReader;

public class PatientObject {
	public static WebDriver driver = BaseClass.getdriver();
	AbstractComponents ac = new AbstractComponents(driver);
	String SFurl = ConfigReader.getApplicationUrl();
	String username = ConfigReader.getUsername();
	String password = ConfigReader.getPassword();
	JavascriptExecutor executor = (JavascriptExecutor) driver;

	boolean isRequired;

	// Locators

	@FindBy(id = "username")
	static WebElement user;
	@FindBy(id = "password")
	static WebElement pwd;
	@FindBy(id = "Login")
	WebElement login_button;
	@FindBy(xpath = "//div[@class='slds-icon-waffle']")
	WebElement waffle_btn;
	@FindBy(xpath = "//p[contains(.,'Sepsis')]")
	WebElement sepsisApp;
	@FindBy(xpath = "//a[@title='Patients']")
	WebElement patient_object;
	@FindBy(xpath = "//div[contains(text(),'New')]")
	WebElement new_btn;
	@FindBy(xpath = "//span[contains(.,'Next')]")
	WebElement next_btn;

	/// PersonalInfo/////
	@FindBy(xpath = "//input[@name='First_Name__c']")
	WebElement first_name;
	@FindBy(xpath = "//input[@name='Last_Name__c']")
	WebElement last_name;
	@FindBy(xpath = "//button[contains(@aria-label,'Gender')]")
	WebElement gender;
	@FindBy(xpath = "//div/lightning-base-combobox-item[3]//span[2]/span[@title='Female']")
	WebElement gender_dropdown;
	@FindBy(xpath = "//input[@name='DOB__c']")
	WebElement dateOfBirth;

	/// EmergencyContact/////
	@FindBy(xpath = "//input[@name='Full_Name__c']")
	WebElement full_name;
	@FindBy(xpath = "//input[@name='Emergency_Contact_Number__c']")
	WebElement emergency_contactnum;
	@FindBy(xpath = "//button[contains(@aria-label,'Relationship')]")
	WebElement relationship_dropdown;
	@FindBy(xpath = "//div/lightning-base-combobox-item[2]//span[2]/span[@title='Relative']")
	WebElement relative_dropdown;

	/// ProviderInfo/////
	@FindBy(xpath = "//input[@name='Doctors_Name__c']")
	WebElement doctor_name;
	@FindBy(xpath = "//input[@name='Doctor_s_Contact_Number__c']")
	WebElement doctor_contactnumber;
	@FindBy(xpath = "//input[@name='Clinic_Name__c']")
	WebElement clinic_name;
	@FindBy(xpath = "//input[@name='Doctor_Email__c']")
	WebElement doctor_email;

	/// MedicalHistory////
	@FindBy(xpath = "//button[contains(@aria-label,'Height')]")
	WebElement height;
	@FindBy(xpath = "//div/lightning-base-combobox-item[3]//span[2]/span[@title='Centimeters']")
	WebElement height_dropdown;
	@FindBy(xpath = "//input[@name='Height_In_Centimeters__c']")
	WebElement heightIn_cm;
	@FindBy(xpath = "//button[contains(@aria-label,'Weight')]")
	WebElement weight;
	@FindBy(xpath = "//div/lightning-base-combobox-item[2]//span[2]/span[@title='Kilograms']")
	WebElement weight_dropdown;
	@FindBy(xpath = "//input[@name='Weight__c']")
	WebElement weightIn_Kg;

	// Constructor

	public PatientObject() {

		PageFactory.initElements(driver, this);
	}

	public void SalesForcelogin_page() {

		driver.get(SFurl);

	}

	public void Login(String username, String password) {

		user.clear();
		user.sendKeys(username);
		pwd.clear();
		pwd.sendKeys(password);
		login_button.click();
		waffle_btn.click();
		sepsisApp.click();
		executor.executeScript("arguments[0].click();", patient_object);
		new_btn.click();

	}

	public void Name_Status(String status) {
		if (status == "fail") {
			System.out.println("Please enter alphabets");
		} else {
			System.out.println("success");
		}
	}

	public void newPatientForm(String username, String password) {
		user.clear();
		user.sendKeys(username);
		pwd.clear();
		pwd.sendKeys(password);
		login_button.click();
		waffle_btn.click();
		sepsisApp.click();

	}

	public void personalInfo(String firstName, String lastName) {
		executor.executeScript("arguments[0].scrollIntoView();", first_name);
		first_name.click();
		ac.actionClass(first_name, firstName);
		// first_name.sendKeys(firstName);
		last_name.click();
		last_name.sendKeys(lastName);
		gender.click();
		gender_dropdown.click();
		dateOfBirth.click();
		dateOfBirth.sendKeys("11/1/2023");
	}

	public String checkFirstNameEntered() {
		return first_name.getAttribute("value");
	}

	public String checkLastNameEntered() {
		return last_name.getAttribute("value");
	}

	public String checkDOBSelected() {
		return dateOfBirth.getAttribute("value");
	}

	public void emergencyInfo(String fullName, String emergencyContactNumber) {

		executor.executeScript("arguments[0].scrollIntoView();", full_name);
		full_name.click();
		full_name.sendKeys(fullName);
		emergency_contactnum.click();
		emergency_contactnum.sendKeys(emergencyContactNumber);

	}

	public void relationshipDropDown() {
		relationship_dropdown.click();
		relative_dropdown.click();

	}

	public String checkFullNameEntered() {
		return full_name.getAttribute("value");
	}

	public String checkContactNumberEntered() {
		return emergency_contactnum.getAttribute("value");
	}

	public void providerInformation(String doctorName, String doctorContactNumber, String clinicName,
			String doctorEmail) {

		doctor_name.click();
		doctor_name.sendKeys(doctorName);
		doctor_contactnumber.click();
		doctor_contactnumber.sendKeys(doctorContactNumber);
		clinic_name.click();
		clinic_name.sendKeys(clinicName);
		doctor_email.click();
		doctor_email.sendKeys(doctorEmail);
	}

	public String checkDoctorNameEntered() {
		return doctor_name.getAttribute("value");
	}

	public String checkDoctorContactNumberEntered() {
		return doctor_contactnumber.getAttribute("value");
	}

	public String checkClinicNameEntered() {
		return clinic_name.getAttribute("value");
	}

	public String checkDoctorEmailEntered() {
		return doctor_email.getAttribute("value");
	}

	public void medicalHistory(String heightInCm, String weightInKgs) {

		height.click();
		height_dropdown.click();
		heightIn_cm.sendKeys(heightInCm);
		weight.click();
		weight_dropdown.click();
		weightIn_Kg.sendKeys(weightInKgs);
	}

	public String checkHeightEntered() {
		return heightIn_cm.getAttribute("value");
	}

	public String checkWeightEntered() {
		return weightIn_Kg.getAttribute("value");
	}
}
