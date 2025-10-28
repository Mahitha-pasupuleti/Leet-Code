class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
}
class WordDictionary {

    private Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        for ( int i=0; i<word.length(); i++ ) {
            char ch = word.charAt(i);
            if ( !node.containsKey(ch) ) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    private boolean solve(int index, String word, Node node) {
        if ( index == word.length() ) return node.isEnd();
        char ch = word.charAt(index);
        if ( ch == '.' ) {
            for ( int i=0; i<26; i++ ) {
                char curr = (char)('a' + i);
                Node child = node.get(curr);
                if ( child != null && solve(index+1, word, child) ) return true;
            }
        }
        else if ( node.containsKey(ch) && solve(index+1, word, node.get(ch) ) ) return true;
        return false;
    }
    
    public boolean search(String word) {
        Node node = root;
        return solve(0, word, node);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */