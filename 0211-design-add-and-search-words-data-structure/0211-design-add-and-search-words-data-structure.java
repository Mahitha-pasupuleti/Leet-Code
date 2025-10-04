class Node {
    Node[] links =new Node[26];
    boolean flag = false;

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node; // create a new node reference and add
    }

    Node get(char ch) {
        return links[ch - 'a'];
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
                node.put(ch, new Node()); // add reference to a new node;
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        return helper(0, word, root); // [.ad]
    }

    public boolean helper(int start, String word, Node node) {
        if ( start == word.length() ) return node.isEnd();
        
        char ch = word.charAt(start); // '.'
        if ( ch == '.' ) {
            for ( int j=0; j<26; j++ ) {  
                Node next = node.links[j]; 
                if ( next != null && helper(start+1, word, next) ) return true;
            }
            return false;
        }
        else {
            if ( !node.containsKey(ch) ) return false;
            return helper(start+1, word, node.get(ch));
        }

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */