class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<String, List<String>> colorEdgeList = new HashMap<>();
        Set<String> visited = new HashSet<>();

        for (int[] redEdge : redEdges) {
            String x = redEdge[0] + "R";
            String y = redEdge[1] + "R";
            colorEdgeList.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
        }

        for (int[] blueEdge : blueEdges) {
            String x = blueEdge[0] + "B";
            String y = blueEdge[1] + "B";
            colorEdgeList.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
        }

        int[] result = new int[n];
        Arrays.fill(result, -1);

        Queue<String> bfs = new ArrayDeque<>();
        if (colorEdgeList.containsKey("0B")) {
            bfs.add("0B");
            visited.add("0B");
        }
        if (colorEdgeList.containsKey("0R")) {
            bfs.add("0R");
            visited.add("0R");
        }

        int level = 0;

        while (!bfs.isEmpty()) {
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                String curr = bfs.poll();
                // ✅ Proper index extraction
                int index = Integer.parseInt(curr.substring(0, curr.length() - 1));
                if (result[index] == -1) result[index] = level;

                List<String> edgeList = colorEdgeList.get(curr);
                if (edgeList != null) {
                    for (String edge : edgeList) {
                        int edgeValue = Integer.parseInt(edge.substring(0, edge.length() - 1));
                        char edgeColor = edge.charAt(edge.length() - 1);

                        String next = edgeValue + (edgeColor == 'R' ? "B" : "R");
                        if (!visited.contains(next)) {
                            bfs.add(next);
                            visited.add(next);
                        }
                    }
                }
            }
            level++;
        }

        result[0] = 0;
        return result;
    }
}
