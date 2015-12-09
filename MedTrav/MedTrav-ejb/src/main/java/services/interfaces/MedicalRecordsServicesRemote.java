package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.*;

@Remote
public interface MedicalRecordsServicesRemote {
	Boolean addMedicalRecords(MedicalRecords medicalRecords);

	Boolean updateMedicalRecords(MedicalRecords medicalRecords);

	MedicalRecords findMedicalRecordsByPatientId(Integer patientId);

	byte[] downloadAnalysis(int id);

	byte[] downloadPatientFile(int id);

	List<Patient> listAssignedPatientsToDoctor(Integer idDoctor);

	Patient findPatientByFirstNameAndLastName(String FirstName, String LastName);

}
