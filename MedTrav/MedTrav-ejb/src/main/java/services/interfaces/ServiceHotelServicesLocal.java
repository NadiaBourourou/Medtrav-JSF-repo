package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.ServiceHotel;

@Local
public interface ServiceHotelServicesLocal {

	Boolean addServiceHotel(ServiceHotel serviceHotel);

	void assignServiceHotelToHotel(ServiceHotel serviceHotel, Integer id);

	List<ServiceHotel> findAllServicesHotelByHotel(Integer id);

	List<ServiceHotel> findAllServicesHotel();

	Boolean updateServiceHotel(ServiceHotel serviceHotel);

	Boolean deleteServiceHotel(ServiceHotel serviceHotel);

	List<ServiceHotel> findHotelServiceByHotelName(String name);
}
