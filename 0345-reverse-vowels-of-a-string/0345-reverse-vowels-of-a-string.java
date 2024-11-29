class Solution {
    public void swap(StringBuilder str, int low, int high) {
        char ch = str.charAt(low);
        str.setCharAt(low, str.charAt(high));
        str.setCharAt(high, ch);
    }
    public String reverseVowels(String s) {
        
        StringBuilder str = new StringBuilder(s);

        int low = 0, high = s.length()-1;

        while ( low <= high ) {
            char chLow = s.charAt(low);
            char chHigh = s.charAt(high);
            // if ( chLow != 'a' && chLow != 'e' && chLow != 'i' && chLow != 'o' && chLow != 'u' ) low++;
            // if ( chHigh != 'a' && chHigh != 'e' && chHigh != 'i' && chHigh != 'o' && chHigh != 'u' ) high--;
            if ( chLow == 'a' || chLow == 'e' || chLow == 'i' || chLow == 'o' || chLow == 'u'
            || chLow == 'A' || chLow == 'E' || chLow == 'I' || chLow == 'O' || chLow == 'U' ) {
                if ( chHigh == 'a' || chHigh == 'e' || chHigh == 'i' || chHigh == 'o' || chHigh == 'u'
                || chHigh == 'A' || chHigh == 'E' || chHigh == 'I' || chHigh == 'O' || chHigh == 'U' ) {
                    swap(str, low, high);
                    // System.out.println(str);
                    low++;
                    high--;
                }
            }
            if ( chLow != 'a' && chLow != 'e' && chLow != 'i' && chLow != 'o' && chLow != 'u'
            && chLow != 'A' && chLow != 'E' && chLow != 'I' && chLow != 'O' && chLow != 'U' ) low++;
            if ( chHigh != 'a' && chHigh != 'e' && chHigh != 'i' && chHigh != 'o' && chHigh != 'u'
            && chHigh != 'A' && chHigh != 'E' && chHigh != 'I' && chHigh != 'O' && chHigh != 'U' ) high--;
            // low++;
            // high--;
        }

        return str.toString();
    }
}