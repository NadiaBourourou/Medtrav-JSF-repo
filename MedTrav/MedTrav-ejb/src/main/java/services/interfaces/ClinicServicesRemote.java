package services.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entities.Clinic;
import entities.ClinicBooking;
import entities.RoomClinicType;

@Remote
public interface ClinicServicesRemote {

	Boolean addClinic(Clinic clinic);

	Boolean deleteClinicById(Integer id);

	Clinic findClinicById(Integer id);

	Boolean updateClinic(Clinic clinic);

	Boolean deleteClinic(Clinic clinic);

	List<Clinic> findAllClinics();

	List<Clinic> findClinicByName(String name);

	Boolean addClinicBookingAndAffectClinic(ClinicBooking clinicBooking,
			Integer id);

	Boolean bookClinic(RoomClinicType typeRoom, Date date, String commentaire,
			Clinic clinic, Integer idPatient);
}
