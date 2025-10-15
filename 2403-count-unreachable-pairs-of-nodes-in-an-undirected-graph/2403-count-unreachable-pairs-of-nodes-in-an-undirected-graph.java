class Solution {
    public long countPairs(int n, int[][] edges) {
        long count = 0;
        ArrayList<ArrayList<Integer>> graph = buildGraph(n, edges);
        boolean[] isVisited = new boolean[n];
        
        long unVisitedNodes = n;
        for(int i = 0; i < n; i++){
            if(!isVisited[i]){
                int totalConnected = doDFS(graph, isVisited, i, new int[]{0});
                unVisitedNodes -= totalConnected;
                count += totalConnected * unVisitedNodes;
            }
        }
        
        
        return count;
    }
    
    private int doDFS(ArrayList<ArrayList<Integer>> graph, boolean[] isVisited, int vertex, int[] count){
        if(isVisited[vertex]) return count[0];
        
        isVisited[vertex] = true;
        count[0]++;
        
        for(int adjacentVertex : graph.get(vertex))
            doDFS(graph, isVisited, adjacentVertex, count);

        return count[0];
    }
    
    private ArrayList<ArrayList<Integer>> buildGraph(int n, int[][] edges){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        return graph;
    }
    
}