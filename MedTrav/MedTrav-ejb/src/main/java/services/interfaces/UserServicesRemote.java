package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Administrator;
import entities.Clinic;
import entities.Doctor;
import entities.Patient;
import entities.Surgery;
import entities.User;

@Remote
public interface UserServicesRemote {

	boolean addDocor(Doctor doctor);

	boolean updateDoctor(Doctor doctor);

	boolean removeDoctor(Integer doctorId);

	Doctor findDoctorById(Integer id);
	Patient findPatientById(Integer id);

	List<Doctor> findDoctorsBySpecialty(String specialty);

	List<Doctor> findAllDoctors();

	boolean addPatient(Patient patient);

	boolean updatePatient(Patient patient);

	boolean removePatient(Integer patientId);

	Patient findPatientByPassportNumber(Integer nbPassport);

	List<Patient> findAlltreatedPatiends();

	List<Patient> listAllPatients();

	Patient findPatientByFirstAndLastName(String firstName, String lastName);

	boolean addAdmin(Administrator admin);

	User userIdentification(String login, String password);

	public List<User> findAllUsers();

	Boolean bookSurgery(Surgery surgery, String commentaire,Integer idPatient);

	void chooseDoctor(Doctor selectedDoctor, Integer idPatient);

}
