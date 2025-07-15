/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private void dfs(Map<Integer, Node> map, Node orgHead, Node source) {
        source.val = orgHead.val;
        List<Node> neighborList = orgHead.neighbors;
        map.put(orgHead.val, source);
        if ( neighborList != null ) {
            for ( Node neighbor : neighborList ) {
                Node current; 
                if ( map.containsKey(neighbor.val) ) {
                    current = map.get(neighbor.val);
                } else {
                    current = new Node();
                }
                source.neighbors.add( current ); 
                if ( map.containsKey(neighbor.val) ) continue;
                dfs(map, neighbor, current);
            }
        }
    }
    public Node cloneGraph(Node node) {
        if ( node == null ) return null;
        Node orgHead = node;
        Node source = new Node();
        Map<Integer, Node> map = new HashMap<>();

        dfs(map, orgHead, source);
        return source;
    }
}