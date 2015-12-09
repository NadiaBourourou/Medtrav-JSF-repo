package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Booking
 *
 */
@Entity
@Table(name = "T_BOOKING")
public class Booking implements Serializable {

	private Integer bookingId;

	private StateBooking state;

	private Flight flight;
	private HotelBooking hotelBooking;
	private ClinicBooking clinicBooking;
	private SurgeryPatient surgeryPatient;
	private DoctorPatient doctorPatient;

	private static final long serialVersionUID = 1L;

	public Booking() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	@OneToOne(cascade=CascadeType.REMOVE)
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public StateBooking getState() {
		return state;
	}

	public void setState(StateBooking state) {
		this.state = state;
	}

	@OneToOne(cascade = CascadeType.REMOVE)
	public HotelBooking getHotelBooking() {
		return hotelBooking;
	}

	public void setHotelBooking(HotelBooking hotelBooking) {
		this.hotelBooking = hotelBooking;
	}

	@OneToOne(cascade = CascadeType.REMOVE)
	public ClinicBooking getClinicBooking() {
		return clinicBooking;
	}

	public void setClinicBooking(ClinicBooking clinicBooking) {
		this.clinicBooking = clinicBooking;
	}

	@OneToOne(cascade = CascadeType.REMOVE)
	public SurgeryPatient getSurgeryPatient() {
		return surgeryPatient;
	}

	public void setSurgeryPatient(SurgeryPatient surgeryPatient) {
		this.surgeryPatient = surgeryPatient;
	}

	@OneToOne(cascade = CascadeType.REMOVE)
	public DoctorPatient getDoctorPatient() {
		return doctorPatient;
	}

	public void setDoctorPatient(DoctorPatient doctorPatient) {
		this.doctorPatient = doctorPatient;
	}

}
