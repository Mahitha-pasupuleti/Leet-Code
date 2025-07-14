class Solution {
    private String getUniqueBS(String[] nums, StringBuilder str, int start) {
        if ( str.length() == nums.length ) {
            String candidate = str.toString();
            for ( String s : nums ) {
                if ( s.equals(candidate) ) return null;
            }
            return candidate;
        }
        for ( int i=start; i<=1; i++ ) {
            str.append(i);
            if ( getUniqueBS(nums, str, i)!= null) return str.toString();
            str.deleteCharAt(str.length()-1);
        }
        return null;
    }
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder str = new StringBuilder();
        if ( getUniqueBS(nums, str, 0) != null ) return str.toString();
        return "";
    }
}