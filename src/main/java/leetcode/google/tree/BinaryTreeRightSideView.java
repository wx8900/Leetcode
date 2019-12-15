package leetcode.google.tree;


import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class BinaryTreeRightSideView {
    /*public static void main(String[] args) {
        BinaryTreeRightSideView bt = new BinaryTreeRightSideView();
        List<Integer> list = bt.rightSideView();
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<Integer> array = new LinkedList<>();
        dfs(root, result, array);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> result, List<Integer> array) {
        // entering the node
        if (node == null) {
            return;

        }
        array.add(node.val);
        // 1 op at node
        if (array.size() > result.size()) {
            result.add(array.get(array.size() - 1));
        }

        // 2 children
        dfs(node.right, result, array);
        dfs(node.left, result, array);
        array.remove(array.size() - 1);
    }*/

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
