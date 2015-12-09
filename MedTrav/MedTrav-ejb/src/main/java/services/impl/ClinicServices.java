package services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.ClinicServicesLocal;
import services.interfaces.ClinicServicesRemote;
import entities.Clinic;
import entities.ClinicBooking;
import entities.Patient;
import entities.RoomClinicType;

/**
 * Session Bean implementation class ClinicServices
 */
@Stateless
public class ClinicServices implements ClinicServicesRemote,
		ClinicServicesLocal {
	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ClinicServices() {

	}

	@Override
	public Boolean addClinic(Clinic clinic) {
		Boolean b = false;
		try {
			entityManager.merge(clinic);
			b = true;

		} catch (Exception e) {
			System.err.println("Error ");
		}
		return b;
	}

	@Override
	public Boolean deleteClinicById(Integer id) {
		Boolean b = false;
		try {
			Clinic foundClinic = entityManager.find(Clinic.class, id);
			entityManager.remove(foundClinic);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Clinic findClinicById(Integer id) {

		return entityManager.find(Clinic.class, id);
	}

	@Override
	public Boolean updateClinic(Clinic clinic) {
		Boolean b = false;
		try {
			entityManager.merge(clinic);
			b = true;

		} catch (Exception e) {
			System.err.println("Error");
		}
		return b;
	}

	@Override
	public Boolean deleteClinic(Clinic clinic) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(clinic));
			b = true;

		} catch (Exception e) {
			System.err.println("Error");
		}
		return b;
	}

	@Override
	public List<Clinic> findAllClinics() {
		String jpql = "select c from Clinic c ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<Clinic> findClinicByName(String name) {
		String jpql = "select h from Clinic h where h.name  LIKE :param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", "%" + name + "%");
		return query.getResultList();
	}

	@Override
	public Boolean addClinicBookingAndAffectClinic(ClinicBooking clinicBooking,
			Integer id) {
		Boolean b = false;

		try {
			Clinic clinic = entityManager.find(Clinic.class, id);

			clinicBooking.setClinic(clinic);
			entityManager.merge(clinicBooking);
			b = true;
		} catch (Exception e) {
			System.err.println("error");
		}
		return b;

	}

	@Override
	public Boolean bookClinic(RoomClinicType typeRoom, Date date,
			String commentaire, Clinic clinic, Integer idPatient) {
		Boolean b = false;
		try {
			Patient patient = entityManager.find(Patient.class, idPatient);
			ClinicBooking clinicBooking = new ClinicBooking(typeRoom, date,
					commentaire, clinic, patient);
			entityManager.merge(clinicBooking);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}
}
