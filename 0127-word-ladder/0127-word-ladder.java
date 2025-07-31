class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> bfs = new ArrayDeque<>();
        Set<String> wordSet = new HashSet<>();

        for ( String word : wordList ) wordSet.add(word);
        
        bfs.add(beginWord);
        wordSet.remove(beginWord);
        int level = 1;

        while ( !bfs.isEmpty() ) {
            int size = bfs.size();

            for ( int i=0; i<size; i++ ) {
                String curr = bfs.poll();
                if ( curr.equals(endWord) ) return level;

                for ( int j=0; j<curr.length(); j++ ) {
                    for ( char ch = 'a'; ch <= 'z'; ch++ ) {
                        char[] newWordArray = curr.toCharArray();
                        newWordArray[j] = ch;
                        String newWord = new String(newWordArray);
                        if ( !wordSet.contains(newWord) ) continue;
                        bfs.add(newWord);
                        wordSet.remove(newWord);
                    }
                }
            }

            level++;
        }

        return 0;
    }
}