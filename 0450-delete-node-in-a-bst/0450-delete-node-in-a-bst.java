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
    public TreeNode deleteNode(TreeNode root, int key) {
        if ( root == null ) return null;
        if ( root.val == key ) {
            // if ( root.left != null ) {
            //     TreeNode rootLeft = root.left;
            //     rootLeft.right = root.right;
            //     return rootLeft;
            // }
            // else if ( root.right != null ) {
            //     TreeNode rootRight = root.right;
            //     rootRight.left = root.left;
            //     return rootRight;
            // }
            // else return null;
            if ( root.left == null ) return root.right;
            else if ( root.right == null ) return root.left;
            else {
                TreeNode rootL = root.left;
                while ( rootL != null ) {
                    if ( rootL.val < root.right.val ) {
                        if ( rootL.right == null ) {
                            rootL.right = root.right;
                            break;
                        } else {
                            rootL = rootL.right;
                        }
                    } else {
                        if ( rootL.left == null ) {
                            rootL.left = root.left;
                            break;
                        } else {
                            rootL = rootL.left;
                        }
                    }
                }
                return root.left;
            }
        }
        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);
        return root;
    }
}