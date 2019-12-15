package leetcode.binarySearch;

public class GuessNumber {
    public static void main(String[] args) {
        GuessNumber g = new GuessNumber();
        System.out.println("=======Result======"+g.guessNumber(10));
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                result = mid;
                break;
            } else if (guess(mid) == -1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public int guess(int n) {
        int result = 0;
        if (n == 6) {
            result = 0;
        }
        if (n < 6) {
            result = -1;
        }
        if (n > 6) {
            result = 1;
        }
        return result;
    }
}
