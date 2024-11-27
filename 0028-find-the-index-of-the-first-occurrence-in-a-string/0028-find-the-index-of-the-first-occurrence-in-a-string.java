class Solution {
    public int strStr(String haystack, String needle) {
        
        for ( int i=0; i<haystack.length(); i++ ) {
            if ( needle.charAt(0) == haystack.charAt(i) ) {
                if ( i + needle.length()-1 < haystack.length() ) {
                    String current = haystack.substring(i, i+needle.length());
                    int j=0;
                    for ( j=0; j<current.length(); j++ ) {
                       // System.out.println(current.charAt(j) == needle.charAt(j));
                        if ( current.charAt(j) != needle.charAt(j) ) break;
                    }
                    if ( j == current.length() ) return i;
                }
            }
        }

        return -1;
    }
}