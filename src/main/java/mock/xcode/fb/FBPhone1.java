package mock.xcode.fb;

/**
 * [2.3, 5, 8.4, 3, 5, 1, 3, 9]
 0    1   2    3  4  5  6  7
 P1: 0
 P2: 3
 P3: 5
 k sections
 [2.3, 5, 8.4]
 [3, 5]
 [1, 3, 9]
 n >> k

 => [1, 2.3, 3, 3, 5, 5, 8.4, 9]

 O(k)

 */

/**
 *  org: [1, 2, …, n]

 org: [1, 2, 3]
 seq: [[1,2], [2, 3]]
 true

 org: [1, 2, 3]
 seq: [[1,2], [1, 3]]
 false
 // 1，2，3
 // 1，3, 2

 org: [1, 2, 3]
 seq: [[1,2], [2, 3], [1,3]]
 true

 org: [4,1,5,2,6,3]
 seq: [[4,1,5,2], [5,2,6,3]]
 true

 Only sequence of org
 Org: 1-n
 Org => sequence
 Seq => [x1, x2....] => x1 is prior than x2 => order of the nums

 Idea:
 1. Construct the graph by seq
 Each inner array of the seq => [4,1,5,2], [4,1,3,2] => (before, after) => (4, 1) (1, 5) (5, 2)

 2. Get the topological sort of the graph, org[0] = org

 3. Only one sequence (org == myOrg) => true

 */
public class FBPhone1 {

}
