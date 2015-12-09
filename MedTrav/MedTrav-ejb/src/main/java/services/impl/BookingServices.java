package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.BookingServicesLocal;
import services.interfaces.BookingServicesRemote;
import entities.Booking;
import entities.Clinic;
import entities.ClinicBooking;
import entities.DoctorPatient;
import entities.Flight;
import entities.Hotel;
import entities.HotelBooking;
import entities.Surgery;
import entities.SurgeryPatient;

/**
 * Session Bean implementation class BookingServices
 */
@Stateless
public class BookingServices implements BookingServicesRemote,
		BookingServicesLocal {

	@PersistenceContext
	EntityManager entitymanager;

	public BookingServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addBooking(Booking booking) {
		Boolean b = false;
		try {
			entitymanager.merge(booking);
			b = true;

		} catch (Exception e) {
			System.err.println("Error ...");
		}
		return b;
	}

	@Override
	public Boolean updateBooking(Booking booking) {
		Boolean b = false;
		try {
			entitymanager.merge(booking);
			b = true;

		} catch (Exception e) {
			System.err.println("Error ...");
		}
		return b;
	}

	@Override
	public Boolean deleteBooking(Booking booking) {
		Boolean b = false;
		try {
			entitymanager.remove(findBookingById(booking.getBookingId()));
			b = true;
		} catch (Exception e) {
			System.err.println("Error");
		}

		return b;
	}

	@Override
	public Boolean deleteBookingByPatientId(Booking booking) {
		Boolean b = false;
		try {
			Booking booking1 = new Booking();
			booking1 = entitymanager
					.find(Booking.class, booking.getBookingId());
			entitymanager.remove(booking1);
			b = true;
		} catch (Exception e) {
			
			System.err.println("Error");
		}

		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> findAllBookingsByPatient(Integer patientId) {
		String jpql = "select b from booking where b.patient.userId=:param";
		Query query = entitymanager.createQuery(jpql);
		query.setParameter("param", patientId);
		return query.getResultList();
	}

	@Override
	public HotelBooking findHotelBookingByPatientId(Integer idPatient) {
		String jpql = "select hb from HotelBooking hb where hb.patient.userId=:param";
		Query query = entitymanager.createQuery(jpql);
		query.setParameter("param", idPatient);
		return (HotelBooking) query.getSingleResult();
	}

	@Override
	public ClinicBooking findClinicBookingByPatientId(Integer idPatient) {
		String jpql = "select cb from ClinicBooking cb where cb.patient.userId=:param";
		Query query = entitymanager.createQuery(jpql);
		query.setParameter("param", idPatient);
		return (ClinicBooking) query.getSingleResult();
	}

	@Override
	public SurgeryPatient findSurgeryPatientByPatientId(Integer idPatient) {
		String jpql = "select sp from SurgeryPatient sp where sp.patient.userId=:param";
		Query query = entitymanager.createQuery(jpql);
		query.setParameter("param", idPatient);
		return (SurgeryPatient) query.getSingleResult();
	}

	@Override
	public DoctorPatient findDoctorPatientByPatientId(Integer idPatient) {
		String jpql = "select dp from DoctorPatient dp where dp.patient.userId=:param";
		Query query = entitymanager.createQuery(jpql);
		query.setParameter("param", idPatient);
		return (DoctorPatient) query.getSingleResult();
	}

	@Override
	public Flight findFlightByPatientId(Integer idPatient) {
		String jpql = "select f from Flight f where f.patient.userId=:param";
		Query query = entitymanager.createQuery(jpql);
		query.setParameter("param", idPatient);
		return (Flight) query.getSingleResult();
	}

	@Override
	public Booking findBookingById(Integer idBooking) {
		return entitymanager.find(Booking.class, idBooking);
	}

	@Override
	public Booking findBookingByPatientId(Integer idPatient) {
		String jpql = "select b from Booking b where b.hotelBooking.patient.userId=:param";
		Query query = entitymanager.createQuery(jpql);
		query.setParameter("param", idPatient);
		return (Booking) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> findAllBookingsByFlightId(Integer id) {
		String jpql = "select b from Booking b where b.flight.id=:param";
		Query query = entitymanager.createQuery(jpql);
		query.setParameter("param", id);
		return query.getResultList();
	}

	@Override
	public Hotel findHotelByPatientId(Integer idPatient) {
		String jpql = "select h from Hotel h join h.hotelBookings hbs where hbs.patient.userId=:param";
		Query query = entitymanager.createQuery(jpql);
		query.setParameter("param", idPatient);
		return (Hotel) query.getSingleResult();

	}

	@Override
	public Clinic findClinicByPatientId(Integer idPatient) {
		String jpql = "select c from Clinic c join c.clinicBookings cbs where cbs.patient.userId=:param";
		Query query = entitymanager.createQuery(jpql);
		query.setParameter("param", idPatient);
		return (Clinic) query.getSingleResult();

	}

	@Override
	public Surgery findSurgeryByPatientId(Integer idPatient) {
		String jpql = "select p from User p join p. sps where sps.patient.userId=:param";
		Query query = entitymanager.createQuery(jpql);
		query.setParameter("param", idPatient);
		return (Surgery) query.getSingleResult();

	}

}
