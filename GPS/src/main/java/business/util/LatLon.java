package business.util;

public class LatLon {

    public LatLon(Double lon, Double lat){
        this.lat = lat;
        this.lon = lon;
    }

    private Double lon;
    private Double lat;

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
