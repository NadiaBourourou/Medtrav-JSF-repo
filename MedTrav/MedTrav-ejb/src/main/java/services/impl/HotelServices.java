package services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.HotelServicesLocal;
import services.interfaces.HotelServicesRemote;
import entities.Hotel;
import entities.HotelBooking;
import entities.Patient;
import entities.RoomType;
import entities.StateType;

/**
 * Session Bean implementation class HotelServices
 */
@Stateless
public class HotelServices implements HotelServicesRemote, HotelServicesLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public HotelServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addHotel(Hotel hotel) {
		Boolean b = false;
		try {
			entityManager.persist(hotel);
			b = true;
		} catch (Exception e) {
			System.err.println("erreur");
		}
		return b;
	}

	@Override
	public Boolean deleteHotelById(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(findHotelById(id));
			b = true;
		} catch (Exception e) {
			System.err.println("error");

		}
		return b;
	}

	@Override
	public Hotel findHotelById(Integer id) {
		return entityManager.find(Hotel.class, id);
	}

	@Override
	public Boolean updateHotel(Hotel hotel) {
		Boolean b = false;
		try {
			entityManager.merge(hotel);
			b = true;
		} catch (Exception e) {
			System.err.println("error");
		}
		return b;
	}

	@Override
	public Boolean deleteHotel(Hotel hotel) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(hotel));
			b = true;

		} catch (Exception e) {
			System.err.println("error");
		}
		return b;
	}

	@Override
	public List<Hotel> findAllHotels() {
		String jpql = "select h from Hotel h";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<Hotel> findHotelByName(String name) {
		String jpql = "select h from Hotel h where h.name LIKE :param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", "%" + name + "%");
		return query.getResultList();

	}

	@Override
	public List<Hotel> findAllHotelsEnabled() {
		String jpql = "select u from Hotel u where u.state=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", StateType.ENABLED);
		return query.getResultList();
	}

	@Override
	public Double calculPrix(Double prix, Integer numNights) {

		return prix * numNights;
	}

	@Override
	public Boolean addHotelBooking(HotelBooking hotelBooking) {
		Boolean b = false;
		try {
			entityManager.merge(hotelBooking);

			b = true;
		} catch (Exception e) {
			System.err.println("error");
		}
		return b;
	}

	@Override
	public Hotel findHotelByPatientId(Integer idPatient) {
		String jpql = "select h from Hotel h join h.hotelBookings hbs where hbs.patient.userId=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", idPatient);
		return (Hotel) query.getSingleResult();

	}

	@Override
	public Boolean bookHotel(Integer numNights, Double price,
			RoomType roomType, Date date, Hotel hotel, Integer idPatient) {
		Boolean b = false;
		try {
			Patient patient = entityManager.find(Patient.class, idPatient);
			HotelBooking hotelBooking = new HotelBooking(numNights, price,
					roomType, date, hotel, patient);
			entityManager.merge(hotelBooking);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public List<Hotel> findHotelsByStars(Integer stars) {
		String jpql = "select u from Hotel u where u.stars=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", stars);
		return query.getResultList();
	}

}
