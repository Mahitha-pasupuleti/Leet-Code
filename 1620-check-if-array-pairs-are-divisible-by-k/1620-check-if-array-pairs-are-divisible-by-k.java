class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> countPair = new HashMap<>();
        for ( int i=0; i<arr.length; i++ ) {
            int remainder = arr[i]%k;
            if ( remainder < 0 ) remainder += k;
            // int constant = k - remainder;
            int constant = (remainder == 0) ? 0 : k - remainder;
            if ( countPair.containsKey(constant) ) {
                if ( countPair.get(constant) == 1 ) countPair.remove(constant);
                else countPair.put(constant, countPair.get(constant) - 1);
            } else {
                countPair.put(remainder, countPair.getOrDefault(remainder, 0) + 1 );
            }
        }

        // System.out.println(countPair);
        if ( countPair.size() == 0 ) return true;
        // if ( countPair.size() == 1 && countPair.containsKey(0) ) return true;
        return false;
    }
}