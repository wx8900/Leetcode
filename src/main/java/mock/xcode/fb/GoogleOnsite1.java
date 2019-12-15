package mock.xcode.fb;

/**
 * Google
 *
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
/*
Public boolean canConstructOrg(int[] org, int[][] seq) {
        // corner case
        If (org == null || org.length == 0 || seq == null || seq.length == 0) return false;

        // general case
        Int n = org.length;
        // 1 - n List<Set<Integer>> list (size = n + 1)
        Int[] indegree = new int[n + 1];
        List<Set<Integer>> graph = new ArrayList<>(); // adjList
        constructGraph(graph, org.length, seq);

        // get the indegree array
        For (int i = 1; i < n)

        Queue<Integer> q = new LinkedList<>();
        For (int i = 1; i <= n; i++) {
        If (indegree[i] == 0) {
        q.offer(i);
        }
        }
        If (q.size() == 1 && q.get(0) != org[0]) return false;

        Int i = 0;
        While (!q.isEmpty()) {
        Int cur = q.poll();
        If (cur != org[i++]) return false;
        If (graph.get(cur).size() != 1) return false;
        Int next = graph.get(cur).get(0);
        q.offer(next);
        }

        Return i == n;
        }
        Private void constructGraph(List<Set<Integer>> graph, int n, int[][] seq) {
        }

        */

