package business.util.maputil;

public class ParseUtil {

    public Point parsePoint(String data){
        if(!isValid(data))throw new IllegalArgumentException("Parse Data Is Illegal");
        String[] datas = data.split("&");
        if(datas.length != 2)throw new IllegalArgumentException("Parse Data Is Illegal");
        return new Point(Double.parseDouble(datas[0]),Double.parseDouble(datas[1]));
    }

    public Circle parseCircle(String data){
        if(!isValid(data))throw new IllegalArgumentException("Parse Data Is Illegal");
        String[] datas = data.split("#");
        if(datas.length != 2)throw new IllegalArgumentException("Parse Data Is Illegal");
        Double radius = Double.parseDouble(datas[0]);
        Point center = parsePoint(datas[1]);
        return new Circle(center,radius);
    }

    public Rectangle parseRectangle(String data){
        if(!isValid(data))throw new IllegalArgumentException("Parse Data Is Illegal");
        String[] datas = data.split("#");
        if(datas.length != 2)throw new IllegalArgumentException("Parse Data Is Illegal");
        Point southWest = parsePoint(datas[0]);
        Point northEast = parsePoint(datas[1]);
        return new Rectangle(southWest,northEast);
    }

    public Polygon parsePolygon(String data){
        if(!isValid(data))throw new IllegalArgumentException("Parse Data Is Illegal");
        String[] datas = data.split("#");
        int len = datas.length;
        if(len < 3)throw new IllegalArgumentException("Parse Data Is Illegal");
        Point[] paths = new Point[len-2];
        for (int i = 0; i < len-2; i++){
            paths[i] = parsePoint(datas[i]);
        }
        Rectangle rectangle = parseRectangle(datas[len-2]+"#"+datas[len-1]);
        return new Polygon(paths, rectangle);
    }

    private boolean isValid(String data){
        if (data == null)return false;
        if(data.equals(""))return false;
        return true;
    }
}
