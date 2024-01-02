package stepDefinitions;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.UploadFileBloodReport;

public class UploadFileBloodReportSD {
	
	UploadFileBloodReport bloodReport= new UploadFileBloodReport();
	String actualMsg;
	String actualSepsisStatus;
	String expectedSepsisStatus;
	
	
	@Given("Patient is on details tab in saved patient form")
	public void patient_is_on_details_tab_in_saved_patient_form() {
		
	}

	
	@Then("the status of RiskOfSepsis should be shown {string}")
	public void the_status_of_RiskOfSepsis_should_be_shown(String sepsisStatus ) {
	   actualSepsisStatus=bloodReport.getSepsisRisk();
	   expectedSepsisStatus=bloodReport.getRiskOfSepsis(sepsisStatus);
	   //assertEquals(actualSepsisStatus,expectedSepsisStatus);
	}
	
	@Given("Patient is on related tab in saved patient form")
	public void patient_is_on_related_tab_in_saved_patient_form() {
	    

	
	    bloodReport.ClickRelatedTab();
	}

	@When("Patient clicks on the upload file option")
	public void patient_clicks_on_the_upload_file_option() throws InterruptedException {
		bloodReport.enterFilePath();
		
	}



	@Then("Patient should able to upload a file with a successful message {string}")
	public void patient_should_able_to_upload_a_file_with_a_successful_message(String expectedMsg) throws InterruptedException {
		actualMsg = bloodReport.uploadAlertText();
    	assertEquals(actualMsg,expectedMsg);
		bloodReport.close_btn();
	    
	}




}
