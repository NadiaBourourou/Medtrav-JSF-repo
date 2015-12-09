package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Doctor;
import entities.DoctorPatient;
import entities.Patient;
import entities.Surgery;
import entities.Testimony;
import entities.User;
import services.interfaces.AssignedPatientsServicesLocal;
import services.interfaces.AssignedPatientsServicesRemote;

/**
 * Session Bean implementation class AssignedPatientsServices
 */
@Stateless
public class AssignedPatientsServices implements AssignedPatientsServicesRemote, AssignedPatientsServicesLocal{

	@PersistenceContext
	EntityManager entitymanager;

	
    /**
     * Default constructor. 
     */
    public AssignedPatientsServices() {
        // TODO Auto-generated constructor stub
    }

    
    @SuppressWarnings("unchecked")
	@Override
	public List<Patient> findAllPatientsByDoctorId(Integer doctorId) {
		String jpql="select p from Patient p join p.doctorPatients dp where dp.doctor.id =:param";
		Query query=entitymanager.createQuery(jpql);
		query.setParameter("param",doctorId);
		return query.getResultList();
	
	}
    
    @SuppressWarnings("unchecked")
  	@Override
  	public Surgery findSurgeryByPatientId(Integer patientId) {
  		String jpql="select s from Surgery s join s.surgeryPatients dp where dp.patient.id =:param";
  		Query query=entitymanager.createQuery(jpql);
  		query.setFirstResult(0);
		query.setMaxResults(1);
  		query.setParameter("param",patientId);
  		return  (Surgery)query.getSingleResult();
  	
  	}

	@Override
	public Boolean assignPatientToDoctorId(Integer idDoctor,
			Integer idPatient) {
		Boolean b = false;
		try {
			Patient patientFound = (Patient)entitymanager.find(User.class, idPatient);
			Doctor doctorFound = (Doctor)entitymanager.find(User.class,idDoctor);

			DoctorPatient doctorpatient=new DoctorPatient(doctorFound,patientFound);
			//testimonyFound.setPatient(patientFound);

			entitymanager.merge(doctorpatient);
			b = true;

		} catch (Exception e) {
			System.err.println("ouups ...");
		}

		return b;
	}
	
	@Override
	public Boolean assignPatientToDoctor(Doctor doctor,
			Integer idPatient) {
		Boolean b = false;
		try {
			Patient patientFound = (Patient)entitymanager.find(User.class, idPatient);
			

			DoctorPatient doctorpatient=new DoctorPatient(doctor,patientFound);
			//testimonyFound.setPatient(patientFound);

			entitymanager.merge(doctorpatient);
			b = true;

		} catch (Exception e) {
			System.err.println("ouups ...");
		}

		return b;
	}
	

	@Override
	public Boolean acceptPatient(Patient patient) {
		Boolean b = false;
		try {
			patient.setConfirmed(true);
			entitymanager.merge(patient);
			b = true;

		} catch (Exception e) {
			System.err.println("Error ...");
		}
		return b;
	}

	
	@Override
	public Boolean refusePatient(Patient patient,Integer doctorId) {
		Boolean b = false;
		try {
			Doctor thisDoctor=(Doctor)entitymanager.find(User.class, doctorId);
			patient.setConfirmed(false);
			
			Doctor doctorFound=findDoctorsBySpecialtyAndNotThisDoc(thisDoctor.getSpecialty(), doctorId);
		    assignPatientToDoctor(doctorFound, patient.getUserId());
			entitymanager.merge(patient);
			b = true;

		} catch (Exception e) {
			System.err.println("Error ...");
		}
		return b;
	}
	
	@Override
	public Boolean deleteAssignPatient(Integer patientId,Integer doctorId) {
		Boolean b = false;
		try {
			DoctorPatient doctorPatientFound=findAssignPatient(patientId, doctorId);
			entitymanager.remove(doctorPatientFound);
			b = true;

		} catch (Exception e) {
			System.err.println("Error ...");
		}
		return b;
		
	}	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public DoctorPatient findAssignPatient(Integer patientId,Integer doctorId) {
	
		String jpql = "select d from DoctorPatient d where d.patient.id=:param AND d.doctor.id=:param2";
		Query query = entitymanager.createQuery(jpql);
		
	//	return query.getResultList();
		
		query.setFirstResult(0);
		query.setMaxResults(1);
		query.setParameter("param", patientId);
		query.setParameter("param2", doctorId);
		return  (DoctorPatient) query.getSingleResult();
		
	}
	
    
	@SuppressWarnings("unchecked")
	@Override
	public Doctor findDoctorsBySpecialtyAndNotThisDoc(String specialte,Integer doctorId) {
	
		String jpql = "select d from Doctor d where d.specialty LIKE :param AND userId!=:param2";
		Query query = entitymanager.createQuery(jpql);
		
	//	return query.getResultList();
		
		query.setFirstResult(0);
		query.setMaxResults(1);
		query.setParameter("param", "%" + specialte + "%");
		query.setParameter("param2", doctorId);
		return (Doctor) query.getSingleResult();
		
	}
	

	
	public List<Doctor> findDoctorsBySpecialtyAndNotThisDocList(String specialte,Integer doctorId) {
		
		String jpql = "select d from Doctor d where d.specialty LIKE :param AND userId!=:param2";
		Query query = entitymanager.createQuery(jpql);
		query.setParameter("param", "%" + specialte + "%");
	query.setParameter("param2", doctorId);
		return query.getResultList();
	}
	
    
    
    
}
