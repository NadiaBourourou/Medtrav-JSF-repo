package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Booking;
import entities.Clinic;
import entities.ClinicBooking;
import entities.DoctorPatient;
import entities.Flight;
import entities.Hotel;
import entities.HotelBooking;
import entities.Surgery;
import entities.SurgeryPatient;

@Local
public interface BookingServicesLocal {
	Boolean addBooking(Booking booking);

	Boolean updateBooking(Booking booking);

	Boolean deleteBooking(Booking booking);

	List<Booking> findAllBookingsByPatient(Integer patientId);

	Booking findBookingById(Integer idBooking);

	List<Booking> findAllBookingsByFlightId(Integer id);

	Hotel findHotelByPatientId(Integer idPatient);

	Clinic findClinicByPatientId(Integer idPatient);

	Booking findBookingByPatientId(Integer idPatient);

	Boolean deleteBookingByPatientId(Booking booking);

	HotelBooking findHotelBookingByPatientId(Integer idPatient);

	Surgery findSurgeryByPatientId(Integer idPatient);

	ClinicBooking findClinicBookingByPatientId(Integer idPatient);

	SurgeryPatient findSurgeryPatientByPatientId(Integer idPatient);

	DoctorPatient findDoctorPatientByPatientId(Integer idPatient);

	Flight findFlightByPatientId(Integer idPatient);
}