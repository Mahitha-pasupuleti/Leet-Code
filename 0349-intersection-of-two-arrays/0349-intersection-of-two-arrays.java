class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for ( int i=0; i<nums1.length; i++ ) {
            if ( map1.get(nums1[i]) == null ) {
                map1.put(nums1[i], 1);
            } else {
                int value = map1.get(nums1[i]);
                map1.put(nums1[i], ++value);
            }
        }

        for ( int i=0; i<nums2.length; i++ ) {
            if ( map2.get(nums2[i]) == null ) {
                map2.put(nums2[i], 1);
            } else {
                int value = map2.get(nums2[i]);
                map2.put(nums2[i], ++value);
            }
        }

        Iterator<HashMap.Entry<Integer, Integer>> iterator1 = map1.entrySet().iterator();

        List<Integer> result = new ArrayList<>();

        while ( iterator1.hasNext() ) {
            HashMap.Entry<Integer, Integer> entry = iterator1.next();
            if ( map2.get( entry.getKey() ) != null ) result.add(entry.getKey());
        }

        // System.out.println(result);

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
        
    }
}