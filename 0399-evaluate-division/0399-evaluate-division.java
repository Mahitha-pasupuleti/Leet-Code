class Solution {
    private double dfs(String source, String dest, Map<String, Map<String, Double>> adjMap, Set<String> visited) {
        visited.add(source);
        if ( source.equals(dest) ) return 1.0;
        Map<String, Double> nodeList = adjMap.get(source);
        double result;
        if ( nodeList != null ) {
            for ( Map.Entry<String, Double> node : nodeList.entrySet() ) {
                if ( visited.contains(node.getKey()) ) continue;
                result = node.getValue() * dfs(node.getKey(), dest, adjMap, visited);
                if ( result >= 0 ) return result;
            }
        }
        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> adjMap = new HashMap<>();
        for ( int i=0; i<equations.size(); i++ ) {
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);

            adjMap.putIfAbsent(numerator, new HashMap<>());
            adjMap.putIfAbsent(denominator, new HashMap<>());

            adjMap.get(numerator).put(denominator, values[i]);
            adjMap.get(denominator).put(numerator, 1.0 / values[i]);
        }
        
        int size = queries.size();
        double[] finalResult = new double[size];
        int index = 0;

        for ( List<String> query : queries ) {
            Set<String> visited = new HashSet<>();
            if ( !adjMap.containsKey(query.get(0)) || !adjMap.containsKey(query.get(1)) ) {
                finalResult[index++] = -1.0;
                continue;
            }
            double result = dfs(query.get(0), query.get(1), adjMap, visited);
            finalResult[index++] = result;
        }

        return finalResult;
    }
}