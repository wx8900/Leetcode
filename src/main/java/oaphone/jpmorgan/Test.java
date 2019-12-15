package oaphone.jpmorgan;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @Description
 * @Author Jeff
 * @Date 2019/3/28 04:01
 * @Version V1.0
 */
public class Test {
    public static void main(String[] args) {
        LocalDateTime ldt1 = LocalDateTime.of(2014, 9, 10, 6, 30, 55);
        LocalDateTime ldt2 = LocalDateTime.of(2014, 9, 10, 6, 40, 55);
        System.out.println(Duration.between(ldt1, ldt2).toMinutes());
    }


    /**
     * @param ldt1
     * @param ldt2
     * @param minutes
     * @return
     */
    public static boolean withInTenMinutes(LocalDateTime ldt1, LocalDateTime ldt2, long minutes) {
        return (Duration.between(ldt1, ldt2).toMinutes() <= minutes) ? Boolean.TRUE : Boolean.FALSE;
    }
}
