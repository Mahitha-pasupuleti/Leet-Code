class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        Arrays.sort(potions);

        // for ( int i=0; i<potions.length; i++ ) {
        //     System.out.println(potions[i]);
        // }

        // int[] result = new int[spells.length];

        for ( int i=0; i<spells.length; i++ ) {

            int start = 0, end = potions.length-1, mid = 0;

            while ( start <= end ) { 
                mid = start + ( end - start ) / 2;
                if ( potions[mid] * (long)spells[i] >= success ){
                    end = mid-1;
                }
                else {
                    start = mid+1;
                }
            }

            spells[i] = potions.length - start;

        }

        return spells;

    }
}