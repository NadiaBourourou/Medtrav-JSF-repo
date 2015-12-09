package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Entity implementation class for Entity: SurgeryPatientID
 *
 */
@Embeddable
public class SurgeryPatientID implements Serializable {

	private Integer idPatient;
	private Integer idSurgery;
	private static final long serialVersionUID = 1L;

	public SurgeryPatientID() {
		super();
	}

	public SurgeryPatientID(Integer idPatient, Integer idSurgery) {
		super();
		this.idPatient = idPatient;
		this.idSurgery = idSurgery;
	}

	public Integer getIdPatient() {
		return this.idPatient;
	}

	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}

	public Integer getIdSurgery() {
		return this.idSurgery;
	}

	public void setIdSurgery(Integer idSurgery) {
		this.idSurgery = idSurgery;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPatient == null) ? 0 : idPatient.hashCode());
		result = prime * result
				+ ((idSurgery == null) ? 0 : idSurgery.hashCode());
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
		SurgeryPatientID other = (SurgeryPatientID) obj;
		if (idPatient == null) {
			if (other.idPatient != null)
				return false;
		} else if (!idPatient.equals(other.idPatient))
			return false;
		if (idSurgery == null) {
			if (other.idSurgery != null)
				return false;
		} else if (!idSurgery.equals(other.idSurgery))
			return false;
		return true;
	}

}
