class Solution {
    public int titleToNumber(String columnTitle) {

        int result = 0;
        char ch = 'A';

        StringBuilder str = new StringBuilder(columnTitle);
        str = str.reverse();

        for ( int i=0; i<str.length(); i++ ) {
            result += Math.pow(26, i) * ( (int)str.charAt(i) - (int)ch + 1 );
        }
        
        return result;
    }
}