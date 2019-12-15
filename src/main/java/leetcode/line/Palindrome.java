package leetcode.line;

public class Palindrome {

	public boolean isPalindrome(int x) {
        if(x > 0) {
            String st = String.valueOf(x);
            char[] c = st.toCharArray();
            int low = 0;
            int high = st.length() - 1;
            while(low < high) {
                if(c[low] == c[high]) {
                    low++;
                    high--;
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		Palindrome pa = new Palindrome();
		System.out.println(pa.isPalindrome(-123454321));

	}

}
