class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> ((b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]))
        );

        for ( int[] point : points ) {
            pq.add(point);
            if ( pq.size() > k ) pq.poll();
        }

        return pq.toArray(new int[k][]);


        // int[][] result = new int[k][2];
        // int index = 0;
        // while( !pq.isEmpty() ) {
        //     int[] top = pq.poll();
        //     result[index][0] = top[0];
        //     result[index][1] = top[1];
        //     index++;
        // }

        // return result;
    }
}