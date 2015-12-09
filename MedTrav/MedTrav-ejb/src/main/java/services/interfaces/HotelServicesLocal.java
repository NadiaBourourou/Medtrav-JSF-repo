package services.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import entities.Hotel;
import entities.HotelBooking;
import entities.RoomType;

@Local
public interface HotelServicesLocal {

	Boolean addHotel(Hotel hotel);

	Boolean deleteHotelById(Integer id);

	Hotel findHotelById(Integer id);

	List<Hotel> findHotelByName(String name);

	Boolean updateHotel(Hotel hotel);

	Boolean deleteHotel(Hotel hotel);

	List<Hotel> findAllHotels();

	List<Hotel> findAllHotelsEnabled();

	Double calculPrix(Double prix, Integer numNights);

	Boolean addHotelBooking(HotelBooking hotelBooking);

	Hotel findHotelByPatientId(Integer idPatient);

	Boolean bookHotel(Integer numNights, Double price, RoomType roomType,
			Date date, Hotel hotel, Integer idPatient);

	List<Hotel> findHotelsByStars(Integer stars);
}
