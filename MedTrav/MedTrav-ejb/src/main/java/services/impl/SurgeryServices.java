package services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.SurgeryServicesLocal;
import services.interfaces.SurgeryServicesRemote;
import entities.Doctor;
import entities.Flight;
import entities.Patient;
import entities.Procedure;
import entities.Surgery;
import entities.Testimony;
import entities.User;

/**
 * Session Bean implementation class SurgeryServices
 */
@Stateless
public class SurgeryServices implements SurgeryServicesRemote,
		SurgeryServicesLocal {

	@PersistenceContext
	EntityManager entityManager;


	public SurgeryServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Surgery findSurgeryById(Integer idSurgery) {
		return entityManager.find(Surgery.class, idSurgery);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Surgery> findAllSurgeriesByDoctorId(Integer id) {
		String jpql = "select s from Surgery s where s.doctor.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", id);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Surgery> findAllSurgeriesByMedicalRecordsId(Integer id) {
		String jpql = "select s from Surgery s where s.medicalRecords.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", id);
		return query.getResultList();
	}

	@Override
	public Boolean assignProcedureToSurgery(Surgery newTreatment,
			Integer procedureId) {
		Boolean b = false;
		try {
			Procedure procedure = entityManager.find(Procedure.class,
					procedureId);
			newTreatment.setProcedure(procedure);
			entityManager.merge(newTreatment);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean addSurgery(Surgery treatment) {
		Boolean b = false;
		try {
			entityManager.persist(treatment);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public void addSurgeryAndAssignItToProcedure(Surgery treatment,
			Integer idProcedure) {

		Procedure procedure = entityManager.find(Procedure.class, idProcedure);
		treatment.setProcedure(procedure);
		entityManager.merge(treatment);
	}

	@Override
	public boolean addProcedure(Procedure procedure) {
		Boolean b = false;
		try {
			entityManager.persist(procedure);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public List<Procedure> findAllProcedures() {
		String jpql = "select p from Procedure p";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<Surgery> findAllSurgeriesByProcedureId(Integer procedureId) {
		String jpql = "select s from Surgery s where s.procedure.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", procedureId);
		return query.getResultList();
	}

	@Override
	public String getSurgeryDescription(Integer treatmentId) {
		Surgery surgery = entityManager.find(Surgery.class, treatmentId);
		return surgery.getDescription();
	}

	@Override
	public Boolean updateSurgery(Surgery treatment) {
		Boolean b = false;
		try {
			entityManager.merge(treatment);
			b = true;

		} catch (Exception e) {
			System.err.println("Error updating surgery");
		}
		return b;
	}

	@Override
	public Boolean deleteSurgery(Surgery treatment) {
		Boolean b = false;
		try {
			Surgery surgeryFound = entityManager.find(Surgery.class,treatment.getSurgeryId());
			entityManager.remove(surgeryFound);
			b = true;

		} catch (Exception e) {
			System.err.println("Error deleting treatment");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Surgery> findAllSurgeries() {
		String jpql="select s from Surgery s";
		Query query=entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Doctor findDoctorById(Integer idDoctor) {
		return entityManager.find(Doctor.class, idDoctor);
	}

	@Override
	public Boolean assignSurgeryToProcedureNv(Integer idSurgery,
			Integer idProcedure) {
		Boolean b = false;
		try {
			Procedure procedureFound = (Procedure)entityManager.find(Procedure.class, idProcedure);
			
			Surgery surgeryFound = entityManager.find(Surgery.class,
					idSurgery);

			surgeryFound.setProcedure(procedureFound);

			entityManager.merge(surgeryFound);
			b = true;

		} catch (Exception e) {
			System.err.println("ouups ...");
		}

		return b;
	}

}
