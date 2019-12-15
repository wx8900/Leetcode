package leetcode.google.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinSquare {
    /*public List<List<Integer>> func(int n) {
        TreeNode[] endNode = buildTree(n);
        return walkTree(endNode); 
    }

    private TreeNode[] buildTree(int n) {
        TreeNode root = new TreeNode(0, null);
        Queue<TreeNode> queue = new LinkedList<>();
        while (!queue.isEmpty()) {
            boolean found = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                for (int childLeftSquareRooted = (int)Math.sqrt(node._left + 1);
                     childLeftSquareRooted <= node._right / 2;
                     childLeftSquareRooted++) {
                    int childLeft = childLeftSquareRooted * childLeftSquareRooted;
                    int childRight = node._right - childLeft;

                    TreeNode childNode = new TreeNode(childLeft, childRight, node);
                    queue.add(childNode);

                    int childRightSquareRooted = (int)Math.sqrt(childRight);
                    if (childRight == childRightSquareRooted * childRightSquareRooted) {
                        node.add(childNode); //?
                    }

                }
            }
            if (found) {
                break;
            }

        }
    }

    private List<List<Integer>> walkTree(TreeNode[] endNode) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < ; i++) {
            
        }
    }*/


    private class TreeNode {// no need to save children info because walk only once
        TreeNode _parent;
        int _left;
        int _right;
        public TreeNode(TreeNode parent, int left, int right) {
            _parent = parent;
            _left = left;
            _right = right;
        }
    }

}
