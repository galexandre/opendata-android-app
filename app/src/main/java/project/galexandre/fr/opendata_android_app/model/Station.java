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

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public float getLon() {
        return lon;
    }

    public float getLat() {
        return lat;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCp() {
        return cp;
    }

    public String getOpen() {
        return open;
    }

    public List<String> getServices() {
        return services;
    }

    public List<Gas> getGasAtTheStation() {
        return gasAtTheStation;
    }
}
