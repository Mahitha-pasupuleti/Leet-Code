class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0); // single node edge case

        // Step 1: Build the graph
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new HashSet<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Step 2: Initialize leaves
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) leaves.add(i);
        }

        // Step 3: Trim leaves iteratively
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for (int leaf : leaves) {
                int neighbor = graph.get(leaf).iterator().next(); // leaf has only one neighbor
                graph.get(neighbor).remove(leaf); // remove leaf
                if (graph.get(neighbor).size() == 1) newLeaves.add(neighbor);
            }

            leaves = newLeaves;
        }

        // Step 4: Remaining nodes are roots of MHT
        return leaves;
    }
}
