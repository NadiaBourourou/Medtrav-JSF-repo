package entities;

import java.io.File;
import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Hotel
 *
 */
@Entity
@Table(name = "T_HOTEL")
public class Hotel implements Serializable {

	private Integer hotelId;
	private String name;
	private String description;
	private String address;
	private StateType state;
	private Double priceSingle;
	private Double priceSuite;
	private Integer stars;
	private List<ServiceHotel> servicesHotel;
	
	private List<HotelBooking> hotelBookings;

	private static final long serialVersionUID = 1L;

	public Hotel() {
		super();
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public StateType getState() {
		return state;
	}

	public void setState(StateType state) {
		this.state = state;
	}

	public Double getPriceSingle() {
		return priceSingle;
	}

	public void setPriceSingle(Double priceSingle) {
		this.priceSingle = priceSingle;
	}

	public Double getPriceSuite() {
		return priceSuite;
	}

	public void setPriceSuite(Double priceSuite) {
		this.priceSuite = priceSuite;
	}

	public Integer getStars() {
		return this.stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}


	@OneToMany(mappedBy = "hotel", cascade = CascadeType.MERGE)
	public List<HotelBooking> getHotelBookings() {
		return hotelBookings;
	}

	public void setHotelBookings(List<HotelBooking> hotelBookings) {
		this.hotelBookings = hotelBookings;
	}

	@OneToMany(mappedBy = "hotel")
	public List<ServiceHotel> getServicesHotel() {
		return servicesHotel;
	}

	public void setServicesHotel(List<ServiceHotel> servicesHotel) {
		this.servicesHotel = servicesHotel;
	}

}
