package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Doctor;
import entities.Patient;
import entities.Surgery;
import entities.Testimony;
import entities.User;
import services.interfaces.TestimonyServicesLocal;
import services.interfaces.TestimonyServicesRemote;

/**
 * Session Bean implementation class TestimonyServices
 */
@Stateless
public class TestimonyServices implements TestimonyServicesRemote, TestimonyServicesLocal{

	@PersistenceContext
	EntityManager entitymanager;

    /**
     * Default constructor. 
     */
    public TestimonyServices() {
        // TODO Auto-generated constructor stub
    }
	

	@Override
	public Boolean addTestimony(Testimony testimony) {
		Boolean b = false;
		try {
			entitymanager.merge(testimony);
			b = true;

		} catch (Exception e) {
			System.err.println("Error ...");
		}
		return b;
	}


	@Override
	public Boolean updateTestimony(Testimony testimony) {
		Boolean b = false;
		try {
			entitymanager.merge(testimony);
			b = true;

		} catch (Exception e) {
			System.err.println("Error ...");
		}
		return b;
	}


	@Override
	public Boolean deleteTestimony(Testimony testimony) {
		Boolean b = false;
		try {
			Testimony testimonyFound=entitymanager.find(Testimony.class, testimony.getTestimonyId());
			entitymanager.remove(testimonyFound);
			b = true;

		} catch (Exception e) {
			System.err.println("Error ...");
		}
		return b;
		
	}	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Testimony> findAllTestimoniesByTitle(String title) {
		String jpql="select t from Testimony t where t.title LIKE :param";
		Query query=entitymanager.createQuery(jpql);
		query.setParameter("param",  "%" + title + "%");
		return query.getResultList();
	
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Testimony> findAllTestimoniesByPatientLastName(String name) {
		String jpql="select t from Testimony t where t.patient.lastName LIKE :param";
		Query query=entitymanager.createQuery(jpql);
		query.setParameter("param",  "%" + name + "%");
		return query.getResultList();
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Testimony> findAllTestimoniesByPatientId(Integer patientId) {
		String jpql="select t from Testimony t where t.patient.id =:param";
		Query query=entitymanager.createQuery(jpql);
		query.setParameter("param", patientId);
		return query.getResultList();
	
	}




	@SuppressWarnings("unchecked")
	@Override
	public List<Testimony> findAllTestimonies() {
		String jpql="select t from Testimony t ";
		Query query=entitymanager.createQuery(jpql);
		return query.getResultList();
	
	}

	@Override
	public Testimony findTestimonyById(Integer idTestimony) {
		// TODO Auto-generated method stub
		return entitymanager.find(Testimony.class, idTestimony);
	}

	@Override
	public Boolean assignTestimonyToPatient(Integer idTestimony,
			Integer idPatient) {
		Boolean b = false;
		try {
			Patient patientFound = (Patient)entitymanager.find(User.class, idPatient);
			
			// ou bien
			//Employee employeeFound = entityManager.find(Employee.class,idEmployee);
			//
			Testimony testimonyFound = entitymanager.find(Testimony.class,
					idTestimony);

			testimonyFound.setPatient(patientFound);

			entitymanager.merge(testimonyFound);
			b = true;

		} catch (Exception e) {
			System.err.println("ouups ...");
		}

		return b;
	}

	@Override
	public Patient findPatientById(Integer idPatient) {
		// TODO Auto-generated method stub
		return entitymanager.find(Patient.class, idPatient);
	}

	
	@Override
	public User findUserById(Integer idUser) {
		// TODO Auto-generated method stub
		return entitymanager.find(User.class, idUser);
	}
	
	
	@Override
	public Doctor findDoctorById(Integer idUser) {
		// TODO Auto-generated method stub
		return entitymanager.find(Doctor.class, idUser);
	}
	
	@Override
	public Surgery findSurgeryById(Integer idUser) {
		// TODO Auto-generated method stub
		return entitymanager.find(Surgery.class, idUser);
	}
	
}
