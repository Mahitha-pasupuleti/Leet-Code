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
    public List<Integer> rightSideView(TreeNode root) {
        // [1] - level 1
        // [2, 3] - level 2: 2 [for loop]
        // [3, 5]

        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        if ( root != null ) queue.add(root);

        while ( !queue.isEmpty() ) { // [2, 3]
            int levelSize = queue.size(); // 2
            for ( int i=0; i<levelSize; i++ ) { // 2
                TreeNode currNode = queue.poll(); // [5]
                if ( i == levelSize-1 ) result.add( currNode.val );
                if ( currNode.left != null ) queue.add( currNode.left ); // [5]
                if ( currNode.right != null ) queue.add( currNode.right ); // [5, 4]
            }
        }

        return result;
    }
}