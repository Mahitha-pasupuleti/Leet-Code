class Solution {
    public boolean dfs(int[][] graph, int[] color, int source, int currentColor) {
        color[source] = currentColor;
        int[] edgeList = graph[source];
        for ( int edge : edgeList ) {
            if ( color[edge] == currentColor ) return false;
            if ( color[edge] != -1 ) continue;

            if ( !dfs(graph, color, edge, 1 - currentColor) ) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1 && !dfs(graph, color, i, 0)) {
                return false;
            }
        }

        return true;
    }
}