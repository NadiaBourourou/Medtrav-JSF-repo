package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class HotelBookingID implements Serializable {

	private Integer hotelId;
	private Integer patientId;
	
	
	
	public HotelBookingID() {
		super();
	}



	public HotelBookingID(Integer hotelId, Integer patientId) {
		super();
		this.hotelId = hotelId;
		this.patientId = patientId;
	}



	public Integer gethotelId() {
		return hotelId;
	}



	public void sethotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}



	public Integer getpatientId() {
		return patientId;
	}



	public void setpatientId(Integer patientId) {
		this.patientId = patientId;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hotelId == null) ? 0 : hotelId.hashCode());
		result = prime * result
				+ ((patientId == null) ? 0 : patientId.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelBookingID other = (HotelBookingID) obj;
		if (hotelId == null) {
			if (other.hotelId != null)
				return false;
		} else if (!hotelId.equals(other.hotelId))
			return false;
		if (patientId == null) {
			if (other.patientId != null)
				return false;
		} else if (!patientId.equals(other.patientId))
			return false;
		return true;
	}



}
