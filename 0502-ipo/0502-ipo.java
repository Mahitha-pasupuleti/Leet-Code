class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for ( int i=0; i<n; i++ ) {
            projects[i][0] = profits[i];
            projects[i][1] = capital[i];
        }
        Arrays.sort(projects, (a, b) -> a[1] - b[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        int j = 0;
        while ( k != 0 ) {
            while ( j < n && projects[j][1] <= w ) {
                pq.add(projects[j]);
                j++;
            }
            if ( pq.isEmpty()  ) {
                return w;
            }
            int[] maxTop = pq.poll();
            w += maxTop[0];
            k--;
        }

        return w;
    }
}