class Solution {
    public int[] numberGame(int[] nums) {
        /* 
        OPTIMAL SOLUTION
        - sort entire array - O(nlogn)
        - swap the adjacent elements, with distance two, there will be n/2 swaps
        - O(nlogn + n/2) = O(nlogn)
        */
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        for ( int i=0; i<nums.length; i++ ) {
            pq.add(nums[i]); // O(nlogn)
        }
        while ( !pq.isEmpty() ) {
            int x = pq.poll();
            int y = pq.poll();
            result.add(y);
            result.add(x);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

/*
Time Complexity Analysis
- Sorting (Arrays.sort(nums)): Uses Dual-Pivot QuickSort (for primitive types) → O(n log n)
- Swapping adjacent elements in a loop: O(n/2) ≈ O(n) (each iteration swaps two elements)
Total Complexity: O(n log n) + O(n) = O(n log n)
Space Complexity: O(1) (In-place sorting and swapping, no extra space used)
Optimality
- This solution is more optimal in terms of space as it modifies the array in place.
- The sorting step dominates the time complexity.

Time Complexity Analysis
- Heap insertions (pq.add(num)): Inserting n elements → O(n log n)
- Heap extractions (pq.poll()): Extracting n elements → O(n log n)
- List to array conversion: O(n)
Total Complexity: O(n log n) + O(n log n) + O(n) = O(n log n)
Space Complexity: O(n) (Uses a PriorityQueue and List for storing results)
Optimality
- This solution is not space-optimal since it uses extra data structures (PriorityQueue and ArrayList).
- The sorting logic using a priority queue is unnecessary because Java’s built-in sort is more efficient.
 */