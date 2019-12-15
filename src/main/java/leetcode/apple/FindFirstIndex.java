package leetcode.apple;

/**
 * Find the first index of String s according to subStr
 *
 * @author Jeff
 * @version V1.0
 * @date 6/18/19 14:26
 */
public class FindFirstIndex {

    public static void main(String[] args) {
        FindFirstIndex findFirstIndex = new FindFirstIndex();
        String s = "accenttretutur";
        String subStr = "tur";
        System.out.println(findFirstIndex.findFirstIndex(s, subStr));
    }

    /**
     * using two pointer
     * @param s
     * @param subStr
     * @return
     */
    public int findFirstIndex(String s, String subStr){
        int indexS = 0;
        int indexSub = 0;
        char[] sub = subStr.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(indexS) == sub[indexSub]) {
                indexS = i;
                indexSub++;
            } else {
                indexS++;
            }
            if(indexSub == subStr.length() - 1){
                return indexS;
            }
        }
        return indexS;
    }

}
