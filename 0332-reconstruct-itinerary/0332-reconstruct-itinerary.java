class Solution {
    private Map<String, PriorityQueue<String>> adjMap = new HashMap<>();
    private LinkedList<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            adjMap.putIfAbsent(from, new PriorityQueue<>());
            adjMap.get(from).add(to);
        }

        dfs("JFK");
        return result;
    }

    private void dfs(String airport) {
        PriorityQueue<String> pq = adjMap.get(airport);
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }
        result.addFirst(airport); // post-order insertion
    }
}
