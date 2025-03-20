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
    StringBuilder str = new StringBuilder();
    public void preorder(TreeNode root) {
        if ( root == null ) return;
        str.append(root.val);

        if ( root.left != null || root.right != null ) {
            str.append("(");
            preorder(root.left);
            str.append(")");
        }
        
        
        if ( root.right != null ) {
            str.append("(");
            preorder(root.right);
            str.append(")");
        }
        
    }
    public String tree2str(TreeNode root) {
        if ( root == null ) return "";
        preorder(root);
        return str.toString();
    }
}

// class Solution {
//     StringBuilder result = new StringBuilder();
//     public void checkStr(TreeNode root) {
//         result.append("(");
//         if ( root == null ) return;
//         if ( root != null ) resulr.append(root.data);
//         checkStr(root.left);

//         if ( root.left == null && root.right == null ) result.remove(len-1);
//         else if ( root.left == null && root.right != null ) {
//             result.append(")")
//             checkStr(root.right);
//         } else if ( root.left != null && root.right == null ) {
//             return;
//         }
//         result.append(")");
//     }
//     public String tree2str(TreeNode root) {
//         if ( root != null ) result.append(root.data);
//         checkStr(root.left);
//         checkStr(root.right);
//     }
// }