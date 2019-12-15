package oaphone.oracle;

/**
 * Uses recursion (backtracking method).
 * Time complexity – O(n*n!). n for printing the output and n! for recursion.
 *
 * @author Jeff
 * @version V1.0
 * @description
 * @date 2019/4/2 19:53
 */
public class PermutationII {

    public static void main(String[] args) {
        new PermutationII().permute("", "abc");
    }

    private void permute(String prefix, String suffix){
        if(1 == suffix.length()){
            System.out.println(prefix + suffix);
        }else {
            for (int i = 0; i < suffix.length(); i++) {
                permute(prefix + suffix.charAt(i), suffix.substring(0,i) + suffix.substring(i+1, suffix.length()));
            }
        }
    }
}
