package stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SalesforceLoginSepsis;
import pageObjects.SepsisBloodProfile;
import pageObjects.Vitals;
import utilities.ConfigReader;

public class SepsisBloodProfileSD {
	
	SepsisBloodProfile sp = new SepsisBloodProfile();
	SalesforceLoginSepsis loginPatient = new SalesforceLoginSepsis();
	Vitals vt = new Vitals();
	
	// String username = ConfigReader.getUsername();
	// String password = ConfigReader.getPassword();

	// @Given("The patient is on Signin page of SalesForce application")
	// public void the_patient_is_on_signin_page_of_SalesForce_application() {

	// 	sp.SalesForcelogin_page();
	// }

	// @When("The patient enter Valid {string} and {string}")
	// public void the_patient_enter_Valid_and(String userName, String PassWord) {
	// 	sp.Login(username, password);

	// }

	// @And("The user click on Login button")
	// public void the_user_click_on_Login_button() throws InterruptedException {
	// 	sp.login_button();
		
	// 	sp.waffle_click();
	// 	sp.sepsisApp_click();
	
		
	// }
	// @Then("The user redirected to SalesforceHomepage")
	// public void the_user_redirected_to_sales_force_homepage() {

	// 	//loginPatient.patientObject_select();
		

	// }
	@Given("Admin is on Sepsis Blood Profile Object")
	public void admin_is_on_sepsis_blood_profile_object() {
		sp.SelectSepsisbloodProfileObject();
		
	   
	}

	@When("Admin Clicks on New Form")
	public void admin_clicks_on_new_form() {
		sp.clickOnNewForm();
	}

	@And("Admin enters the {string},{string},{string},{string},{string} ,{string},{string}, {string}, {string}")
	public void admin_enters_the(String patientId, String PaO2value, String systolicbloValue, String DiastlicbloValue, String HrValue, String Egfrvalue, String Troponinvalue, String PacO2value, String FiO2value) {
	   
		sp.enterPatientId(patientId);
		sp.enterPaO2(PaO2value);
		sp.enterSystolicblo(systolicbloValue);
		sp.enterDiastlicblo(DiastlicbloValue);
		sp.enterHr(HrValue);
		sp.enterEgfr(Egfrvalue);
		sp.enterTroponin(Troponinvalue);
		sp.enterPacO2(PacO2value);
		sp.enterFiO2(FiO2value);
	}

	@Then("Admin clicks on the save button the form should be saved")
	public void admin_clicks_on_the_save_button_the_form_should_be_saved() {
	   sp.clickOnSave();
		String actualAlertMsg = sp.sepsisgetalertMsg();//Sepsis Blood Profile "SBP-0075" was created
		String expectedAlertMsg =sp.getExpectedMsg();//
		assertEquals(actualAlertMsg, expectedAlertMsg);

	}

	@When("Admin opens the saved Form")
	public void admin_opens_the_saved_form() {
//		sp.SelectSepsisbloodProfileObject();
//		sp.clickSepsisId();
	    
	}
	
	@Then("Admin should be able to see the values for {string},{string},{string},{string} ,{string}, {string}")
	public void admin_should_be_able_to_see_the_values_for(String PfRatio, String cardiacOutput, String myocardialDepression, String eGFroutput, String fiO2_Saved, String PFoutputResult) 
		{
	   String actualPFratio = sp.checkPFRatio(PfRatio);
	   String expectedPFratio= PfRatio;
	   Assert.assertEquals(actualPFratio,expectedPFratio);
	   
	   String actualcardiacOutput = sp.checkCardiacOutput(cardiacOutput);
	   String expectedcardiacOutput= cardiacOutput;
	   Assert.assertEquals(actualcardiacOutput,expectedcardiacOutput);
	   
	   
	   String actualmyocardialDepression = sp.checkMyocardialDepression(myocardialDepression);
	   String expectedmyocardialDepression= myocardialDepression;
	   Assert.assertEquals(actualcardiacOutput,expectedcardiacOutput);
	   
	   
	   String actualeGFroutput = sp.checkeGFRoutput(eGFroutput);
	   String expectedeGFroutput= eGFroutput;
	   Assert.assertEquals(actualcardiacOutput,expectedcardiacOutput);
	   
	   String actualefiO2_Saved = sp.checkfiO2_saved(fiO2_Saved);
	   String expectedefiO2_Saved= fiO2_Saved;
	   Assert.assertEquals(actualefiO2_Saved,expectedefiO2_Saved);
	   
	   String actualPFoutputResult = sp.checkPFOutputResult(PFoutputResult);
	   String expectedPFoutputResult= PFoutputResult;
	   Assert.assertEquals(actualPFoutputResult,expectedPFoutputResult);
	   
	   
	   boolean HeartFailureChkbx=sp.HeartFailureChkBx();
	   Assert.assertTrue(HeartFailureChkbx);
	   
	   boolean kidneyFailureChkbx=sp.KidneyFailureChkBx();
	   Assert.assertTrue(kidneyFailureChkbx);
	   
	   boolean RespiratoryFailureChkbx=sp.RespiratoryFailureChkBx();
	   Assert.assertTrue(RespiratoryFailureChkbx);
	   
	}
		
		@Given("Admin is on Patient Object")
		public void admin_is_on_patient_object() {
			loginPatient.patientObject_select();
		    
		}
		@When("Admin opens the saved Patient Form")
		public void admin_opens_the_saved_Patient_form() {
         vt.selectListView();
         vt.selectExistPatientView();
         vt.SortDesc();
         sp.selectSepsisPatientId();
         
		    
		}
		
		
		@Then("Admin should be able to check the status of the Kidney failure, Heart failure , Respiratory failure")
		public void admin_should_be_able_to_check_the_status_of_the_kidney_failure_heart_failure_respiratory_failure() {
			  boolean PHeartFailureChkbx=sp.PHeartFailureChkBx();
			   Assert.assertTrue(PHeartFailureChkbx);
			   
			   boolean PkidneyFailureChkbx=sp.PKidneyFailureChkBx();
			   Assert.assertTrue(PkidneyFailureChkbx);
			   
			   boolean PRespiratoryFailureChkbx=sp.PKidneyFailureChkBx();
			   Assert.assertTrue(PRespiratoryFailureChkbx);
		}



	}

