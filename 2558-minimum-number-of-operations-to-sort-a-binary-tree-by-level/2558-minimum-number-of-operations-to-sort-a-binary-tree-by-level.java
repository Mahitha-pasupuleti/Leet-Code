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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add( root );
        int swaps = 0;
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            int index = 0;

            int[] nodes = new int[size];
            boolean[] isVisited = new boolean[size];
            Map<Integer, Integer> indexMap = new HashMap<>();

            for ( int i=0; i<size; i++ ) {
                TreeNode current = queue.poll();

                nodes[index] = current.val;
                isVisited[index] = false;
                indexMap.put( current.val, index );

                index++;
                if ( current.left != null ) queue.add( current.left );
                if ( current.right != null ) queue.add( current.right );
            }

            Arrays.sort(nodes);
            
            for ( int i=0; i<nodes.length; i++ ) {
                if ( isVisited[i] || indexMap.get( nodes[i] ) == i ) continue;
                int j=i;
                int cycle = 0;
                while ( !isVisited[j] ) {
                    isVisited[j] = true;
                    j = indexMap.get( nodes[j] );
                    cycle++;
                }
                if ( cycle > 0 ) swaps += cycle-1;
            }
        }

        return swaps;
    }
}