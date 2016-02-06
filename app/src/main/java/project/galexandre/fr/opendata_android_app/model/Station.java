package project.galexandre.fr.opendata_android_app.model;
import java.util.List;
/**
 * Created by galexandre on 31/01/16.
 */
public class Station {

    private String name;
    private String id;
    private float lon;
    private float lat;
    private String address;
    private String city;
    private String cp;
    private String open;
    private List<String> services;
    private List<Gas> gasAtTheStation;

    public Station(String name, String id, float lon, float lat, String address, String city, String cp, String open, List<String> services, List<Gas> gasAtTheStation) {
        this.name = name;
        this.id = id;
        this.lon = lon;
        this.lat = lat;
        this.address = address;
        this.city = city;
        this.cp = cp;
        this.open = open;
        this.services = services;
        this.gasAtTheStation = gasAtTheStation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public List<Gas> getGasAtTheStation() {
        return gasAtTheStation;
    }

    public void setGasAtTheStation(List<Gas> gasAtTheStation) {
        this.gasAtTheStation = gasAtTheStation;
    }
}
