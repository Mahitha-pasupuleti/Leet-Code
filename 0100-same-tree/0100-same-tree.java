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




/* 
public void getTree(TreeNode root, List<Integer> tree) {
        if ( root == null ) {
            //tree.add(null);
            return;
        }
        getTree(root.left, tree);
        tree.add(root.val);
        getTree(root.right, tree);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> tree1 = new ArrayList<>();
        List<Integer> tree2 = new ArrayList<>();
        getTree(p, tree1);
        getTree(q, tree2);

        System.out.println(tree1);
        System.out.println(tree2);

        if ( tree1.size() == tree2.size() ) {
            for ( int i=0; i<tree1.size(); i++ ) {
                if ( tree1.get(i) != tree2.get(i) ) return false;
            }
        } else {
            return false;
        }

        return true;
    }
*/