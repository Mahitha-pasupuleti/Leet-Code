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
    boolean sametree = true;
    public void checkSameTree(TreeNode p, TreeNode q) {
        if ( p == null && q == null ) return;
        else if ( p == null || q == null ) {
            sametree = false;
            return;
        }
        if ( p.val != q.val ) sametree = false;
        checkSameTree(p.left, q.left);
        checkSameTree(p.right, q.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        checkSameTree(p, q);
        return sametree;
    }
}

/* 
class Solution {
    boolean result = true;
    public void getTree(TreeNode root1, TreeNode root2) {
        if ( root1 == null && root2 == null ) {
            return;
        } else if ( root1 == null || root2 == null ) {
            result = false;
            return;
        }
        getTree(root1.left, root2.left);
        if ( root1.val != root2.val ) result = false;
        getTree(root1.right, root2.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
       getTree(p, q);
       return result;
    }
}
*/