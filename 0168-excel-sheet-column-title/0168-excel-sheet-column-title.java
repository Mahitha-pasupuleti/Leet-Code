class Solution {
    public String convertToTitle(int columnNumber) {

        StringBuilder result = new StringBuilder();
        char ch = 'A';

        while ( columnNumber > 0 ) {
            columnNumber--;
            result.append((char)((int)ch + columnNumber % 26));
            columnNumber = columnNumber/26;
        }
        
        return result.reverse().toString();
    }
}