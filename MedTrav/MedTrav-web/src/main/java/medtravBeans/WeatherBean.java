package medtravBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class WeatherBean {
        private String selectedLocation;

        public String getSelectedLocation() {
                return selectedLocation;
        }

        public void setSelectedLocation(String selectedLocation) {
                this.selectedLocation = selectedLocation;
        }
}
