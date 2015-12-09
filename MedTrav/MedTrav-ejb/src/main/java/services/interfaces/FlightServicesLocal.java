package services.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import entities.Flight;
import entities.FlightMatching;

@Local
public interface FlightServicesLocal {

	Boolean addFlight(Flight flight);

	Boolean updateFlight(Flight flight);

	Boolean deleteFlight(Flight flight);

	List<Flight> findAllFlightsByPatientId(Integer patientId);

	Flight findFlightById(Integer idFlight);
		
	List<FlightMatching> findFlightsByAirline(String airline);
	
	Boolean assignFlightToBooking(Integer idBooking,Integer idFlight);
	//Boolean assignFlightToBookingSlaveSide(Integer idBooking,Integer idFlight);
	
	Boolean assignDoctorToSurgery(Integer idSurgery,Integer idDoctor);
	Boolean assignDoctorToSurgerySlaveSide(Integer idSurgery,Integer idDoctor);
/*			
	Boolean assignMedicalRecordToSurgery(Integer idSurgery,Integer idMedicalRecord);
	Boolean assignMedicalRecordToSurgerySlaveSide(Integer idSurgery,Integer idMedicalRecord);
*/	
	List<FlightMatching> findAllDepartures();
	List <FlightMatching > findAllArrivals();

	List <FlightMatching > findMatchingFlight(String departure,String arrival,String departureDate,String arrivalDate);
	
	List<Flight> findAllFlight();

	FlightMatching findFlightMatchingByNumFlight(String numFlight);
	
	FlightMatching findFlightMatchingById(Integer idFmatching);
	
	//Boolean updateNbSits(Integer nbSitsMaj,Integer idFlight);

	Boolean updateNbSits(FlightMatching flightMatch);
	
	List<FlightMatching> findMatchingFlightWithThatFromAndTo(String fromMatching, String toMatching);
	
	List<FlightMatching> findAllFlightMatching();
	
	List<String> findAllDepaturesSansDoublons();
	
	List<String> findAllDepaturesOfOurPatients();
	
	List<FlightMatching> findFlightByDepartureLocation(String searchDep);
	
	List<FlightMatching> findFlightByArrivalLocation(String searchArr);

	List<FlightMatching> findFlightByAirline(String searchAirline);
	
	long mostWorkingAirlines(String airlineGiven);
	
	List<String> findAllAirlines();

	
}
