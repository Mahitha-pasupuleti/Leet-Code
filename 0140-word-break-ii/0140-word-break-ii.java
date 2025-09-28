class Solution {
    private void solve(String s, List<String> wordDict, List<String> result, List<List<String>> resultList) {
        if ( s.isEmpty() ) {
            resultList.add(new ArrayList<>(result));
        }
        for ( String word: wordDict ) {
            if ( word.length() > s.length() ) continue;
            if ( s.startsWith(word) ) {
                String nextWord = s.substring(word.length());
                result.add(word);
                solve(nextWord, wordDict, result, resultList);
                result.remove(result.size()-1);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        // StringBuilder result = new StringBuilder();
        List<String> result = new ArrayList<>();
        List<List<String>> resultList = new ArrayList<>();
        solve(s, wordDict, result, resultList);

        for ( List<String> words: resultList ) {
            StringBuilder str = new StringBuilder();
            for ( String word : words ) {
                str.append(word + " ");
            }
            str.setLength(str.length()-1);
            result.add(str.toString());
        }

        return result;
    }
}