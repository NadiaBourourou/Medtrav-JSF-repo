package entities;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Flight
 *
 */
@Entity
@Table(name="T_FLIGHT")
public class Flight implements Serializable {

	
	private Integer flightId;
	private String numFlight;
	private String departureDate;
	private String arrivalDate;
	private String departureLocation;
	private String arrivalLocation;
	private String timeFlightMatchingDep;
	private String timeFlightMatchingArr;
	private Double price;
	private String airline;
	private Integer nbSits;
	


	private Booking booking;

	private Patient patient;
	
	private static final long serialVersionUID = 1L;

	public Flight() {
		super();
	}   
	
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getFlightId() {
		return this.flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}   
	public String getDepartureDate() {
		return this.departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}   
	public String getArrivalDate() {
		return this.arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}   
	public String getDepartureLocation() {
		return this.departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}   
	public String getArrivalLocation() {
		return this.arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}   
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@OneToOne(mappedBy = "flight")
	public Booking getBookings() {
		return booking;

	}


	public void setBookings(Booking booking) {
		this.booking = booking;

	}

	
	public String getAirline() {
		return airline;
	}
	
	public void setAirline(String airline) {
		this.airline = airline;
	}


	/*public void linkBookingsToThisFlight(List<Booking bookings) {
>>>>>>> branch 'master' of https://github.com/NadiaBourourou/medtrav-repo.git
		this.bookings = bookings;
		for (Booking b : bookings) {
			b.setFlight(this);
		}
	}*/

	@ManyToOne
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}



	public Integer getNbSits() {
		return nbSits;
	}



	public void setNbSits(Integer nbSits) {
		this.nbSits = nbSits;
	}

	public String getTimeFlightMatchingDep() {
		return timeFlightMatchingDep;
	}

	public void setTimeFlightMatchingDep(String timeFlightMatchingDep) {
		this.timeFlightMatchingDep = timeFlightMatchingDep;
	}

	public String getTimeFlightMatchingArr() {
		return timeFlightMatchingArr;
	}

	public void setTimeFlightMatchingArr(String timeFlightMatchingArr) {
		this.timeFlightMatchingArr = timeFlightMatchingArr;
	}

	public String getNumFlight() {
		return numFlight;
	}

	public void setNumFlight(String numFlight) {
		this.numFlight = numFlight;
	}
   
}
