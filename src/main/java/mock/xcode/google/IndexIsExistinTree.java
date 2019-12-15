package mock.xcode.google;

import java.util.ArrayList;
import java.util.List;

/**
           0
         /   \
       1      2
     /  \    / \
    3   4   5  6
  / \  / \ /
 7  8 9 10 11 12 13 14

 n nodes
 14 -> 6 -> 2 -> 0
 0 -> 2 -> 6 -> 14

 11 -> 5 -> 2 -> 0
 0 -> 2 -> 5 -> 11

 int index, TreeNode root => boolean exist
 7 => true
 11 => true
 12 => false

 height 2 => :  2 ^ 2 - 1

 formula : i => 2 * i + 1, 2 * i + 2

 (i - 1 ) / 2
 */

public class IndexIsExistinTree {

    public static void main(String[] args) {
        IndexIsExistinTree isExistinTree = new IndexIsExistinTree();
        //System.out.println(isExistinTree.isExist(12, ));
    }

    public static boolean isExist(int index, TreeNode root) {
        if (root == null || index <= 0) {
            return false;
        }

        List<Integer> path = new ArrayList<>();
        while (index > 0) {
            path.add(index);
            index = (index - 1) / 2;
        }

        //index: 4
        //path: {4, 1}
        TreeNode currNode = root; //0
        for (int i = path.size() - 1; i >= 0; i--) {
            if (currNode == null) {
                return false;
            }

            int nextNode = path.get(i);
            if (nextNode == 2 * currNode.val + 1) {
                currNode = currNode.left;
            }  else {
                currNode = currNode.right;
            }
        }

        // curNode
        return currNode != null;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
