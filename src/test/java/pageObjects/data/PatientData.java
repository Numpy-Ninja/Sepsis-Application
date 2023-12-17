package pageObjects.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PatientData {
	private String firstName;
	private String lastName;
	private String gender;
	private String dob;
	private String phoneNumber;
	private String email;
	private String emergencyContactNumber;
	private String doctorEmail;
	private String otherExistingMorbidities;
	private String fitnessFrequency;
	private String immunization;
	private String currentMedication;
	private String temperature;
	private String heartRate;
	private String respiratoryRate;
	private String bp;
	private String glucose;
	private String glucoseValue;
	private String whiteBloodCells;
	
	
}
