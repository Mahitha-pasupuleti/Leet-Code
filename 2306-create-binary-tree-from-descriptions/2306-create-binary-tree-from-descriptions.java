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
    public TreeNode createBinaryTree(int[][] descriptions) {
        // Map to store val and actual TreeNode
        Map<Integer, TreeNode> map = new HashMap<>();

        for ( int i=0; i<descriptions.length; i++ ) {
            int parent = descriptions[i][0];
            int child = descriptions[i][1];
            int isLeft = descriptions[i][2];

            TreeNode parentNode = null, childNode = null;

            if ( map.containsKey( parent ) ) {
                parentNode = map.get( parent );
            } else {
                parentNode = new TreeNode( parent );
                map.put( parent, parentNode );
            }

            if ( map.containsKey( child ) ) {
                childNode = map.get( child );
            } else {
                childNode = new TreeNode( child );
                map.put( child, childNode );
            }

            if ( isLeft == 1 ) parentNode.left = childNode;
            else parentNode.right = childNode;
        }

        for ( int i=0; i<descriptions.length; i++ ) {
            int hasParent = descriptions[i][1];
            map.remove( hasParent );
        }

        for ( int key : map.keySet() ) {
            return map.get(key);
        }

        return null;
    }
}