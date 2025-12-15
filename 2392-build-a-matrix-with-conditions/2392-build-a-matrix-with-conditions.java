class Solution {
    private List<Integer> topoSort(int n, int[][] conditions) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[n+1];

        for(int i=1;i<=n;i++) graph.put(i, new ArrayList<>());

        for(int[] cond : conditions) {
            int u = cond[0], v = cond[1];
            graph.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=1;i<=n;i++) {
            if(inDegree[i] == 0) queue.add(i);
        }

        List<Integer> order = new ArrayList<>();
        while(!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for(int nei : graph.get(node)) {
                inDegree[nei]--;
                if(inDegree[nei] == 0) queue.add(nei);
            }
        }

        if(order.size() != n) return new ArrayList<>(); // cycle exists
        return order;
    }

    public int[][] buildMatrix(int n, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder = topoSort(n, rowConditions);
        List<Integer> colOrder = topoSort(n, colConditions);

        if(rowOrder.isEmpty() || colOrder.isEmpty()) return new int[0][0];

        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();

        for(int i=0;i<n;i++){
            rowMap.put(rowOrder.get(i), i);
            colMap.put(colOrder.get(i), i);
        }

        int[][] matrix = new int[n][n];
        for(int i=1;i<=n;i++){
            matrix[rowMap.get(i)][colMap.get(i)] = i;
        }

        return matrix;
    }
}
