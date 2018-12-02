package business.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDateFormat {

   private static final long DATE = 24 * 60 * 60 * 1000;

   private static final String NAME = "magician";

   private SimpleDateFormat dateFormat;

   public MyDateFormat(String pattern){
       this.dateFormat = new SimpleDateFormat(pattern);
   }

   public String myformat(){
       return NAME+this.dateFormat.format(new Date());
   }

   public String thisfromat(Date date){
       return NAME+this.dateFormat.format(date);
   }

   public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if(cal1 != null && cal2 != null) {
            return cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
   }

   public static long betweenDays(Date from, Date to){
        long difference = (from.getTime() - to.getTime())/DATE;
        return Math.abs(difference);
   }
}
