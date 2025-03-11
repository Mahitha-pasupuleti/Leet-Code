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
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode currNode = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList();
        while ( currNode != null || !stack.isEmpty() ) {
            while ( currNode != null ) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            result.add(currNode.val);
            currNode = currNode.right;
        }
        return result;
    }
}

// class Solution {
//     public void printValues(TreeNode root, List<Integer> result) {
//         if ( root == null ) return;
//         printValues(root.left, result);
//         result.add(root.val);
//         printValues(root.right, result);
//     }
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         printValues(root, result);
//         return result;
//     }
// }