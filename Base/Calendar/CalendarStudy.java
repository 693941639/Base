package Base.Calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarStudy {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar.getTime());

        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println(format.format(calendar.getTime()));
    }
}
