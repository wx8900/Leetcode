package onsite.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeZigzagLevelOrderTraversal {
    static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean isOdd = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> levelNodes = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (isOdd) {
                    levelNodes.add(current.val);
                } else {
                    levelNodes.addFirst(current.val);
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            result.add(levelNodes);
            isOdd = isOdd ? false : true;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeZigzagLevelOrderTraversal tz = new TreeZigzagLevelOrderTraversal();
        TreeNode node = new TreeNode(1);
        tz.zigzagLevelOrder(node);
    }
}
