package services.utilities;

import java.sql.Date;
import java.text.ParseException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.AssignedPatientsServicesLocal;
import services.interfaces.ServiceHotelServicesLocal;
import services.interfaces.SurgeryServicesLocal;
import services.interfaces.TestimonyServicesLocal;
import services.interfaces.UserServicesLocal;
import entities.Administrator;
import entities.Clinic;
import entities.Doctor;
import entities.FlightMatching;
import entities.Hotel;
import entities.Patient;
import entities.Procedure;
import entities.Question;
import entities.RoleType;
import entities.ServiceHotel;
import entities.StateType;
import entities.Surgery;
import entities.Testimony;
import entities.UserSexe;

/**
 * Session Bean implementation class PopulateDb
 */
@Singleton
@LocalBean
@Startup
public class PopulateDb {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@EJB
	private SurgeryServicesLocal surgeryServicesLocal;
	@EJB
	private ServiceHotelServicesLocal serviceHotelServicesLocal;
	@EJB
	private AssignedPatientsServicesLocal assignedPatientsServicesLocal;
	@EJB 
	private UserServicesLocal userServicesLocal;
	@EJB
	private TestimonyServicesLocal testimonyServicesLocal;

	public PopulateDb() {
	}

	@PostConstruct
	public void initDb() throws ParseException {

		FlightMatching flight1 = new FlightMatching("AF1785",
				"Lyon - Lyon-Saint-Exup�ry (LYS)",
				"Djerba - Djerba�Zarzis International Airport (DJE)",
				"16-11-2015", "17-11-2015", "15:00:00", "17:35:00",
				"AIRFRANCE", 7, 160D);
		entityManager.merge(flight1);

		FlightMatching flight27 = new FlightMatching("TU441",
				"Lyon - Lyon-Saint-Exup�ry (LYS)",
				"Djerba - Djerba�Zarzis International Airport (DJE)",
				"18-11-2015", "22-11-2015", "05:35:00", "09:30:00", "TUNISAIR",
				3, 140D);
		entityManager.merge(flight27);

		FlightMatching flight28 = new FlightMatching("UG002",
				"Lyon - Lyon-Saint-Exup�ry (LYS)",
				"Djerba - Djerba�Zarzis International Airport (DJE)",
				"25-11-2015", "01-12-2015", "09:00:00", "10:45:00",
				"TUNISAIR EXPRESS", 2, 110D);
		entityManager.merge(flight28);

		FlightMatching flight29 = new FlightMatching("BJ778",
				"Lyon - Lyon-Saint-Exup�ry (LYS)",
				"Djerba - Djerba�Zarzis International Airport (DJE)",
				"25-11-2015", "01-12-2015", "20:05:00", "21:40:00",
				"NOUVEL AIR TUNISIE", 4, 120D);
		entityManager.merge(flight29);

		FlightMatching flight2 = new FlightMatching("TU847",
				"Bruxelles - Brussels Airport (BRU)",
				"Tunis - Tunis-Carthage International Airport (TUN)",
				"17-11-2015", "18-11-2015", "05:35:00", "07:35:00", "TUNISAIR",
				8, 190D);
		entityManager.merge(flight2);
		FlightMatching flight3 = new FlightMatching(
				"BJ382",
				"Bordeaux - Bordeaux�M�rignac Airport (BOD)",
				"Monastir - Monastir Habib Bourguiba International Airport(MIR)",
				"18-11-2015", "19-11-2015", "07:30:00", "08:35:00",
				"NOUVEL AIR TUNISIE", 9, 140D);
		entityManager.merge(flight3);
		FlightMatching flight4 = new FlightMatching("8U451",
				"Tripoli - Tripoli International Airport (TIP)",
				"Djerba - Djerba�Zarzis International Airport (DJE)",
				"19-11-2015", "20-11-2015", "08:15:00", "09:00:00",
				"AFRIQIYAH AIRWAYS", 10, 130D);
		entityManager.merge(flight4);

		FlightMatching flight5 = new FlightMatching("UZ151",
				"Abidjan - Port Bouet Airport (ABJ)",
				"Sfax - Sfax�Thyna International Airport (SFA)", "20-11-2015",
				"21-11-2015", "09:20:00", "12:05:00", "BURAQ AIR", 4, 160D);
		entityManager.merge(flight5);
		FlightMatching flight6 = new FlightMatching("TU847",
				"Paris - Paris Charles-de-Gaulle (CDG)",
				"Tunis - Tunis-Carthage International Airport (TUN)",
				"21-11-2015", "23-11-2015", "10:30:00", "12:55:00",
				"TRANSAVIA", 15, 190D);
		entityManager.merge(flight6);
		FlightMatching flight7 = new FlightMatching("BJ382",
				"Malte - Malta International Airport (MLA)",
				"Tunis - Tunis-Carthage International Airport (TUN)",
				"19-11-2015", "20-11-2015", "11:40:00", "13:50:00",
				"AIR MALTA", 11, 140D);
		entityManager.merge(flight7);
		FlightMatching flight8 = new FlightMatching("8U451",
				"Casablanca - Mohammed V International Airport (CMN)",
				"Enfidha - Enfidha-Hammamet International Airport(NBE)",
				"23-11-2015", "24-11-2015", "08:00:00", "10:45:00",
				"ROYAL AIR MAROC", 7, 150D);
		entityManager.merge(flight8);

		FlightMatching flight9 = new FlightMatching("AZ867",
				"Rome - Leonardo da Vinci�Fiumicino Airport (FCO)",
				"Tunis - Tunis-Carthage International Airport (TUN)",
				"16-11-2015", "22-11-2015", "04:20:00", "06:20:00",
				"AIRFRANCE", 7, 200D);
		entityManager.merge(flight9);
		FlightMatching flight10 = new FlightMatching("LH1323",
				"Francfort - Frankfurt Airport (FRA)",
				"Djerba - Djerba�Zarzis International Airport (DJE)",
				"25-11-2015", "30-11-2015", "20:00:00", "22:35:00", "TUNISAIR",
				8, 250D);
		entityManager.merge(flight10);
		FlightMatching flight11 = new FlightMatching("MS844",
				"Le Caire - Cairo International Airport (CAI)",
				"Tunis - Tunis-Carthage International Airport (TUN)",
				"18-11-2015", "23-11-2015", "07:30:00", "09:05:00",
				"NOUVEL AIR TUNISIE", 9, 140D);
		entityManager.merge(flight11);
		FlightMatching flight12 = new FlightMatching("TK622",
				"Istanbul - A�roport Istanbul Ataturk (IST)",
				"Tunis - Tunis-Carthage International Airport (TUN)",
				"25-11-2015", "01-12-2015", "15:15:00", "16:40:00",
				"AFRIQIYAH AIRWAYS", 10, 130D);
		entityManager.merge(flight12);

		FlightMatching flight13 = new FlightMatching(
				"3V857",
				"Nice - Nice-C�te d'Azur (NCE)",
				"Monastir - Monastir Habib Bourguiba International Airport(MIR)",
				"17-11-2015", "22-11-2015", "16:35:00", "18:55:00", "TUNISAIR",
				8, 120D);
		entityManager.merge(flight13);
		FlightMatching flight14 = new FlightMatching("TJ118",
				"Marseille - Marseille Provence (MRS)",
				"Tunis - Tunis-Carthage International Airport (TUN)",
				"10-11-2015", "19-11-2015", "17:00:00", "18:40:00",
				"NOUVEL AIR TUNISIE", 9, 110D);
		entityManager.merge(flight14);
		FlightMatching flight15 = new FlightMatching("AH4001",
				"Alger - Houari Boumediene Airport (ALG)",
				"Tunis - Tunis-Carthage International Airport (TUN)",
				"19-11-2015", "20-11-2015", "13:15:00", "14:35:00",
				"AFRIQIYAH AIRWAYS", 10, 100D);
		entityManager.merge(flight15);
		FlightMatching flight16 = new FlightMatching("TU796",
				"Berlin - Berlin Brandenburg Airport (BER)",
				"Djerba - Djerba�Zarzis International Airport (DJE)",
				"15-11-2015", "22-11-2015", "07:45:00", "11:15:00", "TUNISAIR",
				8, 250D);
		entityManager.merge(flight16);

		FlightMatching flight17 = new FlightMatching("TU416",
				"Dakar - L�opold S�dar Senghor International Airport (DKR)",
				"Tabarka - Tabarka�Ain Draham International Airport (TBJ)",
				"02-12-2015", "04-12-2015", "21:20:00", "02:55:00", "TUNISAIR",
				8, 200D);
		entityManager.merge(flight17);
		FlightMatching flight18 = new FlightMatching("BT430",
				"Londres - A�roport de Londres Heathrow (LHR)",
				"Enfidha - Enfidha-Hammamet International Airport(NBE)",
				"27-11-2015", "5-12-2015", "19:40:00", "22:45:00",
				"NOUVEL AIR TUNISIE", 9, 300D);
		entityManager.merge(flight18);
		FlightMatching flight19 = new FlightMatching("TU606",
				"Madrid - Adolfo Su�rez Madrid�Barajas Airport (MAD)",
				"Tunis - Tunis-Carthage International Airport (TUN)",
				"26-11-2015", "02-12-2015", "16:00:00", "18:10:00",
				"AFRIQIYAH AIRWAYS", 10, 250D);
		entityManager.merge(flight19);
		FlightMatching flight20 = new FlightMatching("UG004",
				"Palerme - Falcone�Borsellino Airport (PMO)",
				"Djerba - Djerba�Zarzis International Airport (DJE)",
				"03-12-2015", "09-12-2015", "14:45:00", "15:45:00", "TUNISAIR",
				8, 220D);
		entityManager.merge(flight20);

		FlightMatching flight21 = new FlightMatching("TU021",
				"Belgrade - Belgrade Nikola Tesla (BEG)",
				"Tunis - Tunis-Carthage International Airport (TUN)",
				"06-12-2015", "12-12-2015", "11:00:00", "14:15:00", "TUNISAIR",
				8, 300D);
		entityManager.merge(flight21);
		FlightMatching flight22 = new FlightMatching("TR159",
				"Sarajevo - Sarajevo International Airport (SJJ)",
				"Sfax - Sfax�Thyna International Airport (SFA)", "14-11-2015",
				"21-11-2015", "06:00:00", "10:50:00", "TAROM", 8, 230D);//
		entityManager.merge(flight22);
		FlightMatching flight23 = new FlightMatching("TR601",
				"Bucarest  - A�roport international Henri Coanda (OTP)",
				"Tunis - Tunis-Carthage International Airport (TUN)",
				"22-11-2015", "25-11-2015", "15:05:35:00", "20:30:00",
				"RYANAIR", 8, 250D);
		entityManager.merge(flight23);
		FlightMatching flight24 = new FlightMatching(
				"MEA777",
				"Beyrouth - A�roport international de Beyrouth - Rafic Hariri",
				"Monastir - Monastir Habib Bourguiba International Airport(MIR)",
				"25-11-2015", "02-12-2015", "17:15:00", "20:45:00",
				"MIDDLE EAST AIRLINES", 8, 210D);
		entityManager.merge(flight24);

		FlightMatching flight25 = new FlightMatching("ZI898",
				"Paris - Paris Orly (ORY)",
				"Tunis - Tunis-Carthage International Airport (TUN)",
				"23-11-2015", "30-11-2015", "12:00:00", "14:25:00",
				"AIGLE AZUR", 8, 140D);
		entityManager.merge(flight25);
		FlightMatching flight26 = new FlightMatching("AF6423",
				"Toulouse - Toulouse Blagnac (TLS)",
				"Tunis - Tunis-Carthage International Airport (TUN)",
				"11-12-2015", "19-12-2015", "18:30:00", "20:20:00",
				"AIRFRANCE", 8, 170D);
		entityManager.merge(flight26);

		/* FLIGHTS */

		Patient patient1 = new Patient();
		patient1.setFirstName("Flen");
		patient1.setLastName("Foulen");
		patient1.setCin("14714750");
		patient1.setCountry("Spain");
		patient1.setDateOfBirth(Date.valueOf("1993-12-02"));
		patient1.setLogin("Flen.Foulena");
		patient1.setPassword("pwdFlen");
		patient1.setMail("flenfoulen@gmail.com");
		patient1.setNumPassport(96359);
		patient1.setRole(RoleType.PATIENT);
		patient1.setSexe(UserSexe.Female);

		Patient patient2 = new Patient();
		patient2.setFirstName("Sam");
		patient2.setLastName("Heinrich");
		patient2.setCin("1000634");
		patient2.setCountry("Germay");
		patient2.setDateOfBirth(Date.valueOf("1984-6-12"));
		patient2.setLogin("Sam.Heinrich");
		patient2.setPassword("pwdSam");
		patient2.setMail("SamHeinrich@gmail.com");
		patient2.setNumPassport(121214);
		patient2.setRole(RoleType.PATIENT);
		patient2.setSexe(UserSexe.Male);

		Doctor doctor1 = new Doctor();
		doctor1.setFirstName("Max");
		doctor1.setLastName("Hunter");
		doctor1.setCin("1940634");
		doctor1.setDescription("Specialiste des maladies cardio-vasculaires");
		doctor1.setLogin("Max.Hunter");
		doctor1.setPassword("pwdMax");
		doctor1.setMail("MaxHunter@gmail.com");
		doctor1.setSpecialty("CardioVasculaire");
		doctor1.setRole(RoleType.DOCTOR);
		doctor1.setSexe(UserSexe.Male);

		Doctor doctor2 = new Doctor();
		doctor2.setFirstName("Mehdi");
		doctor2.setLastName("Achek");
		doctor2.setCin("14756367");
		doctor2.setDescription("Anesthesiste, bloc operatoire");
		doctor2.setLogin("Achek");
		doctor2.setPassword("achek");
		doctor2.setMail("Mehdiachek@gmail.com");
		doctor2.setSpecialty("Botox, lifting, body lift");
		doctor2.setRole(RoleType.DOCTOR);
		doctor2.setSexe(UserSexe.Male);

		Administrator admin = new Administrator();
		admin.setFirstName("Sayed");
		admin.setLastName("El Moudir");
		admin.setLogin("Administrator");
		admin.setPassword("pwdAdmin");
		admin.setMail("admin@admin.net");
		admin.setCin("10203060");
		admin.setRole(RoleType.ADMINISTRATOR);

		Procedure procedure1 = new Procedure();
		procedure1.setName("Cosmetic and plastic surgery");

		Surgery Surgery1_1 = new Surgery();
		Surgery1_1.setDate(new java.util.Date());
		Surgery1_1.setName("Abdominoplasty");
		Surgery1_1
				.setDescription("Get rid of your belly, time for effortless kickass abs");
		Surgery1_1.setProcedure(procedure1);

		Surgery Surgery2_1 = new Surgery();
		Surgery2_1.setDate(new java.util.Date());
		Surgery2_1.setName("Body lift");
		Surgery2_1.setDescription("will see later on");

		Surgery Surgery3_1 = new Surgery();
		Surgery3_1.setDate(new java.util.Date());
		Surgery3_1.setName("Botox");
		Surgery3_1.setDescription("Say no to aging");

		Procedure procedure2 = new Procedure();

		procedure2.setName("Cardiology and cardiovascular surgery");

		Surgery Surgery1_2 = new Surgery();
		Surgery1_2.setDate(new java.util.Date());
		Surgery1_2.setName("Laser Surgery of bladder cancer");
		Surgery1_2
				.setDescription("Get rid of your belly, time for effortless kickass abs");
		Surgery1_2.setPrice((double) 2400);

		Surgery Surgery2_2 = new Surgery();
		Surgery2_2.setDate(new java.util.Date());
		Surgery2_2.setName("Venous stenting");
		Surgery2_2.setPrice((double) 3200);

		Surgery Surgery3_2 = new Surgery();
		Surgery3_2.setDate(new java.util.Date());
		Surgery3_2.setName("VATS");
		Surgery3_2.setDescription("Video assisted of thoracic surgery");
		Surgery3_2.setPrice((double) 5000);

		Procedure procedure3 = new Procedure();
		procedure3.setName("Urology");

		Surgery Surgery1_3 = new Surgery();
		Surgery1_3.setDate(new java.util.Date());
		Surgery1_3.setName("Laser Surgery of bladder cancer");
		Surgery1_3.setPrice((double) 7100);

		Surgery Surgery2_3 = new Surgery();
		Surgery2_3.setDate(new java.util.Date());
		Surgery2_3.setName("Vasectomy");
		Surgery2_3.setPrice((double) 700);

		entityManager.merge(patient1);
		entityManager.merge(patient2);
		entityManager.merge(doctor1);
		entityManager.merge(doctor2);
		entityManager.merge(admin);

		entityManager.merge(procedure1);
		entityManager.merge(procedure2);
		entityManager.merge(procedure3);

		surgeryServicesLocal.addSurgeryAndAssignItToProcedure(Surgery1_1, 1);
		surgeryServicesLocal.addSurgeryAndAssignItToProcedure(Surgery2_1, 1);
		surgeryServicesLocal.addSurgeryAndAssignItToProcedure(Surgery3_1, 1);
		surgeryServicesLocal.addSurgeryAndAssignItToProcedure(Surgery1_2, 2);
		surgeryServicesLocal.addSurgeryAndAssignItToProcedure(Surgery2_2, 2);
		surgeryServicesLocal.addSurgeryAndAssignItToProcedure(Surgery3_2, 2);
		surgeryServicesLocal.addSurgeryAndAssignItToProcedure(Surgery1_3, 3);
		surgeryServicesLocal.addSurgeryAndAssignItToProcedure(Surgery2_3, 3);
		
		// Hotel & Clinic
		
		  Hotel hotel1= new Hotel();
			hotel1.setName("Barcelo Carthage");
			hotel1.setAddress("Gammarth");
			hotel1.setDescription("Luxure");
			hotel1.setPriceSingle(100D);
			hotel1.setPriceSuite(150D);
			hotel1.setStars(5);
			hotel1.setState(StateType.ENABLED);
			
			

			Hotel hotel2= new Hotel();
			hotel2.setName("Movenpick");
			hotel2.setAddress("Gammarth");
			hotel2.setDescription("Comfortable");
			hotel2.setPriceSingle(140D);
			hotel2.setPriceSuite(200D);
			hotel2.setStars(5);
			hotel2.setState(StateType.ENABLED);
			
			Hotel hotel3= new Hotel();
			hotel3.setName("Concorde");
			hotel3.setAddress("Berges du Lac");
			hotel3.setDescription("Top");
			hotel3.setPriceSingle(130D);
			hotel3.setPriceSuite(160D);
			hotel3.setStars(4);
			hotel3.setState(StateType.DISABLED);
			
			
			Clinic clinic1= new Clinic();
			clinic1.setName("Pasteur");
			clinic1.setAddress("Charguia");
			clinic1.setProfessionalism("Excellent");
			clinic1.setEmail("pasteur@gmail.com");
			clinic1.setPhoneNumber(22899123);
			clinic1.setPriceSimple(60D);
			clinic1.setPriceSingle(100D);
			
			Clinic clinic2= new Clinic();
			clinic2.setName("Hannibal");
			clinic2.setAddress("Lac");
			clinic2.setProfessionalism("Good");
			clinic2.setEmail("hannibal@gmail.com");
			clinic2.setPhoneNumber(22123654);
			clinic2.setPriceSimple(70D);
			clinic2.setPriceSingle(120D);
			
			
			ServiceHotel serviceHotel1= new ServiceHotel();
			serviceHotel1.setName("Spa");
			serviceHotel1.setDescription("The opportunity to feel relaxed");
			

			ServiceHotel serviceHotel2= new ServiceHotel();
			serviceHotel2.setName("Fitness room");
			serviceHotel2.setDescription("So you can keep your habits...");

			ServiceHotel serviceHotel3= new ServiceHotel();
			serviceHotel3.setName("Babysitting Service");
			serviceHotel3.setDescription("Have more time for yourself");

			ServiceHotel serviceHotel4= new ServiceHotel();
			serviceHotel4.setName("Multiple dining options");
			serviceHotel4.setDescription("Learn more about our culture");
			

			ServiceHotel serviceHotel5= new ServiceHotel();
			serviceHotel5.setName("GOLF");
			serviceHotel5.setDescription("The grass is greener in our side");
			

			entityManager.merge(clinic1);
			entityManager.merge(clinic2);
			entityManager.merge(hotel1);
			entityManager.merge(hotel2);
			entityManager.merge(hotel3);
			
			serviceHotelServicesLocal.assignServiceHotelToHotel(serviceHotel1, 1);
			serviceHotelServicesLocal.assignServiceHotelToHotel(serviceHotel2, 1);
			serviceHotelServicesLocal.assignServiceHotelToHotel(serviceHotel3, 2);
			serviceHotelServicesLocal.assignServiceHotelToHotel(serviceHotel4, 2);
			serviceHotelServicesLocal.assignServiceHotelToHotel(serviceHotel5, 3);
			
			
			/*Hajer*/
		
			
		Patient monpatient1=testimonyServicesLocal.findPatientById(1);
		Patient monpatient2=testimonyServicesLocal.findPatientById(2);
		Doctor mondoctor1=userServicesLocal.findDoctorById(4);
		Surgery monsurgery1=testimonyServicesLocal.findSurgeryById(1);
		Surgery monsurgery2=testimonyServicesLocal.findSurgeryById(2);
		
			Testimony testimony1=new Testimony();
			testimony1.setDate(new java.util.Date());
			testimony1.setTitle("first medical travel");
			testimony1.setDescription("I was admitted after having an accident at a waterfall. Thank you for the wonderful treatment ");
			testimony1.setPatient(monpatient1);
			
			Testimony testimony2=new Testimony();
			testimony2.setDate(new java.util.Date());
			testimony2.setTitle("second medical travel");
			testimony2.setDescription("I just want to thank you for the treatment. ");
			testimony2.setPatient(monpatient1);
			
			
			Testimony testimony3=new Testimony();
			testimony3.setDate(new java.util.Date());
			testimony3.setTitle("bonjour");
			testimony3.setDescription("I am from France and I am really thankful for the treatment. ");
			testimony3.setPatient(monpatient2);
			
			Testimony testimony4=new Testimony();
			testimony4.setDate(new java.util.Date());
			testimony4.setTitle("foreign travel");
			testimony4.setDescription("Really it was good to see you and to have a treatment in tunisia. ");
			testimony4.setPatient(monpatient2);
			
			
			entityManager.merge(testimony1);
			entityManager.merge(testimony2);
			entityManager.merge(testimony3);
			entityManager.merge(testimony4);
	
			
			Question question1=new Question();
			question1.setDate(new java.util.Date());
			question1.setTitle("travel answered");
			question1.setDescription("why does people travel abroad for treatment?");
			question1.setResponse("To discover a new country and to save money.");
			question1.setPatient(monpatient1);
			
			Question question2=new Question();
			question2.setDate(new java.util.Date());
			question2.setTitle("tourism answered");
			question2.setDescription("can family members travel with me?");
			question2.setResponse("you can choose to have any number of people travel with you");
			question2.setPatient(monpatient1);
			
			Question question3=new Question();
			question3.setDate(new java.util.Date());
			question3.setTitle("tourism");
			question3.setDescription("what is medical tourism?");
			question3.setPatient(monpatient1);
			
			Question question4=new Question();
			question4.setDate(new java.util.Date());
			question4.setTitle("travel");
			question4.setDescription("do I have to sacrifice quality of care for savings?");
			question4.setPatient(monpatient2);
			
			
			entityManager.merge(question1);
			entityManager.merge(question2);
			entityManager.merge(question3);
			entityManager.merge(question4);
			
				
			//userServicesLocal.bookSurgery(monsurgery1, "comm ", 1);
			//userServicesLocal.bookSurgery(monsurgery2, "comm", 2);
			
			//assignedPatientsServicesLocal.assignPatientToDoctor(mondoctor1, 1);
			//assignedPatientsServicesLocal.assignPatientToDoctor(mondoctor1, 2);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			/*Hajer*/	
			
	}

}
