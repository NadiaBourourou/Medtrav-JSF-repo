package entities;

import java.io.File;
import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: MedicalRecords
 *
 */
@Entity
@Table(name = "T_MEDICALRECORDS")
public class MedicalRecords implements Serializable {

	private Integer medicalRecordsId;
	private byte[] analysis;
	private byte[] patientFile;
	private static final long serialVersionUID = 1L;

	private Patient patient;

	public MedicalRecords() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getMedicalRecordsId() {
		return this.medicalRecordsId;
	}

	public void setMedicalRecordsId(Integer MedicalRecordsId) {
		this.medicalRecordsId = MedicalRecordsId;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)
	public byte[] getAnalysis() {
		return this.analysis;
	}

	public void setAnalysis(byte[] analysis) {
		this.analysis = analysis;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)
	public byte[] getPatientFile() {
		return this.patientFile;
	}

	public void setPatientFile(byte[] patientFile) {
		this.patientFile = patientFile;
	}

	@OneToOne
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
