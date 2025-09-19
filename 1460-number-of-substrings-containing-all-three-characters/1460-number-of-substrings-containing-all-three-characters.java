class Solution {
    public int numberOfSubstrings(String s) {

        int start = 0, count = 0;
        int[] charCount = new int[3];

        for ( int end=0; end<s.length(); end++ ) {
            charCount[s.charAt(end) - 'a']++;
            while ( charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0 ) {
                count += s.length() - end;
                charCount[s.charAt(start) - 'a']--;
                start++;
            }
        }

        return count;
        
    }
}