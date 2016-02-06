package project.galexandre.fr.opendata_android_app.model;

/**
 * Created by galexandre on 01/02/16.
 */
public class Gas {

    private String name;
    private Float price;

    public Gas(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
