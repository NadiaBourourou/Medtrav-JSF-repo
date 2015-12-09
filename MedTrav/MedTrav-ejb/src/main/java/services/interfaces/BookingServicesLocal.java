package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Booking;

@Local
public interface BookingServicesLocal {
	Boolean addBooking(Booking booking);

	Boolean updateBooking(Booking booking);

	Boolean deleteBooking(Booking booking);

	List<Booking> findAllBookingsByPatient(Integer patientId);

	Booking findBookingById(Integer idBooking);

	List<Booking> findAllBookingsByFlightId(Integer id);
}