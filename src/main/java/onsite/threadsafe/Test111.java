package onsite.threadsafe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 2019/11/17 15:22
 */
public class Test111 {

    public static void main(String[] args) throws  Exception{

        Date aDate = null;
try {
    aDate = new SimpleDateFormat("yyyy-mm-dd").parse("2012-01-15");
    Calendar aCalendar = Calendar.getInstance();
    aCalendar.setTime(aDate);
    System.out.println(aCalendar.get(Calendar.DAY_OF_MONTH) +", "+aCalendar.get(Calendar.MONTH));

    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate bDate = LocalDate.parse("2012-01-05", format);
    System.out.println("" + bDate.getDayOfMonth() + ",==========" +bDate.getMonthValue());

} catch (ParseException e) {
    System.out.println(e);
} catch (DateTimeParseException ex) {
    System.out.println(ex );
}
        /*String first = "first";
        String second = new String("first");
        "first".concat("second");
        System.out.println(first.equals(second));
        System.out.println(first == second);
        System.out.println(first.equals("firstsecond"));
        System.out.println(second == "first");*/


        Supplier<String> i = () -> "Car";
        Consumer<String> c = x -> System.out.println(x.toLowerCase());
        Consumer<String> d = x -> System.out.println(x.toUpperCase());
        c.andThen(d).accept(i.get());
        System.out.println();
    }

}
