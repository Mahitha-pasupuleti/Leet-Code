class Solution {
    private void dfs(int[] edges, int[] path, int source, int priority) {
        path[source] = priority++;
        if ( edges[source] != -1 && path[ edges[source] ] == 0 ) {
            dfs(edges, path, edges[source], priority);
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if ( node1 == node2 ) return node1;

        int[] pathNode1 = new int[edges.length];
        int[] pathNode2 = new int[edges.length];

        dfs(edges, pathNode1, node1, 1);
        dfs(edges, pathNode2, node2, 1);

        int minDistance = Integer.MAX_VALUE;
        int indexValue = -1;

        for (int i = 0; i < edges.length; i++) {
            if (pathNode1[i] >= 1 && pathNode2[i] >= 1) {
                int totalDistance = Math.max(pathNode1[i], pathNode2[i]); // or sum depending on problem
                if (totalDistance < minDistance) {
                    minDistance = totalDistance;
                    indexValue = i;
                }
            }
        }

        return indexValue;
    }
}

// both nodes in same path
// both nodes in diff path