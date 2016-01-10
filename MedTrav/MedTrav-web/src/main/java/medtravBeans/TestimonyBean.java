package medtravBeans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


import org.primefaces.event.SelectEvent;

import services.interfaces.TestimonyServicesLocal;
import entities.Testimony;
import entities.User;



@ManagedBean
@SessionScoped
public class TestimonyBean {

	// models
		private Testimony testimony;
		private List<Testimony> testimonies;

		private boolean display;
		private String titleSearch;
		
		// injection of the proxy
		@EJB
		private TestimonyServicesLocal testimonyServicesLocal;
		
		@PostConstruct
		public void init() {
			testimony=new Testimony();
			testimonies = testimonyServicesLocal.findAllTestimonies();
			setDisplay(false);

		}

		
		@ManagedProperty(value = "#{loginBean.found}")
		private User user; 
		
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

	

		
		public void onRowSelect(SelectEvent event) {
			setDisplay(true);
		}

		// methods
		public String doAddTestimony() {
			testimony.setDate(new Date());
			//System.out.println("mon login="+user.getLogin());
			testimony.setPatient(testimonyServicesLocal.findPatientById(user.getUserId()));
			testimonyServicesLocal.addTestimony(testimony);
			testimonies = testimonyServicesLocal.findAllTestimonies();
			
			return "/patient/Testimony/listTestimony";
		}

		public String doDeleteTestimony() {
			testimonyServicesLocal.deleteTestimony(testimony);
			testimonies = testimonyServicesLocal.findAllTestimonies();
			display = false;
			testimony=new Testimony();
			return "";
			
		}

		public String doUpdateTestimony() {
			testimonyServicesLocal.updateTestimony(testimony);
			testimonies = testimonyServicesLocal.findAllTestimonies();
			display = false;
			testimony=new Testimony();
			return "";
		}

		public String doFindTestimonyByTitle(){
			
			testimonies = testimonyServicesLocal.findAllTestimoniesByTitle(getTitleSearch());
			
			System.out.println("tableau contient ======"+testimonies.size());
			
			return "listTestimony";
			
		}
		
		
		
		
		public Testimony getTestimony() {
			if(testimony == null){
				testimony = new Testimony();
				}
			return testimony;
		}

		public void setTestimony(Testimony testimony) {
			this.testimony = testimony;
		}

		public List<Testimony> getTestimonies() {
			//testimonies = testimonyServicesLocal.findAllTestimonies();
			return testimonies;
		}

		public void setTestimonies(List<Testimony> testimonies) {
			this.testimonies = testimonies;
		}

		
		public String getTitleSearch() {
			return titleSearch;
		}

		public void setTitleSearch(String titleSearch) {
			this.titleSearch = titleSearch;
		}

		public boolean isDisplay() {
			return display;
		}

		public void setDisplay(boolean display) {
			this.display = display;
		}
		
		
}
