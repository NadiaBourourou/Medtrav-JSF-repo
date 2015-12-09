package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.ServiceHotel;

@Remote
public interface ServiceHotelServicesRemote {

	Boolean addServiceHotel(ServiceHotel serviceHotel);

	void assignServiceHotelToHotel(ServiceHotel serviceHotel, Integer id);

	List<ServiceHotel> findAllServicesHotelByHotel(Integer id);

	List<ServiceHotel> findAllServicesHotel();

	Boolean updateServiceHotel(ServiceHotel serviceHotel);

	Boolean deleteServiceHotel(ServiceHotel serviceHotel);

	List<ServiceHotel> findHotelServiceByHotelName(String name);
}
