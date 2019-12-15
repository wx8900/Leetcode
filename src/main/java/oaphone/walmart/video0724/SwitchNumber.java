package oaphone.walmart.video0724;

/**
 * -1,-5,-3,4,2 - put negative num at first as appear order, positive number no order; no extra space
 *
 * @author Jeff
 * @version V1.0
 * @date 7/24/19 16:06
 */
public class SwitchNumber {
        private void switchNum(int[] num, int i, int j) {
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
        }

        /**
         * assume not null or empty
         * get current value, check is positive or not
         *  -1,2,-5,4,-3 -> -1,-5,2,4,-3
         * @param num
         */
        private void getOrder(int[] num) {
            int j = 1;
            for (int i = 0; i < num.length; i++) {
                if (num[i] >= 0) {
                    for (; j <= num.length - 1; j++) {
                        if(num[j] < 0) {
                            switchNum(num, i, j);
                            for (int nu : num) {
                                System.out.print(nu+" , ");
                            }
                        }
                        if (j <= i) {
                            j++;
                        }
                    }
                }
            }
        }

        public static void main(String args[] ) throws Exception {
            SwitchNumber s = new SwitchNumber();
            int[] num = new int[] {-1, 2, -10, 5, 4, -3};
            s.getOrder(num);
        }
    }
