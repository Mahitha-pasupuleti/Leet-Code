class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        // only store coorinate values (x, y)
        // However use maxHeap to sort based on distance

        /* 
        Why this doesn't work?

        (a[1] - a[0])² vs (b[1] - b[0])²
        That is not the distance from the origin, it's the square of the difference 
        between y and x, which is only meaningful if you're trying to sort based on 
        how different x and y are from each other (e.g., on the y = x line). 
        It’s not a measure of distance from (0, 0).

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> ( (a[1]-a[0])*(a[1]-a[0]) - (b[1]-b[0])*(b[1]-b[0]) )
        );
        */

        /* 
        Why this works?
        This correctly compares the squared distance of point b and a from the origin, 
        returning a positive number if b is farther (which puts it ahead in the 
        queue — max heap behavior). 
        It sorts based on: dist² = x² + y²

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> ( (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]) )
        );
        */

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> ( (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]) )
        );

        for ( int[] point : points ) { // nice code for PriorityQueue problems
            maxHeap.add(point);
            if ( maxHeap.size() > k ) maxHeap.poll();
        }

        return maxHeap.toArray(new int[k][]);

    }
}