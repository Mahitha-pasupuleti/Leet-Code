class Solution {
    public String[] findRelativeRanks(int[] score) {

        int[] scoreCopy = Arrays.copyOf(score, score.length);
        Arrays.sort(score);

        HashMap<Integer, String> rank = new HashMap<>();

        for ( int i=0; i<score.length; i++ ) {
            if ( i == score.length-1 ) {
                rank.put(score[i], "Gold Medal");
            } else if ( i == score.length-2 ) {
                rank.put(score[i], "Silver Medal");
            } else if ( i == score.length-3 ) {
                rank.put(score[i], "Bronze Medal");
            } else {
                rank.put(score[i], Integer.toString(score.length-i));
            }
        }
        
        String result[] = new String[score.length];

        for ( int i=0; i<result.length; i++ ) {
            result[i] = rank.get(scoreCopy[i]);
        }

        return result;
        
    }
}