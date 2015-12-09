package services.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import entities.Booking;
import entities.Doctor;
import entities.Flight;
import entities.FlightMatching;
import entities.MedicalRecords;
import entities.Patient;
import entities.Surgery;
import entities.User;
import services.interfaces.BookingServicesLocal;
import services.interfaces.FlightServicesLocal;
import services.interfaces.FlightServicesRemote;
import services.interfaces.SurgeryServicesLocal;

/**
 * Session Bean implementation class FlightServices
 */
@Stateless
public class FlightServices implements FlightServicesRemote,
		FlightServicesLocal {

	@PersistenceContext
	EntityManager entityManager;

	@EJB
	private BookingServicesLocal bookingServicesLocal;

	@EJB
	private SurgeryServicesLocal surgeryServicesLocal;

	/**
	 * Default constructor.
	 */
	public FlightServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addFlight(Flight flight) {
		Boolean b = false;
		try {
			entityManager.merge(flight);
			b = true;

		} catch (Exception e) {
			System.err.println("Error adding flight");
		}
		return b;
	}

	@Override
	public Boolean updateFlight(Flight flight) {
		Boolean b = false;
		try {
			entityManager.merge(flight);
			b = true;

		} catch (Exception e) {
			System.err.println("Error updating flight");
		}
		return b;
	}

	@Override
	public Boolean deleteFlight(Flight flight) {
		Boolean b = false;
		try {
			Flight flightFound = entityManager.find(Flight.class,
					flight.getFlightId());
			entityManager.remove(flightFound);
			b = true;

		} catch (Exception e) {
			System.err.println("Error deleting flight");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> findAllFlightsByPatientId(Integer patientId) {
		String jpql="select f from Flight f where f.patient.id =:param";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("param", patientId);
		return query.getResultList();
	
	}


	@Override
	public Flight findFlightById(Integer idFlight) {
		return entityManager.find(Flight.class, idFlight);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FlightMatching> findFlightsByAirline(String airline) {
		// String jpql =
		// "select f from FlightMatching f where UPPER(f.airline) = UPPER(:%param%)";
		// //recherche insensible � la casse
		String jpql = "select f from FlightMatching f where f.airline=:param"; // recherche
																					// insensible
																					// �
																					// la
																					// casse

		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", airline);
		return query.getResultList();
	}

	@Override
	public Boolean assignFlightToBooking(Integer idBooking, Integer idFlight) {
		Boolean b = false;
		try {
			Booking bookingFound = bookingServicesLocal
					.findBookingById(idBooking);

			Flight flightFound = entityManager.find(Flight.class, idFlight);

			bookingFound.setFlight(flightFound);

			entityManager.merge(bookingFound);
			b = true;

		} catch (Exception e) {
			System.err.println("ouups ...");
		}

		return b;
	}

	/*@Override
	public Boolean assignFlightToBookingSlaveSide(Integer idBooking,
			Integer idFlight) {
		Boolean b = false;
		try {
			Booking bookingFound = bookingServicesLocal
					.findBookingById(idBooking);

			Flight flightFound = entityManager.find(Flight.class, idFlight);

			List<Booking> bookings = bookingServicesLocal
					.findAllBookingsByFlightId(idFlight);

			bookings.add(bookingFound);

			flightFound.linkBookingsToThisFlight(bookings);

			entityManager.merge(flightFound);

			b = true;

		} catch (Exception e) {
			System.err.println("ouups ...");
		}

		return b;
	}*/

	@Override
	public Boolean assignDoctorToSurgery(Integer idSurgery, Integer idDoctor) {
		Boolean b = false;
		try {
			Surgery surgeryFound = surgeryServicesLocal
					.findSurgeryById(idSurgery);

			Doctor doctorFound = entityManager.find(Doctor.class, idDoctor);

			surgeryFound.setDoctor(doctorFound);

			entityManager.merge(surgeryFound);
			b = true;

		} catch (Exception e) {
			System.err.println("ouups ...");
		}

		return b;
	}

	@Override
	public Boolean assignDoctorToSurgerySlaveSide(Integer idSurgery,
			Integer idDoctor) {

		Boolean b = false;
		try {
			Surgery surgeryFound = surgeryServicesLocal
					.findSurgeryById(idSurgery);

			Doctor doctorFound = entityManager.find(Doctor.class, idDoctor);

			List<Surgery> surgeries = surgeryServicesLocal
					.findAllSurgeriesByDoctorId(idDoctor);

			surgeries.add(surgeryFound);

			doctorFound.linkSurgeriesToThisDoctor(surgeries);

			entityManager.merge(doctorFound);

			b = true;

		} catch (Exception e) {
			System.err.println("ouups ...");
		}

		return b;
	}

	/*	@Override
	public Boolean assignMedicalRecordToSurgery(Integer idSurgery,
			Integer idMedicalRecord) {
		Boolean b = false;
		try {
			Surgery surgeryFound = surgeryServicesLocal
					.findSurgeryById(idSurgery);

			MedicalRecords medicalRecordFound = entityManager.find(
					MedicalRecords.class, idMedicalRecord);

			surgeryFound.setMedicalRecords(medicalRecordFound);

			entityManager.merge(surgeryFound);
			b = true;

		} catch (Exception e) {
			System.err.println("ouups ...");
		}

		return b;
	}

	@Override
	public Boolean assignMedicalRecordToSurgerySlaveSide(Integer idSurgery,
			Integer idMedicalRecord) {
		Boolean b = false;
		try {
			Surgery surgeryFound = surgeryServicesLocal
					.findSurgeryById(idSurgery);

			MedicalRecords medicalRecordsFound = entityManager.find(
					MedicalRecords.class, idMedicalRecord);

			List<Surgery> surgeries = surgeryServicesLocal
					.findAllSurgeriesByMedicalRecordsId(idMedicalRecord);

			surgeries.add(surgeryFound);

			medicalRecordsFound.linkSurgeriesToThisMedicalRecords(surgeries);

			entityManager.merge(medicalRecordsFound);

			b = true;

		} catch (Exception e) {
			System.err.println("ouups ...");
		}

		return b;
	}
*/
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FlightMatching> findAllDepartures() {
		String jpql = "select f from FlightMatching f group by f.departure";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FlightMatching> findAllArrivals() {
		String jpql = "select f from FlightMatching f group by f.arrival";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FlightMatching> findMatchingFlight(String departure,
			String arrival, String departureDate, String arrivalDate) {

		// String jpql =
		// "select f from FlightMatching f where f.departure=:param1 AND f.arrival=:param2 AND f.DateFlightMatchingDep:=param3 AND f.DateFlightMatchingArr:=param4 AND numberOfSits>0";
		String jpql = "select f from FlightMatching f where f.departure=:param1 AND f.arrival=:param2 AND f.dateFlightMatchingDep=:param3 AND f.dateFlightMatchingArr=:param4";

		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", departure);
		query.setParameter("param2", arrival);
		query.setParameter("param3", departureDate);
		query.setParameter("param4", arrivalDate);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> findAllFlight() {
		String jpql = "select f from Flight f";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	// ancienne version avant combo
	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public List<String> findAllDepartures() { String jpql =
	 * "select f.departure from FlightMatching f order by f.departure"; Query
	 * query = entityManager.createQuery(jpql); return query.getResultList(); }
	 */

	@Override
	public Patient findPatientById(Integer idPatient) {
		return entityManager.find(Patient.class, idPatient);
	}

	/*
	 * @Override public FlightMatching findFlightMatchingByNumFlight(String
	 * numF) { String jpql =
	 * "select f from FlightMatching f where f.numFlight =: param";
	 * 
	 * Query query = entityManager.createQuery(jpql);
	 * query.setParameter("param", numF);
	 * 
	 * FlightMatching flightMatchingChosen = null; flightMatchingChosen =
	 * (FlightMatching) query.getSingleResult(); return flightMatchingChosen; }
	 */

	@Override
	public FlightMatching findFlightMatchingByNumFlight(String numF) {
		FlightMatching user = null;
		Query query = entityManager
				.createQuery("select f from FlightMatching f where f.numFlight=:param ");
		query.setParameter("param", numF);

		try {
			user = (FlightMatching) query.getSingleResult();
		} catch (Exception e) {
			user = null;
		}

		return user;
	}

	@Override
	public FlightMatching findFlightMatchingById(Integer idFmatching) {
		return entityManager.find(FlightMatching.class, idFmatching);
	}

/*	@Override
	public Boolean updateNbSits(Integer nbSitsMaj, Integer idFlight) {
		Boolean b = false;
		try {
		String jpql="update FlightMatching f set f.numberOfSits=:param1 where f.idFlightMatching=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", nbSitsMaj);
		query.setParameter("param2", idFlight);
		b=true;
		} catch (Exception e) {
			System.err.println("Error updating nbSits");
		}
		return b;
		}
*/
		
	@Override
	public Boolean updateNbSits(FlightMatching flightMatch) {
	Boolean b = false;
		try {
			entityManager.merge(flightMatch);
			b = true;

		} catch (Exception e) {
			System.err.println("Error updating flight");
		}
		return b;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<FlightMatching> findMatchingFlightWithThatFromAndTo(
			String fromMatching, String toMatching) {
		String jpql = "select f from FlightMatching f where f.departure=:param1 AND f.arrival=:param2 ";

		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", fromMatching);
		query.setParameter("param2", toMatching);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FlightMatching> findAllFlightMatching() {
		String jpql="select f from FlightMatching f";
		Query query=entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllDepaturesSansDoublons() {
		String jpql = "select f.departure from FlightMatching f group by f.departure";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllDepaturesOfOurPatients() {
		String jpql = "select f.departureLocation from Flight f";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FlightMatching> findFlightByDepartureLocation(String searchDep) {
		String jpql = "select f from FlightMatching f where f.departure  LIKE :param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", "%" + searchDep + "%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FlightMatching> findFlightByArrivalLocation(String searchArr) {
		String jpql = "select f from FlightMatching f where f.arrival  LIKE :param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", "%" + searchArr + "%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FlightMatching> findFlightByAirline(String searchAirline) {
		String jpql = "select f from FlightMatching f where f.airline  LIKE :param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", "%" + searchAirline + "%");
		return query.getResultList();
	}

	@Override
	public long mostWorkingAirlines(String airlineGiven) {
	Query query=entityManager.createQuery("select count(f.idFlightMatching) from FlightMatching f where f.airline=:param ");
	query.setParameter("param", airlineGiven);
	return (long) query.getSingleResult();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllAirlines() {
		String jpql = "select f.airline from FlightMatching f group by f.airline";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}


}
