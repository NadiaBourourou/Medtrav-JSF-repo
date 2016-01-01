package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.MedicalRecords;
import entities.Patient;

@Local
public interface MedicalRecordsServicesLocal {
	Boolean addMedicalRecords(MedicalRecords medicalRecords);

	Boolean updateMedicalRecords(MedicalRecords medicalRecords);

	MedicalRecords findMedicalRecordsByPatientId(Integer patientId);

	byte[] downloadAnalysis(int id);

	byte[] downloadPatientFile(int id);

	List<Patient> listAssignedPatientsToDoctor(Integer idDoctor);

	Patient findPatientByFirstNameAndLastName(String FirstName, String LastName);

}
