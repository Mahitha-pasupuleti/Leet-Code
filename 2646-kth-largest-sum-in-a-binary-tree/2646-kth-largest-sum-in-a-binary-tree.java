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
    public long kthLargestLevelSum(TreeNode root, int k) {
        // We go with level-order traversal
        List<Long> sumAtEachLevel = new ArrayList();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while ( !queue.isEmpty() ) {
            int levelSize = queue.size();
            long levelSum = 0;
            for ( int i=0; i<levelSize; i++ ) {
                TreeNode node = queue.poll();
                levelSum += (long) node.val;
                if (node.left != null ) queue.add(node.left);
                if (node.right != null ) queue.add(node.right);
            }
            sumAtEachLevel.add(levelSum);
        }

        Collections.sort(sumAtEachLevel);
        if ( k > sumAtEachLevel.size() ) return -1;
        return sumAtEachLevel.get(sumAtEachLevel.size()-k);

    }
}