class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;

        Arrays.sort(envelopes, (a, b) -> {
            if ( a[0] != b[0] ) return a[0] - b[0];
            else return b[1] - a[1];
        });

        List<int[]> result = new ArrayList<>();

        for ( int[] envelope : envelopes ) {
            if ( result.size() == 0 || 
            ( result.get(result.size()-1)[0] < envelope[0] &&
              result.get(result.size()-1)[1] < envelope[1] )) {
                result.add(envelope);
            } else {
                int low = 0, high = result.size()-1;
                
                while ( low < high ) {
                    int mid = (low + high) / 2;
                    if ( result.get(mid)[0] < envelope[0] && result.get(mid)[1] < envelope[1] ) {
                        low = mid+1;
                    } else {
                        high = mid;
                    }
                }

                result.set(low, envelope);
            }
        }

        return result.size();
    }
}