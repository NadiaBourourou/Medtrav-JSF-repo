package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.UserServicesLocal;
import services.interfaces.UserServicesRemote;
import entities.Administrator;
import entities.Doctor;
import entities.DoctorPatient;
import entities.DoctorPatientID;
import entities.Patient;
import entities.RoleType;
import entities.Surgery;
import entities.SurgeryPatient;
import entities.SurgeryPatientID;
import entities.User;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices implements UserServicesRemote, UserServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	public UserServices() {
	}

	// Doctor Services
	@Override
	public boolean addDocor(Doctor doctor) {
		Boolean b = false;
		try {
			entityManager.persist(doctor);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		Boolean b = false;
		try {
			entityManager.merge(doctor);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public boolean removeDoctor(Integer doctorId) {
		Boolean b = false;
		try {
			Doctor foundDoctor = entityManager.find(Doctor.class, doctorId);
			entityManager.remove(foundDoctor);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Doctor findDoctorById(Integer id) {
		return entityManager.find(Doctor.class, id);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> findDoctorsBySpecialty(String specialty) {
		// String jpql = "select d from Doctor d where d.specialty=:param";
		String jpql = "select d from Doctor d where d.specialty  LIKE :param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", "%" + specialty + "%");
		return query.getResultList();
	}

	@Override
	public List<Doctor> findAllDoctors() {
		String jpql = "select u from User u where u.role=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", RoleType.DOCTOR);
		return query.getResultList();
	}

	// ______________________________________________________________________________________________
	// _______________________________________PATIENT
	// ________________________________________________
	// ______________________________________________________________________________________________

	@Override
	public boolean addPatient(Patient patient) {
		Boolean b = false;
		try {
			entityManager.persist(patient);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public boolean updatePatient(Patient patient) {
		Boolean b = false;
		try {
			entityManager.merge(patient);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public boolean removePatient(Integer patientId) {
		Boolean b = false;
		try {
			Patient foundPatient = entityManager.find(Patient.class, patientId);
			entityManager.remove(foundPatient);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Patient findPatientByPassportNumber(Integer nbPassport) {
		String jpql = "select p from Patient p where p.numPassport=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", nbPassport);
		return (Patient) query.getSingleResult();
	}

	@Override
	public User userIdentification(String login, String password) {
		User user = null;
		Query query = entityManager
				.createQuery("select u from User u where u.login=:l and u.password=:p ");
		query.setParameter("l", login).setParameter("p", password);

		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			user = null;
		}

		return user;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> findAlltreatedPatiends() {
		String jpql = "select p from Patient p where p.state=:'TREATED'";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> listAllPatients() {
		String jpql = "select u from User u where u.role=:param ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", RoleType.PATIENT);
		return query.getResultList();
	}

	public Patient findPatientByFirstAndLastName(String firstName,
			String lastName) {
		String jpql = "select u from User u where u.firstName=:param1 and u.lastName=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", firstName);
		query.setParameter("param2", lastName);
		return (Patient) query.getSingleResult();
	}

	// we will only need this one for PopulateDb
	@Override
	public boolean addAdmin(Administrator admin) {
		Boolean b = false;
		try {
			entityManager.persist(admin);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	public List<User> findAllUsers() {

		String jpql = "select u from User u";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", RoleType.PATIENT);
		return query.getResultList();

	}

	@Override
	public Patient findPatientById(Integer id) {

		return entityManager.find(Patient.class, id);
	}

	@Override
	public Boolean bookSurgery(Surgery surgery, String commentaire,
			Integer idPatient) {
		Boolean b = false;
		try {
			SurgeryPatientID surgeryPatientID = new SurgeryPatientID();
			surgeryPatientID.setIdPatient(idPatient);
			surgeryPatientID.setIdSurgery(surgery.getSurgeryId());
			SurgeryPatient surgeryBooking = new SurgeryPatient(
					surgeryPatientID, commentaire);
			entityManager.merge(surgeryBooking);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public void chooseDoctor(Doctor selectedDoctor, Integer idPatient) {
	
			DoctorPatientID docPatId = new DoctorPatientID();
			docPatId.setPatientId(idPatient);
			docPatId.setDoctorId(selectedDoctor.getUserId());
			
			DoctorPatient docPat = new DoctorPatient();
			docPat.setId(docPatId);
			entityManager.merge(docPat);

	}

}
