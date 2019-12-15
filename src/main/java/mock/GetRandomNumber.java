package mock;

import java.util.Random;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 2019/12/3 00:13
 */
public class GetRandomNumber {

    public static void main(String[] args) {
        Random rand = new Random();
        int temp = 100;
        for (int i = 1, j; i < 3; i++) {
            j = rand.nextInt(temp - 1) + 1;
            //保证每个随机数最小为1，那么j就不能大于temp-(n-i)
            if (j > temp - (3 - i)) {
                j = temp - (3 - i);
            } else if (j <= 0) {
                j = 1;
            }
            temp -= j;
            System.out.println(j);
        }
        System.out.println(temp);
    }

}
