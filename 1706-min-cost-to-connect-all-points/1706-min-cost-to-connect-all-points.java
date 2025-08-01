import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // [cost, pointIndex]
        pq.offer(new int[]{0, 0}); // start from point 0

        int totalCost = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {
            int[] top = pq.poll();
            int cost = top[0];
            int curr = top[1];

            if (visited[curr]) continue;

            visited[curr] = true;
            totalCost += cost;
            count++;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int dist = Math.abs(points[curr][0] - points[i][0]) + Math.abs(points[curr][1] - points[i][1]);
                    pq.offer(new int[]{dist, i});
                }
            }
        }

        return totalCost;
    }
}