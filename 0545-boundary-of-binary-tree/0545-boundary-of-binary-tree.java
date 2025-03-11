/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> leftBoundary(TreeNode root, List<Integer> result) {
        while ( root != null ) {
            while ( root.left != null ) {
                result.add(root.val);
                root = root.left;
            }
            if ( root.right != null ) {
                result.add(root.val);
                root = root.right;
            } else {
                root = root.right;
            }
        }
        return result;
    }
    public List<Integer> rightBoundary(TreeNode root, List<Integer> result) {
        List<Integer> rightResult = new ArrayList();
        while ( root != null ) {
            while ( root.right != null ) {
                rightResult.add(root.val);
                root = root.right;
            }
            if ( root.left != null ) {
                rightResult.add(root.val);
                root = root.left;
            } else {
                root = root.right;
            }
        }
        Collections.reverse(rightResult);
        result.addAll(rightResult);
        return result;
    }
    public List<Integer> getAllLeafValues(TreeNode root, List<Integer> result) {
        Stack<TreeNode> stack = new Stack<>();
        if ( root.left == null && root.right == null ) return result;
        while ( root != null || !stack.isEmpty() ) {
            while ( root != null ) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if ( root.left == null && root.right == null ) result.add(root.val);
            root = root.right;
        }
        return result;
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList();
        result.add(root.val);
        // Check Left subtree
        leftBoundary(root.left, result);
        // Get all leaf values
        getAllLeafValues(root, result);
        // Check Right subtree
        rightBoundary(root.right, result);
        return result;
    }
}