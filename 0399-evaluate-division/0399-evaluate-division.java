import java.util.*;

class Solution {
    private double dfs(Map<String, Map<String, Double>> adjList, Set<String> visited, String current, String target, double value) {
        if (!adjList.containsKey(current) || !adjList.containsKey(target)) return -1.0;
        if (current.equals(target)) return value;

        visited.add(current);

        Map<String, Double> neighbors = adjList.get(current);
        for (String neighbor : neighbors.keySet()) {
            if (!visited.contains(neighbor)) {
                double result = dfs(adjList, visited, neighbor, target, value * neighbors.get(neighbor));
                if (result != -1.0) return result;
            }
        }

        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> adjList = new HashMap<>();

        // Build the graph
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            adjList.putIfAbsent(a, new HashMap<>());
            adjList.putIfAbsent(b, new HashMap<>());
            adjList.get(a).put(b, val);
            adjList.get(b).put(a, 1.0 / val);
        }

        double[] results = new double[queries.size()];

        // Run DFS for each query
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            Set<String> visited = new HashSet<>();
            results[i] = dfs(adjList, visited, src, dest, 1.0);
        }

        return results;
    }
}