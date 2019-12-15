package oaphone.oracle;

/**
 * Oracle Phone Interview
 * Below are the permutations of string ABC.
   ABC ACB BAC BCA CBA CAB

 Algorithm Paradigm: Backtracking
 Time Complexity: O(n*n!) Note that there are n! permutations and it requires O(n) time to print a a permutation.
 Note : The above solution prints duplicate permutations if there are repeating characters in input string.
 Please see below link for a solution that prints only distinct permutations even if there are duplicates in input.

 * @author Jeff
 * @version V1.0
 * @description
 * @date 2019/4/2 19:37
 */
public class Permutation {

    public static void main(String[] args) {
        String str = "abc";
        permutations(str.toCharArray(), 0);
    }

    // Recursive function to generate all permutations of a String
    private static void permutations(char[] ch, int currentIndex)
    {
        if (currentIndex == ch.length - 1) {
            System.out.println(String.valueOf(ch));
        }

        for (int i = currentIndex; i < ch.length; i++) {
            swap(ch, currentIndex, i);
            permutations(ch, currentIndex + 1);
            swap(ch, currentIndex, i);
        }
    }

    // Utility function to swap two characters in a character array
    private static void swap(char[] ch, int i, int j)
    {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

}
