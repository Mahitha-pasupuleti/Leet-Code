class Solution {
    public String mergeAlternately(String word1, String word2) {
        int startWord1 = 0, startWord2 = 0;
        StringBuilder result = new StringBuilder();
        while ( startWord1 < word1.length() && startWord2 < word2.length() ) {
            result.append( word1.charAt(startWord1) );
            result.append( word2.charAt(startWord2) );
            startWord1++;
            startWord2++;
        }

        if ( startWord2 == word2.length() ) {
            while ( startWord1 < word1.length() ) {
                result.append( word1.charAt(startWord1) );
                startWord1++;
            }
        }

        if ( startWord1 == word1.length() ) {
            while ( startWord2 < word2.length() ) {
                result.append( word2.charAt(startWord2) );
                startWord2++;
            }
        }

        return result.toString();

    }
}