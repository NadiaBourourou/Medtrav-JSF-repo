package medtravBeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.print.Doc;

import services.interfaces.BookingServicesLocal;
import entities.Booking;
import entities.Clinic;
import entities.ClinicBooking;
import entities.Doctor;
import entities.DoctorPatient;
import entities.Flight;
import entities.Hotel;
import entities.HotelBooking;
import entities.MedicalRecords;
import entities.Patient;
import entities.Surgery;
import entities.SurgeryPatient;


@ManagedBean
@SessionScoped
public class BookingBean {
	
	private Booking booking;
	private ClinicBooking clinicBooking;
	private Clinic clinic;
	private HotelBooking hotelBooking;
	private Hotel hotel;
	private Flight flight;
	private SurgeryPatient surgeryPatient;
	private Surgery surgery;
	private DoctorPatient doctorPatient;
	private Doctor doctor;
	
	@EJB
	BookingServicesLocal bookingServicesLocal;
	
	@PostConstruct
	public void init() {

		setBooking(new Booking ());
		setClinicBooking(new ClinicBooking());
		setHotelBooking(new HotelBooking());
		setFlight(new Flight());
		setSurgeryPatient(new SurgeryPatient());
		setDoctorPatient(new DoctorPatient());
		setHotel(new Hotel());
		setClinic(new Clinic());
		setSurgery(new Surgery());
		setDoctor(new Doctor());
		
	}
	
	public void doShowBooking () {
		clinicBooking = bookingServicesLocal.findClinicBookingByPatientId(1);
		clinic = clinicBooking.getClinic();
		hotelBooking = bookingServicesLocal.findHotelBookingByPatientId(1);
		hotel = hotelBooking.getHotel();
		surgeryPatient = bookingServicesLocal.findSurgeryPatientByPatientId(1);
		surgery = surgeryPatient.getSurgery();
		doctorPatient = bookingServicesLocal.findDoctorPatientByPatientId(1);
		doctor = doctorPatient.getDoctor();
		flight = bookingServicesLocal.findFlightByPatientId(1);		
	}
	
	public void doAddBooking() {
		clinicBooking = bookingServicesLocal.findClinicBookingByPatientId(1);
		clinic = clinicBooking.getClinic();
		hotelBooking = bookingServicesLocal.findHotelBookingByPatientId(1);
		hotel = hotelBooking.getHotel();
		surgeryPatient = bookingServicesLocal.findSurgeryPatientByPatientId(1);
		surgery = surgeryPatient.getSurgery();
		doctorPatient = bookingServicesLocal.findDoctorPatientByPatientId(1);
		doctor = doctorPatient.getDoctor();
		flight = bookingServicesLocal.findFlightByPatientId(1);	
		
		booking.setHotelBooking(hotelBooking);
		booking.setClinicBooking(clinicBooking);
		booking.setSurgeryPatient(surgeryPatient);
		booking.setDoctorPatient(doctorPatient);
		booking.setFlight(flight);
		
		bookingServicesLocal.addBooking(booking);
		
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public ClinicBooking getClinicBooking() {
		return clinicBooking;
	}

	public void setClinicBooking(ClinicBooking clinicBooking) {
		this.clinicBooking = clinicBooking;
	}

	public HotelBooking getHotelBooking() {
		return hotelBooking;
	}

	public void setHotelBooking(HotelBooking hotelBooking) {
		this.hotelBooking = hotelBooking;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public SurgeryPatient getSurgeryPatient() {
		return surgeryPatient;
	}

	public void setSurgeryPatient(SurgeryPatient surgeryPatient) {
		this.surgeryPatient = surgeryPatient;
	}

	public DoctorPatient getDoctorPatient() {
		return doctorPatient;
	}

	public void setDoctorPatient(DoctorPatient doctorPatient) {
		this.doctorPatient = doctorPatient;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Surgery getSurgery() {
		return surgery;
	}

	public void setSurgery(Surgery surgery) {
		this.surgery = surgery;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	

}
