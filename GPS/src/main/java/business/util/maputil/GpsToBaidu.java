package business.util.maputil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GpsToBaidu {

    private static final Logger log = LoggerFactory.getLogger(GpsToBaidu.class);

    public static double[] postBaidu(double lat, double lng) {
        double[] latlng = null;

        URL url = null;
        URLConnection connection = null;
        try {
            url = new URL("http://api.map.baidu.com/ag/coord/convert?from=0&to=4&x=" + String.valueOf(lat) + "&y="
                    + String.valueOf(lng));
            connection = url.openConnection();
            connection.setConnectTimeout(1000);
            connection.setReadTimeout(1000);
            connection.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "utf-8");
            out.flush();
            out.close();

            // 服务器的回应的字串，并解析
            String sCurrentLine;
            String sTotalString;
            sCurrentLine = "";
            sTotalString = "";
            InputStream l_urlStream;
            l_urlStream = connection.getInputStream();
            BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream));
            while ((sCurrentLine = l_reader.readLine()) != null) {
                if (!sCurrentLine.equals(""))
                    sTotalString += sCurrentLine;
            }
            // System.out.println(sTotalString);
            sTotalString = sTotalString.substring(1, sTotalString.length() - 1);
            // System.out.println(sTotalString);
            String[] results = sTotalString.split("\\,");
            if (results.length == 3) {
                if (results[0].split("\\:")[1].equals("0")) {
                    String mapX = results[1].split("\\:")[1];
                    String mapY = results[2].split("\\:")[1];
                    mapX = mapX.substring(1, mapX.length() - 1);
                    mapY = mapY.substring(1, mapY.length() - 1);
                    mapX = new String(Base64.decode(mapX));
                    mapY = new String(Base64.decode(mapY));
                    // System.out.println(mapX);
                    // System.out.println(mapY);
                    latlng = new double[] { Double.parseDouble(mapX), Double.parseDouble(mapY) };
                } else {
                    System.out.println("error != 0");
                }
            } else {
                System.out.println("String invalid!");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("GPS转百度坐标异常！");
        }
        return latlng;
    }

    public static void main(String[] args) throws IOException {
        double lat = 113.471395;
        double lng = 23.1041;
        double[] latlng = GpsToBaidu.postBaidu(lat, lng);
        System.out.println("lat===" + latlng[0] + "  lng===" + latlng[1]);
    }
}