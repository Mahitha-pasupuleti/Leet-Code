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
// class Solution {
//     public void insert(TreeNode root, TreeNode node) {
//         if ( root == null ) {
//             return;
//         }
//         if ( root.val > node.val ) {
//             if ( root.left == null ) {
//                 root.left = node;
//             } else {
//             insert(root.left, node);
//             }
//         } else {
//             if ( root.right == null ) {
//                 root.right = node;
//             } else {
//             insert(root.right, node);
//             }
//         }
//     }
//     public TreeNode insertIntoBST(TreeNode root, int val) {
//         TreeNode node = new TreeNode(val);
//         if ( root == null ) return node;
//         insert(root, node);
//         return root;
//     }
// }



class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
