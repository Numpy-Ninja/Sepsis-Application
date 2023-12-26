package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import pageObjects.data.PatientData;

public class PatientDataReader {

	public static final String EXCEL = "target/test-classes/dataFiles/SepsisPatientData.xlsx";

	public PatientData getData(String SheetName, int Rownumber) throws InvalidFormatException, IOException {
		System.out.println(new File(".").getAbsolutePath());
		ExcelReader excelReader = new ExcelReader();
		Map<String, String> data = excelReader.getData(EXCEL, SheetName).get(Rownumber);
		String FirstName = data.get("FirstName");
		String LastName = data.get("LastName");
		String Gender = data.get("Gender");
		String DOB = data.get("DOB");
		String PhoneNumber = data.get("PhoneNumber");
		String Email = data.get("Email");
		String EmergencycontactNumber = data.get("EmergencyContactNumber");
		String DoctorEmail = data.get("DoctorEmail");
		String OtherExistingMorbidities = data.get("OtherExistingMorbidities");
		String FitnessFrequency = data.get("FitnessFrequency");
		String Immunization = data.get("Immunization");
		String CurrentMedication = data.get("CurrentMedication");
		String Temperature = data.get("Temperature");
		String HeartRate = data.get("HeartRate");
		String RespiratoryRate = data.get("RespiratoryRate");
		String BP = data.get("BP");
		String Glucose = data.get("Glucose");
		String GlucoseValue = data.get("GlucoseValue");
		String WhiteBloodCells = data.get("WhiteBloodCells");
		PatientData patientData = PatientData.builder().firstName(FirstName).lastName(LastName).gender(Gender).dob(DOB)
				.phoneNumber(PhoneNumber).email(Email).emergencyContactNumber(EmergencycontactNumber).doctorEmail(DoctorEmail)
				.otherExistingMorbidities(OtherExistingMorbidities).fitnessFrequency(FitnessFrequency)
				.immunization(Immunization).currentMedication(CurrentMedication).temperature(Temperature)
				.heartRate(HeartRate).respiratoryRate(RespiratoryRate).bp(BP).glucose(Glucose).glucoseValue(GlucoseValue)
				.whiteBloodCells(WhiteBloodCells).build();
		return patientData;
	}

}
