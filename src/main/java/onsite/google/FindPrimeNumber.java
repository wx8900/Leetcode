package onsite.google;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 8/13/19 12:06
 */
public class FindPrimeNumber {

    /*public static int countPrime(int n) {
        boolean [] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }*/

    public static void main(String[] args) {
        System.out.println(countPrime(10));
    }

    public static int countPrime(int n) {
        int count = 0;
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; j * i < n; j++) {
                    notPrime[j * i] = true;
                }
            }
        }
        return count;
    }

}
