class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] newIntervals = new int[n+1][2];

        for ( int i=0; i<n; i++ ) {
            newIntervals[i][0] = intervals[i][0];
            newIntervals[i][1] = intervals[i][1];
        }
        newIntervals[n][0] = newInterval[0];
        newIntervals[n][1] = newInterval[1];

        Arrays.sort(newIntervals, (a, b) -> (a[0] - b[0]));

        // for ( int i=0; i<=n; i++ ) {
        //     System.out.print(Arrays.toString(newIntervals[i]) + " ");
        // }

        Stack<int[]> pq = new Stack<>();

        for ( int i=0; i<=n; i++ ) {
            int[] current = newIntervals[i];
            while ( !pq.isEmpty() && pq.peek()[1] >= current[0] ) {
                int[] top = pq.pop();
                current[0] = Math.min(current[0], top[0]);
                current[1] = Math.max(current[1], top[1]);
            }
            pq.push(current);
        }

        int index = pq.size()-1;
        int[][] result = new int[pq.size()][2];
        while ( !pq.isEmpty() ) {
            int[] top = pq.pop();
            result[index][0] = top[0];
            result[index][1] = top[1];
            index--;
        }

        return result;
    }
}