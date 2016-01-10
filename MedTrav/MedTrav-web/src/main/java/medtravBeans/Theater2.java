package medtravBeans;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import services.interfaces.HotelServicesLocal;
import services.interfaces.QuestionServicesLocal;
import services.interfaces.ServiceHotelServicesLocal;
import entities.Hotel;
import entities.Question;

/**
 * 
 *
 */
@ManagedBean
@SessionScoped
public class Theater2 {

	private List<Hotel> hotels;
	private Hotel hotel = new Hotel();
	private Boolean afficheMap=false;
	@EJB
	private HotelServicesLocal hotelServicesLocal;

    public Theater2(){
    	
    }

    

	public List<Hotel> getHotels() {
		hotels = hotelServicesLocal.findAllHotels();
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	 public String setSelectedPlace() { 
		 afficheMap=true;
	        
	        return null;
	    }

	public Boolean getAfficheMap() {
		return afficheMap;
	}

	public void setAfficheMap(Boolean afficheMap) {
		this.afficheMap = afficheMap;
	}

	

}

