class Solution {
    // sequential
    public boolean isAlienSorted(String[] words, String order) {
        for ( int i=0; i<words.length-1; i++ ) {
            String s1 = words[i], s2 = words[i+1];
            int largestWord = Math.max( words[i].length(), words[i+1].length() );
            for ( int j=0; j<largestWord; j++ ) {
                int c1 = -1, c2 = -1;
                if ( j < words[i].length() ) c1 = order.indexOf( words[i].charAt(j) );
                if ( j < words[i+1].length() ) c2 = order.indexOf( words[i+1].charAt(j) );
                if ( c1 < c2 ) {
                    break;
                } else if ( c1 > c2 ) {
                    return false;
                }
            }
        }
        return true;
    }
}