package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Clinic
 *
 */
@Entity
@Table(name="T_CLINIC")
public class Clinic implements Serializable {

	
	private Integer clinicId;
	private String name;
	private String address;
	private String professionalism;
	private Integer phoneNumber;
	private String email;
	private Double priceSimple;
	private Double priceSingle;
	private List<ClinicBooking> clinicBookings;
	
	private static final long serialVersionUID = 1L;

	public Clinic() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getClinicId() {
		return this.clinicId;
	}

	public void setClinicId(Integer clinicId) {
		this.clinicId = clinicId;
	}   
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public String getProfessionalism() {
		return this.professionalism;
	}

	public void setProfessionalism(String professionalism) {
		this.professionalism = professionalism;
	}   
	public Integer getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public Double getPriceSimple() {
		return priceSimple;
	}
	public void setPriceSimple(Double priceSimple) {
		this.priceSimple = priceSimple;
	}
	public Double getPriceSingle() {
		return priceSingle;
	}
	public void setPriceSingle(Double priceSingle) {
		this.priceSingle = priceSingle;
	}

	@OneToMany(mappedBy="clinic")
	public List<ClinicBooking> getClinicBookings() {
		return clinicBookings;
	}
	public void setClinicBookings(List<ClinicBooking> clinicBookings) {
		this.clinicBookings = clinicBookings;
	}
	
   
}
