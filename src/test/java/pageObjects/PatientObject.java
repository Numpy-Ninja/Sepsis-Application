package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DriverFactory.BaseClass;
import DriverFactory.abstractComponents;
import utilities.configReader;

public class PatientObject extends abstractComponents  {
	public  static WebDriver driver=BaseClass.getdriver();
	abstractComponents ac = new abstractComponents();
	String SFurl=configReader.getApplicationUrl();
	String username = configReader.getUsername();
	String password = configReader.getPassword();
	boolean isRequired;
	

	//Locators
	

		@FindBy (id="username")static WebElement user;
		@FindBy (id="password")static WebElement pwd;
		@FindBy (id="Login")WebElement login_button;
		@FindBy (xpath="//div[@class='slds-icon-waffle']")WebElement waffle_btn;
		@FindBy (xpath="//p[contains(.,'Sepsis')]")WebElement sepsisApp;
		@FindBy (xpath="//a[@title='Patients']")WebElement patient_object;
		@FindBy (xpath="//div[contains(text(),'New')]")WebElement new_btn;
		@FindBy (xpath="//span[contains(.,'Next')]")WebElement next_btn ;
		@FindBy (xpath="//input[@name='First_Name__c']")static WebElement first_name;
		@FindBy (xpath="//input[@name='Last_Name__c']")static WebElement last_name;
		
		//Constructor
		
		
		public PatientObject() {
	        
			
			PageFactory.initElements(driver, this);
		}

		public void SalesForcelogin_page() {

			driver.get(SFurl);

		}
		
		public void Login(String username,String password) {
	   
			//waitForElementToappear(user);
			
			user.clear();
			
			user.sendKeys(username);
			//waitForElementToappear(pwd);
			pwd.clear();
			pwd.sendKeys(password);

		
		}
		
		public void login_button() {

			login_button.click();
			
		}		
		public void waffle_click()
			{
			
			//waitForElementToappear(waffle_btn);
			waffle_btn.click();
			}


		public void sepsisApp_click()
		{
			//waitForElementToappear(sepsisApp);
			sepsisApp.click();
		}
public void patientObject_select()
{
	 JavascriptExecutor executor = (JavascriptExecutor)driver;
     executor.executeScript("arguments[0].click();",patient_object );
     
}
public void selectNew()
{
	//waitForElementToappear(new_btn);
	new_btn.click();
}
//public void next_btn()
//{
//	JavascriptExecutor executor = (JavascriptExecutor)driver;
//    executor.executeScript("arguments[0].click();",next_btn );
//
//}

	

public void enterFirstName(String First_Name)
{
	//waitForElementToappear(first_name);
	first_name.clear();
	
	first_name.sendKeys(First_Name);
	
}
public void enterLastName(String Last_Name)
{
	//waitForElementToappear(last_name);
	last_name.clear();
	
	last_name.sendKeys(Last_Name);
	
}


public void Name_Status(String status)
{
	if( status=="fail") {
	System.out.println("Please enter alphabets");
	}
	else
	{
		System.out.println("success");	
	}
}

}
