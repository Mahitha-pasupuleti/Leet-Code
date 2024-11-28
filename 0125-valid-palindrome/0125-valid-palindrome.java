class Solution {
    public boolean checkPalindrome(String s) {
        int low = 0, high = s.length()-1;

        while ( low <= high ) {
            if ( s.charAt(low) != s.charAt(high) ) return false;
            low++;
            high--;
        }
        return true;
    }
    public boolean isPalindrome(String s) {
        String sCopy = s.toLowerCase();
        String result = "";

        for ( int i=0; i<sCopy.length(); i++ ) {
            char ch = sCopy.charAt(i);
            if ( Character.isLetterOrDigit(ch) ) {
                result += sCopy.charAt(i);
            }
        }
        // System.out.println(result);
        return checkPalindrome(result);
    }
}