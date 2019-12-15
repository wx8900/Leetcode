package mock.google;

/** Google Interview Question:
 *  Give a list of numbers {a[i]}, count the number of pairs (i, j) so that a[i]+a[j] >= M and i < j.
 *  1) Count pairs  ... and i < j
 *  2) Count pairs  ... and i > j
 *  3) Count pairs  ... and i == j
 *
 *  Ask interviewer:
 *  - Clarify only need to output the count.
 *  - a list of numbers --> integers?
 *  - empty list? Return 0 or other exception?
 *  - allow negative value in the list?
 *  - Suggest to go through some test cases first?
 *  -- First, simple the condition of this question(minus the condition), then add the condition
 */

public class TwoSumLarger {

    /**
     * Question:
     Give a list of numbers {a[i]}, count the number of pairs (i,j) so that a[i] + a[j] >= M and i < j.

     Count pairs ….. and i < j;
     Count pairs ….. and i > j;
     Count pairs ….. and i == j;

     Clarify only need to output the count.
     a list of numbers → integers?
     empty list? Return 0?
     negative?

     Suggest to go through some test cases first?
     N is the length of the list
     i from 0 -> N-1
     j from i+1 -> N-1
     O(N^2)

     Discuss about the condition i < j and how to handle it in/after sort.

     Remove i < j condition first

     The simplified algorithm(ignore i < j):

     sort the list first
     ret = 0
     i : 0 -> N-1
     j : i + 1 -> N -1
     until a[i] + a[j] >= M
     ret += N - j

     If i = i + 1  a[i+1] >= a[i], so a[i+1] + a[j] >= M

     Moving i and j is O(N), sort is O(NlogN).
     Overall complexity is O(NlogN)

     Index of a[i] vs index of a[i+1] after sorting

     Similar to two sum on leetcode?


     */
}
