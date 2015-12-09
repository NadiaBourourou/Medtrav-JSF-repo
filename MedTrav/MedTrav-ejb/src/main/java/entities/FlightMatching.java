package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: FlightMatching
 *
 */
@Entity
@Table(name = "T_FLIGHTMATCHING")
public class FlightMatching implements Serializable {

	private Integer idFlightMatching;
	private String numFlight;
	private String departure;
	private String arrival;
	private String dateFlightMatchingDep;
	private String dateFlightMatchingArr;
	private String timeFlightMatchingDep;
	private String timeFlightMatchingArr;
	private String airline;
	private Integer numberOfSits;
	private Double price;
	private static final long serialVersionUID = 1L;

	public FlightMatching() {
		super();
	}

	public FlightMatching(String numFlight, String departure, String arrival,
			String dateFlightMatchingDep, String dateFlightMatchingArr,
			String timeFlightMatchingDep, String timeFlightMatchingArr,
			String airline, Integer numberOfSits, Double price) {
		super();
		this.numFlight = numFlight;
		this.departure = departure;
		this.arrival = arrival;
		this.dateFlightMatchingDep = dateFlightMatchingDep;
		this.dateFlightMatchingArr = dateFlightMatchingArr;
		this.timeFlightMatchingDep = timeFlightMatchingDep;
		this.timeFlightMatchingArr = timeFlightMatchingArr;
		this.airline = airline;
		this.numberOfSits = numberOfSits;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdFlightMatching() {
		return this.idFlightMatching;
	}

	public void setIdFlightMatching(Integer idFlightMatching) {
		this.idFlightMatching = idFlightMatching;
	}

	public String getNumFlight() {
		return this.numFlight;
	}

	public void setNumFlight(String numFlight) {
		this.numFlight = numFlight;
	}

	public String getDeparture() {
		return this.departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return this.arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDateFlightMatchingDep() {
		return this.dateFlightMatchingDep;
	}

	public void setDateFlightMatchingDep(String dateFlightMatchingDep) {
		this.dateFlightMatchingDep = dateFlightMatchingDep;
	}

	public String getAirline() {
		return this.airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public Integer getNumberOfSits() {
		return this.numberOfSits;
	}

	public void setNumberOfSits(Integer numberOfSits) {
		this.numberOfSits = numberOfSits;
	}

	public String getDateFlightMatchingArr() {
		return dateFlightMatchingArr;
	}

	public void setDateFlightMatchingArr(String dateFlightMatchingArr) {
		this.dateFlightMatchingArr = dateFlightMatchingArr;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

}
