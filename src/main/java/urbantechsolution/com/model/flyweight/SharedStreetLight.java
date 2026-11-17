package urbantechsolution.com.model.flyweight;

public class SharedStreetLight {
    private String status;
    private String type;
    private String color;
    private int brightness;

    public SharedStreetLight(String status, String type, String color,int brightness) {
        this.status = status;
        this.type = type;
        this.color = color;
        this.brightness = brightness;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public int getBrightness() {
        return brightness;
    }
}
