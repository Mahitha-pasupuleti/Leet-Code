class Solution {
    public int singleNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for ( int i=0; i<nums.length; i++ ) {
            if ( map.get(nums[i]) == null ) {
                map.put(nums[i], 1);
            } else {
                int value = map.get(nums[i]);
                map.put(nums[i], ++value);
            }
        }

        Iterator<HashMap.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        while ( iterator.hasNext() ) {
            HashMap.Entry<Integer, Integer> entry = iterator.next();
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            // System.out.println("Key=" + key + ", Value=" + value);
            if ( value == 1 ) return key;
        }

        // System.out.println(map);
        return 0;
    }
}