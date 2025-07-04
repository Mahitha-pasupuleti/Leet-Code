/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        List<Node> path = new LinkedList<>();
        while ( p != null ) {
            path.add( p);
            p = p.parent;
        }

        while ( q != null ) {
            if ( path.contains( q ) ) return q;
            q = q.parent;
        }
        return null;
    }
}