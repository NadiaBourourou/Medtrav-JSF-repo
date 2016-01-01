package services.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;

import services.interfaces.MedicalRecordsServicesLocal;
import services.interfaces.MedicalRecordsServicesRemote;
import entities.MedicalRecords;
import entities.Patient;

/**
 * Session Bean implementation class MedicalRecordsServices
 */
@Stateless
public class MedicalRecordsServices implements MedicalRecordsServicesRemote,
		MedicalRecordsServicesLocal {

	@PersistenceContext
	EntityManager entityManager;

	public MedicalRecordsServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addMedicalRecords(MedicalRecords medicalRecords) {
		Boolean b = false;
		try {

			entityManager.merge(medicalRecords);
			b = true;

		} catch (Exception e) {
			System.err.println("Error");
		}
		return b;
	}

	@Override
	public Boolean updateMedicalRecords(MedicalRecords medicalRecords) {
		Boolean b = false;
		try {

			entityManager.merge(medicalRecords);
			b = true;

		} catch (Exception e) {
			System.err.println("Error");
		}
		return b;
	}

	@Override
	public MedicalRecords findMedicalRecordsByPatientId(Integer patientId) {
		String jpql = "select m from MedicalRecords m where m.patient.userId=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", patientId);
		return (MedicalRecords) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> listAssignedPatientsToDoctor(Integer idDoctor) {
		String jpql = "select u from User u join u.doctorPatients dps where dps.doctor.userId=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", idDoctor);
		return query.getResultList();
	}

	@Override
	public Patient findPatientByFirstNameAndLastName(String FirstName,
			String LastName) {
		String jpql = "select p from Patient p where p.firstName=:param1 AND p.lastName=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", FirstName);
		query.setParameter("param2", LastName);
		return (Patient) query.getSingleResult();
	}

	@Override
	public byte[] downloadAnalysis(int id) {
		String jpql = "select m.analysis from MedicalRecords m where m.patient.userId=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", id);
		Object o = query.getSingleResult();
		byte[] tmpArray = (byte[]) o;
		return tmpArray;
	}

	@Override
	public byte[] downloadPatientFile(int id) {
		String jpql = "select m.patientFile from MedicalRecords m where m.patient.userId=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", id);
		Object o = query.getSingleResult();
		byte[] tmpArray = (byte[]) o;
		return tmpArray;
	}

	public void downloadPdf(int id) throws IOException {
	    // Get the FacesContext
        FacesContext facesContext = FacesContext.getCurrentInstance();
         
        // Get HTTP response
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
         
        // Set response headers
        response.reset();   // Reset the response in the first place
        response.setHeader("Content-Type", "application/pdf");  // Set only the content type
         
        // Open response output stream
        OutputStream responseOutputStream = response.getOutputStream();
         
        // Read PDF contents
        
        String jpql = "select m.patientFile from MedicalRecords m where m.patient.userId=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", id);
		Object o = query.getSingleResult();
		Blob tmpArray = (Blob) o;
        
         
        // Read PDF contents and write them to the output
        byte[] bytesBuffer = new byte[2048];
        int bytesRead;
        while ((bytesRead = ((FilterInputStream) tmpArray).read(bytesBuffer)) > 0) {
            responseOutputStream.write(bytesBuffer, 0, bytesRead);
        }
         
        // Make sure that everything is out
        responseOutputStream.flush();
          
        // Close both streams
  
        responseOutputStream.close();
         
        // JSF doc:
        // Signal the JavaServer Faces implementation that the HTTP response for this request has already been generated
        // (such as an HTTP redirect), and that the request processing lifecycle should be terminated
        // as soon as the current phase is completed.
        facesContext.responseComplete();


	}

}
