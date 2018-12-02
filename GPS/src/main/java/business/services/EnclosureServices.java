package business.services;

import business.entity.repositories.EnclosureRepositories;
import business.util.maputil.Circle;
import business.util.maputil.Point;
import business.util.maputil.Polygon;
import business.util.maputil.Rectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class EnclosureServices {

    @Autowired
    private EnclosureRepositories enclosureRepositories;

    public void deleteAllById(Iterator<?> idlist) {
        while(idlist.hasNext()){
            enclosureRepositories.deleteById(Long.valueOf(Long.parseLong((String) idlist.next())));//从String转long再转Long
        }
    }

    //是否在矩形内
    public boolean isPointInRect(Point point, Rectangle rect){
        Point sw = rect.southWest;
        Point ne = rect.northEast;
        return point.lon >= sw.lon && point.lon <= ne.lon && point.lat >= sw.lat && point.lat <= ne.lat;
    }

    //是否在圆内
    public boolean isPointInCircle(Point point, Circle circle){
        Point cen = circle.center;
        Double red = circle.radius;
        Double dis = Math.sqrt(Math.pow(point.lat - cen.lat,2) + Math.pow(point.lon - cen.lon,2));
        return dis < red;
    }

    //是否在多边形内，使用射线法
    public boolean isPointInPolygon(Point point, Polygon poly){
        if(poly.rectangle != null) {
            if (!isPointInRect(point, poly.rectangle))return false;
        }
        Point[] pts = poly.paths;
        int N = pts.length;
        boolean boundOrVertex = true;
        int intersectCount = 0;
        double precision = 2e-10;
        Point p1,p2;
        Point p = point;

        p1 = pts[0];//left vertex
        for(int i = 1; i <= N; ++i){//check all rays
            if(p.equals(p1)){
                return boundOrVertex;//p is an vertex
            }

            p2 = pts[i % N];//right vertex
            if(p.lat < Math.min(p1.lat, p2.lat) || p.lat > Math.max(p1.lat, p2.lat)){//ray is outside of our interests
                p1 = p2;
                continue;//next ray left point
            }

            if(p.lat > Math.min(p1.lat, p2.lat) && p.lat < Math.max(p1.lat, p2.lat)){//ray is crossing over by the algorithm (common part of)
                if(p.lat <= Math.max(p1.lat, p2.lat)){//x is before of ray
                    if(p1.lat == p2.lat && p.lat >= Math.min(p1.lat, p2.lat)){//overlies on a horizontal ray
                        return boundOrVertex;
                    }

                    if(p1.lat == p2.lat){//ray is vertical
                        if(p1.lat == p.lat){//overlies on a vertical ray
                            return boundOrVertex;
                        }else{//before ray
                            ++intersectCount;
                        }
                    }else{//cross point on the left side
                        double xinters = (p.lat - p1.lat) * (p2.lat - p1.lat) / (p2.lat - p1.lat) + p1.lat;//cross point of lat
                        if(Math.abs(p.lat - xinters) < precision){//overlies on a ray
                            return boundOrVertex;
                        }

                        if(p.lat < xinters){//before ray
                            ++intersectCount;
                        }
                    }
                }
            }else{//special case when ray is crossing through the vertex
                if(p.lat == p2.lat && p.lat <= p2.lat){//p crossing over p2
                    Point p3 = pts[(i+1) % N]; //next vertex
                    if(p.lat >= Math.min(p1.lat, p3.lat) && p.lat <= Math.max(p1.lat, p3.lat)){//p.lat lies between p1.lat & p3.lat
                        ++intersectCount;
                    }else{
                        intersectCount += 2;
                    }
                }
            }
            p1 = p2;//next ray left point
        }

        if(intersectCount % 2 == 0){//偶数在多边形外
            return false;
        } else { //奇数在多边形内
            return true;
        }

    }
}

