package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Patient;
import entities.Surgery;
import entities.Testimony;
import entities.User;

@Local
public interface TestimonyServicesLocal {


	
	Boolean addTestimony(Testimony testimony);

	Boolean updateTestimony(Testimony testimony);

	 Boolean deleteTestimony(Testimony testimony);
	
	 List<Testimony> findAllTestimoniesByPatientId(Integer patientId);


	 Testimony findTestimonyById(Integer idTestimony);

	Boolean assignTestimonyToPatient(Integer idTestimony, Integer idPatient);

	Patient findPatientById(Integer idPatient);

	List<Testimony> findAllTestimonies();

	User findUserById(Integer idUser);

	List<Testimony> findAllTestimoniesByTitle(String titleParam);

	List<Testimony> findAllTestimoniesByPatientLastName(String s);
	User findDoctorById(Integer idUser);
	Surgery findSurgeryById(Integer idUser);
	
}
