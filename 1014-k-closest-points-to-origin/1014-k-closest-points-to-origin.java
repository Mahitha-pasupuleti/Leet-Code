class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        // only store coorinate values (x, y)
        // However use maxHeap to sort based on distance

        // PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
        //     (a, b) -> ( (a[1]-a[0])*(a[1]-a[0]) - (b[1]-b[0])*(b[1]-b[0]) )
        // );

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> ( (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]) )
        );

        for ( int[] point : points ) {
            maxHeap.add(point);
            if ( maxHeap.size() > k ) maxHeap.poll();
        }

        return maxHeap.toArray(new int[k][]);

    }
}