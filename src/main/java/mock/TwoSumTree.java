package mock;

import java.util.Deque;
import java.util.LinkedList;

// # 270 , # 272
public class TwoSumTree {

    public static void main(String args[]){
        TwoSumTree twoSumTree = new TwoSumTree();
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(5);
        node.right = new TreeNode(10);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(7);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(12);

        System.out.print(twoSumTree.twoSum(node, 10));
    }

    public static boolean twoSum(TreeNode root, int target) {
        boolean result = false;
        Deque<TreeNode> minDeque = new LinkedList<>();
        Deque<TreeNode> maxDeque = new LinkedList<>();
        helper(root, minDeque, false);
        helper(root.right, maxDeque, true);

        while (!minDeque.isEmpty() && !maxDeque.isEmpty()) {
            TreeNode min = minDeque.peekLast();
            TreeNode max = maxDeque.peekLast();

            if (min.val + max.val == target) return true;
            if (min.val + max.val < target) {
                TreeNode n = minDeque.pollLast();
                helper(n.right, minDeque, true);
                if (minDeque.isEmpty()) {
                    minDeque.addLast(maxDeque.pollFirst());
                }
            }
        }
        return result;
    }

    private static void helper(TreeNode root, Deque<TreeNode> queue, boolean min) {
        if (root != null) {
            queue.add(min? root.left: root.right);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
