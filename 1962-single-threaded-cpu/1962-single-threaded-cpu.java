class Solution {
    public int[] getOrder(int[][] tasks) {
        // HashMap to store processingTime, index
        // int[] to store index while popping
        // int time, while pop store process and decrement

        int n = tasks.length;
        int[][] newTasks = new int[n][3];
        for ( int i=0; i<n; i++ ) {
            newTasks[i][0] = tasks[i][0]; // enquetime
            newTasks[i][1] = tasks[i][1]; // processing time
            newTasks[i][2] = i; // index;
        }

        Arrays.sort(newTasks, (a, b) -> Integer.compare(a[0], b[0])); // sort based on enqueTime

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if ( a[1] != b[1] ) { // processing time
                    return Integer.compare(a[1], b[1]); // least processing time
                } else {
                    return Integer.compare(a[2], b[2]); // least index;
                }
            }
        );

        int[] result = new int[n];
        int j=0, time=0, index=0;

        while ( index < n ) {
            while ( j < n && newTasks[j][0] <= time ) {
                pq.add(newTasks[j]);
                j++;
            }
            if ( pq.isEmpty() ) {
                time = newTasks[j][0];
                continue;
            }
            int[] curr = pq.poll();
            time += curr[1];
            result[index++] = curr[2];
        }

        return result;
    }
}