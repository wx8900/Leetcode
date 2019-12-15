package onsite.microsoft;

/**
 * Microsoft Index Team On-site Interview - Korea PM
 * <p>
 * only works for one digital to add or minus
 *
 * @author Jeff
 * @version V1.0
 * @date 6/10/19 13:48
 */
public class AddTwoNumFromString {
    public static void main(String[] args) throws Exception {
        AddTwoNumFromString a = new AddTwoNumFromString();
        System.out.println(a.addTwoNum("-9-2"));
    }

    public int addTwoNum(String str) throws Exception {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        char op = ' ';
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '+' || ch == '-') {
                op = ch;
            } else if (ch - '0' >= 0 && ch - '0' <= 9) {
                if (op == '+') {
                    sum += ch - '0';
                } else if (op == '-') {
                    sum -= ch - '0';
                } else {
                    sum = ch - '0';
                }
            } else {
                throw new Exception("input contains a invalid character!");
            }
        }

        return sum;
    }
}
