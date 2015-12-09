package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.MedicalRecordsServicesLocal;
import services.interfaces.MedicalRecordsServicesRemote;
import entities.MedicalRecords;
import entities.Patient;

/**
 * Session Bean implementation class MedicalRecordsServices
 */
@Stateless
public class MedicalRecordsServices implements MedicalRecordsServicesRemote,
		MedicalRecordsServicesLocal {

	@PersistenceContext
	EntityManager entityManager;

	public MedicalRecordsServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addMedicalRecords(MedicalRecords medicalRecords) {
		Boolean b = false;
		try {

			entityManager.merge(medicalRecords);
			b = true;

		} catch (Exception e) {
			System.err.println("Error");
		}
		return b;
	}

	@Override
	public Boolean updateMedicalRecords(MedicalRecords medicalRecords) {
		Boolean b = false;
		try {

			entityManager.merge(medicalRecords);
			b = true;

		} catch (Exception e) {
			System.err.println("Error");
		}
		return b;
	}

	@Override
	public MedicalRecords findMedicalRecordsByPatientId(Integer patientId) {
		String jpql = "select m from MedicalRecords m where m.patient.userId=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", patientId);
		return (MedicalRecords) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> listAssignedPatientsToDoctor (Integer idDoctor) {
		String jpql = "select u from User u join u.doctorPatients dps where dps.doctor.userId=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", idDoctor);
		return query.getResultList();
	}
	
	@Override
	public Patient findPatientByFirstNameAndLastName (String FirstName , String LastName) {
		String jpql = "select p from Patient p where p.firstName=:param1 AND p.lastName=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", FirstName);
		query.setParameter("param2", LastName);
		return (Patient) query.getSingleResult();
	}
	
	@Override
	public byte[] downloadAnalysis(int id) {
		String jpql = "select m.analysis from MedicalRecords m where m.patient.userId=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", id);
		Object o = query.getSingleResult();
		byte[] tmpArray = (byte[]) o;
		return tmpArray;
	}
	
	@Override
	public byte[] downloadPatientFile(int id) {
		String jpql = "select m.patientFile from MedicalRecords m where m.patient.userId=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", id);
		Object o = query.getSingleResult();
		byte[] tmpArray = (byte[]) o;
		return tmpArray;
	}
	
	
	
	

}
