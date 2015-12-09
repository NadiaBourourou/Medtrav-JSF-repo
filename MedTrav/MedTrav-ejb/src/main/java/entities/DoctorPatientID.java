package entities;

import java.io.Serializable;
import java.lang.Integer;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: DoctorPatient
 *
 */
@Embeddable

public class DoctorPatientID implements Serializable {

	
	private Integer patientId;
	private Integer doctorId;
	private static final long serialVersionUID = 1L;

	public DoctorPatientID() {
		super();
	}   
	public Integer getPatientId() {
		return this.patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}   
	public Integer getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((doctorId == null) ? 0 : doctorId.hashCode());
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
		DoctorPatientID other = (DoctorPatientID) obj;
		if (doctorId == null) {
			if (other.doctorId != null)
				return false;
		} else if (!doctorId.equals(other.doctorId))
			return false;
		if (patientId == null) {
			if (other.patientId != null)
				return false;
		} else if (!patientId.equals(other.patientId))
			return false;
		return true;
	}
	public DoctorPatientID(Integer patientId, Integer doctorId) {
		super();
		this.patientId = patientId;
		this.doctorId = doctorId;
	}
   
	
}
