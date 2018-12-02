package business.util.maputil;

public class Rectangle {

    public Rectangle(Point southWest, Point northEast){
        this.northEast = northEast;
        this.southWest = southWest;
    }

    public Point southWest;

    public Point northEast;


    @Override
    public String toString() {
        return southWest.toString()+"#"+northEast.toString();
    }
}
