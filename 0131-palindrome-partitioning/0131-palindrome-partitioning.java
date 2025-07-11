class Solution {
    private boolean isPalindrome(String s, int start, int end) {
        while ( start < end ) {
            if ( s.charAt(start) != s.charAt(end) ) return false;
            start++;
            end--;
        }
        return true;
    }
    private void generatePartitions(String s, List<List<String>> result, List<String> subResult, int start) {
        if ( start == s.length() ) {
            result.add(new ArrayList<>(subResult));
            return;
        }
        for ( int i=start; i<s.length(); i++ ) {
            if ( isPalindrome(s, start, i) ) {
                String substr = s.substring(start, i+1);
                subResult.add(substr);
                generatePartitions(s, result, subResult, i+1);
                subResult.remove(subResult.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> subResult = new ArrayList<>();
        generatePartitions(s, result, subResult, 0);
        return result;
    }
}