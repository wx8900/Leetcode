package oaphone.intuit;

import java.util.Arrays;
import java.util.Comparator;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 8/8/19 22:05
 */
public class Compares {

    public static void main(String[] args) {
        String[] cities = {"Bang","Pune","San Francisco", "New York City"};
        MySort ms = new MySort();
        Arrays.sort(cities, ms);
        System.out.println(Arrays.binarySearch(cities, "New York City"));
    }

    static class MySort implements Comparator {

        /**
         * 这个方法不能覆盖接口中的compare方法，因为参数类型是Object o1, Object o2
         */
        public int compare(String a, String b) {
            return b.compareTo(a);
        }

        @Override
        public int compare(Object o1, Object o2) {
            return o2.toString().compareTo(o1.toString());
        }
    }
}
