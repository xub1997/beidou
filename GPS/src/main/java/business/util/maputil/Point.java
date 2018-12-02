package business.util.maputil;

public class Point {
    public Double lat;
    public Double lon;

    public Point(Double lon, Double lat){
        this.lon = lon;
        this.lat = lat;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Point)){
            return false;
        }
        Point point = (Point)obj;
        return this.lat.equals(point.lat) && this.lon.equals(point.lon);
    }

    @Override
    public String toString() {
        return this.lon.toString()+"&"+this.lat.toString();
    }


}
