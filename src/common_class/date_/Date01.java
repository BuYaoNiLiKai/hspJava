package common_class.date_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Date01 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E");
        System.out.println(sdf.format(date));
        Date date1 = new Date(95155615);
        System.out.println(sdf.format(date1));
        String s = "2024年12月12日 20:41:12 星期一";
        Date parse = sdf.parse(s);
        System.out.println(sdf.format(parse));
        Instant instant = Instant.now();
        System.out.println(instant);
        Date date2 = Date.from(instant);
        System.out.println(date2);


    }
}
