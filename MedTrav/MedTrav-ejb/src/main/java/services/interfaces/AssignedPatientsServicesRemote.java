package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Doctor;
import entities.DoctorPatient;
import entities.Patient;
import entities.Surgery;

@Remote
public interface AssignedPatientsServicesRemote {





	List<Patient> findAllPatientsByDoctorId(Integer doctorId);

	Boolean acceptPatient(Patient patient);

	Boolean assignPatientToDoctor(Doctor doctor, Integer idPatient);

	Boolean assignPatientToDoctorId(Integer idDoctor, Integer idPatient);

	Doctor findDoctorsBySpecialtyAndNotThisDoc(String specialte,
			Integer doctorId);

	Boolean refusePatient(Patient patient, Integer doctorId);

	DoctorPatient findAssignPatient(Integer patientId, Integer doctorId);

	Boolean deleteAssignPatient(Integer patientId, Integer doctorId);

	Surgery findSurgeryByPatientId(Integer patientId);
	
	

}
