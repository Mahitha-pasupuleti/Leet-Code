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
    public boolean evenCheck(Queue<TreeNode> queue) {
        // all odd values
        // increasing
        TreeNode prev = null;
        for ( TreeNode current: queue ) {
            if ( current.val % 2 == 0 ) return false;
            if ( prev != null && prev.val >= current.val ) return false;
            prev = current;
        }
        return true;
    }
    public boolean oddCheck(Queue<TreeNode> queue) {
        // all even values
        // decreasing
        TreeNode prev = null;
        for ( TreeNode current: queue ) {
            if ( current.val % 2 != 0 ) return false;
            if ( prev != null && prev.val <= current.val ) return false;
            prev = current;
        }
        return true;
    }
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int levelCount = 0;

        while ( !queue.isEmpty() ) {
            int levelSize = queue.size();
            if ( levelCount%2 == 0 ) {
                if ( !evenCheck(queue) ) return false;
            }
            else {
                if ( !oddCheck(queue) ) return false;
            }
            for ( int i=0; i<levelSize; i++ ) {
                TreeNode current = queue.remove();
                if ( current.left != null ) queue.add(current.left);
                if ( current.right != null ) queue.add(current.right);
            }
            levelCount++;
        }

        return true;
    }
}