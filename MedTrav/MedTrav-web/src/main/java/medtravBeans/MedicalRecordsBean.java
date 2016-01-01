package medtravBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import services.interfaces.MedicalRecordsServicesLocal;
import services.interfaces.UserServicesLocal;
import entities.MedicalRecords;
import entities.Patient;

@ManagedBean
@SessionScoped
public class MedicalRecordsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MedicalRecords medicalRecords;
	private List<Patient> patients;
	private Patient patient;
	private UploadedFile file;
	private StreamedContent fileD;

	@EJB
	MedicalRecordsServicesLocal medicalRecordsServicesLocal;
	@EJB
	UserServicesLocal userServicesLocal;

	@PostConstruct
	public void init() {

		setMedicalRecords(new MedicalRecords());
		setPatient(new Patient());
		patients = medicalRecordsServicesLocal.listAssignedPatientsToDoctor(4);

	}

	public void doAddMedicalRecords(FileUploadEvent event) {
		FacesMessage message = new FacesMessage("Succesful", event.getFile()
				.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);
		String fileName = event.getFile().getFileName();
		String contentType = event.getFile().getContentType();
		byte[] contents = event.getFile().getContents();

		patient.setUserId(2);

		medicalRecords.setPatient(patient);
		medicalRecords.setAnalysis(contents);
		medicalRecordsServicesLocal.addMedicalRecords(medicalRecords);

	}

	public void doUpdateMedicalRecords(FileUploadEvent event) {
		FacesMessage message = new FacesMessage("Succesful", event.getFile()
				.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);
		byte[] contents = event.getFile().getContents();
		patient.setUserId(1);
		medicalRecords.setPatient(patient);
		medicalRecords.setPatientFile(contents);

		medicalRecordsServicesLocal.updateMedicalRecords(medicalRecords);

	}

	public void doDownloadAnalysis(int id) throws IOException {
		   String filename = "GU30282.pdf";
		byte[] analysis = medicalRecordsServicesLocal.downloadAnalysis(2);
		FacesContext faces = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) faces
				.getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setContentLength(analysis.length);
		response.setHeader("Content-disposition", "inline;  filename=\""+filename+"\"");
		try {
			ServletOutputStream out;
			out = response.getOutputStream();
			out.write(analysis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		faces.responseComplete();
		System.out.println(id);
	}

	public entities.MedicalRecords getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(entities.MedicalRecords medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public StreamedContent getFileD() {
		return fileD;
	}

	public void setFileD(StreamedContent fileD) {
		this.fileD = fileD;
	}

}
