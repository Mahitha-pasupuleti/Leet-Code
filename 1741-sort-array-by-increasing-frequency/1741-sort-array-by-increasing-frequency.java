class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i=0; i<nums.length; i++ ) {
            if ( map.containsKey(nums[i]) ) {
                int value = map.get(nums[i]);
                map.put(nums[i], ++value);
            } else {
                map.put(nums[i], 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> {
                if ( a.getValue() != b.getValue() ) {
                    return Integer.compare(a.getValue(), b.getValue());
                } else {
                    return Integer.compare(b.getKey(), a.getKey());
                }
            }
        );

        for ( Map.Entry<Integer, Integer> entry : map.entrySet() ) {
            pq.add(entry);
        }

        int index = 0;
        while ( !pq.isEmpty() ) {
            Map.Entry<Integer, Integer> currentEntry = pq.poll();
            int key = currentEntry.getKey();
            int value = currentEntry.getValue();
            while ( value != 0 ) {
                nums[index++] = key;
                value--;
            }
        }

        return nums;
    }
}