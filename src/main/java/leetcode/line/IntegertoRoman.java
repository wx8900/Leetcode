package leetcode.line;

public class IntegertoRoman {
	String M[] = {"", "M", "MM", "MMM"};
    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    
//	public String intToRoman(int num) {
//		String str = String.valueOf(num);
//		StringBuffer sb = new StringBuffer();
//		int len = str.length();
//		for (int i = len - 1; i >= 0 ; i--) {
//			char c = str.charAt(i);
//			System.out.println("===第 "+i+" 位 ==="+ c );
//			sb.append(M[(num%1000)*10]).append(C[(num%100)*10]).append(X[(num%10)*10]).append(I[num]);
//		}
//		return sb.toString();
//	}
    
    public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

	public static void main(String[] args) {
		IntegertoRoman so = new IntegertoRoman();
		System.out.println(so.intToRoman(2943));
	}

}
