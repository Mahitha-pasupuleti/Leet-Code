class Solution {
    private double dfs(Map<String, Map<String, Double>> adjList, Set<String> visited, String source, String destination, Double value) {
        if ( !adjList.containsKey(source) || !adjList.containsKey(destination) ) return -1.0;
        if ( source.equals(destination) ) return value;
        visited.add(source);

        Map<String, Double> destList = adjList.get(source);
        if ( destList != null ) {
            for ( String key : destList.keySet() ) {
                if ( visited.contains(key) ) continue;
                double result = dfs(adjList, visited, key, destination, value * destList.get(key));
                if ( result > -1.0 ) return result;
            }
        }
        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> adjList = new HashMap<>();

        for ( int i=0; i<equations.size(); i++ ) {
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);

            adjList.putIfAbsent(numerator, new HashMap<>());
            adjList.putIfAbsent(denominator, new HashMap<>());

            adjList.get(numerator).put(denominator, values[i]);
            adjList.get(denominator).put(numerator, 1.0 / values[i]);
        }

        double[] queryResult = new double[queries.size()];

        for ( int i=0; i<queries.size(); i++ ) {
            String numerator = queries.get(i).get(0);
            String denominator = queries.get(i).get(1);
            Set<String> visited = new HashSet<>();

            queryResult[i] = dfs(adjList, visited, numerator, denominator, 1.0);

        }

        return queryResult;
    }
}

/*
    a -> b = 2
    b -> a = 1/2
    b -> c = 3
    a -> c = 2*3

*/
