package entities;

import entities.Hotel;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ServiceHotel
 *
 */
@Entity

public class ServiceHotel implements Serializable {

	
	private Integer serviceHotelId;
	private String name;
	private String description;
	private Hotel hotel;
	private static final long serialVersionUID = 1L;

	public ServiceHotel() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getServiceHotelId() {
		return this.serviceHotelId;
	}

	public void setServiceHotelId(Integer serviceHotelId) {
		this.serviceHotelId = serviceHotelId;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	@ManyToOne
	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
   
}
