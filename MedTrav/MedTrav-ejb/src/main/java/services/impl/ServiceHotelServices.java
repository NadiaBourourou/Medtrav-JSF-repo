package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.ServiceHotelServicesLocal;
import services.interfaces.ServiceHotelServicesRemote;
import entities.Hotel;
import entities.ServiceHotel;

/**
 * Session Bean implementation class ServiceHotelServices
 */
@Stateless
public class ServiceHotelServices implements ServiceHotelServicesRemote,
		ServiceHotelServicesLocal {
	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ServiceHotelServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addServiceHotel(ServiceHotel serviceHotel) {
		Boolean b = false;
		try {
			entityManager.persist(serviceHotel);
			b = true;
		} catch (Exception e) {
			System.err.println("error");
		}
		return b;
	}

	@Override
	public void assignServiceHotelToHotel(ServiceHotel serviceHotel, Integer id) {
		try {
			Hotel hotel = entityManager.find(Hotel.class, id);
			serviceHotel.setHotel(hotel);
			entityManager.merge(serviceHotel);
		} catch (Exception e) {
			System.err.println("error");
		}

	}

	@Override
	public List<ServiceHotel> findAllServicesHotelByHotel(Integer id) {
		String jpql = "select b from ServiceHotel b where b.hotel.hotelId=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", id);
		return query.getResultList();
	}

	@Override
	public List<ServiceHotel> findAllServicesHotel() {
		String jpql = "select b from ServiceHotel b";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Boolean updateServiceHotel(ServiceHotel serviceHotel) {
		Boolean b = false;
		try {
			entityManager.merge(serviceHotel);
			b = true;
		} catch (Exception e) {
			System.err.println("error");

		}
		return b;
	}

	@Override
	public Boolean deleteServiceHotel(ServiceHotel serviceHotel) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(serviceHotel));
			b = true;

		} catch (Exception e) {
			System.err.println("error");
		}
		return b;
	}

	@Override
	public List<ServiceHotel> findHotelServiceByHotelName(String name) {
		String jpql = "select b from ServiceHotel b where b.hotel.name LIKE :param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", "%" + name + "%");
		return query.getResultList();

	}

}
