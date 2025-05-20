class Solution {
    public boolean isPalindrome(String s, int i, int j) {
        while ( i < j ) {
            if ( s.charAt(i) != s.charAt(j) ) return false;
            i++;
            j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        // Get all substring and print the longest palindrome
        int maxLength = Integer.MIN_VALUE;
        int first = 0, last = 0;
        StringBuilder str = new StringBuilder();

        for ( int i=0; i<s.length(); i++ ) {
            for ( int j=i; j<s.length(); j++ ) {
                if ( isPalindrome(s, i, j) ) {
                    if ( j-i+1 > maxLength ) {
                        maxLength = j-i+1;
                        first = i;
                        last = j;
                    }
                }
            }
        }

        return s.substring(first, last+1);
    }
}