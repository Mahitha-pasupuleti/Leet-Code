class Solution {
    public boolean isPalindrome(String s) {
        // StringBuilder str = new StringBuilder(s);
        String str = s.toLowerCase();
        str = str.replaceAll("[^a-z0-9]", "");
        // System.out.println(str);

        int start = 0, end = str.length()-1;
        while ( start < end ) {
            if ( str.charAt(start) != str.charAt(end) ) return false;
            start++;
            end--;
        }
        return true;
    }
}