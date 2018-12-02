package business.util.maputil;

public class Polygon {

    public Polygon(Point[] paths, Rectangle rectangle){
        this.paths = paths;
        this.rectangle = rectangle;
    }

    //多边形的每个点
    public Point[] paths;

    //外包矩形
    public Rectangle rectangle;

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < this.paths.length; i++){
            temp += paths[i].toString()+"#";
        }
        return temp + rectangle.toString();
    }
}
