package oaphone.amazon;

/**
 *  09/18/2018 do OA
 1. take an integer array as input and construct BST
 2. find shortest distance of two values in BST
 */
public class BSTDistance {
    private static class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int val;
        public TreeNode(int val){
            this.val = val;
        }
    }

    TreeNode root;

    public int distance(int[] arr, int a, int b){
        if(arr.length == 0) return -1;
        root = new TreeNode(arr[0]);
        for(int i = 1; i < arr.length; i++){ // build all binary search tree according to input // O(h)
            TreeNode next = new TreeNode(arr[i]);
            insert(root, next);
        }

        TreeNode nodeA = search(root, a); // search node a by given value a  // O(h)
        if(nodeA == null) return -1;

        TreeNode nodeB = search(root, b); // search node b by given value b  // O(h)
        if(nodeB == null) return -1;

        TreeNode lca = lca(root, a, b);  // find the lowest common ancestor by given two value a and b // O(h)
        return dis(lca, nodeA) + dis(lca, nodeB); // calculate the distance between two nodes  // O(h)
    }

    private void insert(TreeNode root, TreeNode next){ // T: O(h) where h is the height of the tree
        if(root.val == next.val) return;
        if(root.val > next.val){  // the value of current node is larger than next node, go left side
            if(root.left == null) root.left = next;   // put into left child if left child is null
            else insert(root.left, next);             // else use left child to call recursion
        }else{                    // the value of current node is smaller than next node, go right side
            if(root.right == null) root.right = next; // put into right child if right child is null
            else insert(root.right, next);            // else use left child to call recursion
        }
    }

    private TreeNode search(TreeNode root, int target){ // T: O(h)
        if(root == null || root.val == target) return root;
        if(root.val > target) return search(root.left, target);// the value of current node is larger than target, use left child to call recursion
        return search(root.right, target); // the value of current node is smaller than target, use right child to call recursion
    }

    private TreeNode lca(TreeNode root, int a, int b){ // T: O(h) where h is the height of the tree. S: O(h)
        if(root.val == a || root.val == b) return root;// the value of current node equals either a or b, lca is current node
        if(root.val > a && root.val > b) return lca(root.left, a, b);// the value of current node is larger than a and b, use left child to call recursion
        if(root.val < a && root.val < b) return lca(root.right, a, b);// the value of current node is smaller than a and b, use right child to call recursion
        return root;
    }

    private int dis(TreeNode root, TreeNode node){ // T: O(h)
        if(root.val == node.val) return 0; // distance is 0 when the values of two node are equals
        if(root.val > node.val) return dis(root.left, node) + 1; // the value of current node is larger than target node, use left child to call recursion
        return dis(root.right, node) + 1; // the value of current node is larger than target node, use right child to call recursion
    }

    public static void main(String[] args){
        BSTDistance bstDistance = new BSTDistance();
        //int[] arr = new int[]{5,6,3,1,2,4};
        int[] arr = new int[]{9,7,5,3,1};
        System.out.println(bstDistance.distance(arr, 7, 20)); // 2
        System.out.println(bstDistance.distance(arr, 5, 6)); // 1
        System.out.println(bstDistance.distance(arr, 3, 8)); // -1
        System.out.println(bstDistance.distance(arr, 2, 6)); // 4
        System.out.println(bstDistance.distance(arr, 2, 4)); // 3
    }
}
