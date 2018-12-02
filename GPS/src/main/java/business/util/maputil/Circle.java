package business.util.maputil;

public class Circle {

    public Circle(Point center, Double radius){
        this.center = center;
        this.radius = radius;
    }

    public Point center;

    public Double radius;

    @Override
    public String toString() {
        return radius.toString()+"#"+center.toString();
    }

}
