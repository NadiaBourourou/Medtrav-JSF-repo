package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ClinicBookingID implements Serializable  {
	
	private Integer clinicId;
	private Integer patientId;
	
	
	
	public ClinicBookingID() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ClinicBookingID(Integer clinicId, Integer patientId) {
		super();
		this.clinicId = clinicId;
		this.patientId = patientId;
	}



	public Integer getClinicId() {
		return clinicId;
	}



	public void setClinicId(Integer clinicId) {
		this.clinicId = clinicId;
	}



	public Integer getPatientId() {
		return patientId;
	}



	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((clinicId == null) ? 0 : clinicId.hashCode());
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
		ClinicBookingID other = (ClinicBookingID) obj;
		if (clinicId == null) {
			if (other.clinicId != null)
				return false;
		} else if (!clinicId.equals(other.clinicId))
			return false;
		if (patientId == null) {
			if (other.patientId != null)
				return false;
		} else if (!patientId.equals(other.patientId))
			return false;
		return true;
	}
	
	

}
