class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int diff = Integer.MAX_VALUE;
        int word[] = new int[2];
        word[0] = Integer.MAX_VALUE;;
        word[1] = Integer.MAX_VALUE;

        for ( int i=0; i<wordsDict.length; i++ ) {
            if ( wordsDict[i].equals(word1) ) {
                word[0] = i;
            } else if ( wordsDict[i].equals(word2) ) {
                word[1] = i;
            }
            if ( word[0] != Integer.MAX_VALUE && word[1] != Integer.MAX_VALUE ) {
                diff = Math.min(diff, Math.abs( word[0] - word[1] ) );
            }
        }

        return diff;
    }
}