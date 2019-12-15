package leetcode.maths;

public class PrimeNumber {

    public static void main(String[] args) {
        PrimeNumber pn = new PrimeNumber();
        System.out.println(pn.isPrime(18));
    }

    private static boolean isPrime(int num) {
        boolean flag = true;
        if (num < 2) {  // 素数不小于2
            return false;
        } else {
            for (int i = 2; i < Math.sqrt(num); i++) { //因为要判断的数的最小公因子小于等于该数的平方根
                if (num % i == 0) {  // 若能被整除，则说明不是素数，返回false
                    flag = false;
                    break;  // 跳出循环
                }
            }
        }

        return flag;
    }
}
