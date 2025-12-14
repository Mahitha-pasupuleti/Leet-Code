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

    void setEnd(boolean value) {
        flag = value;
    }

    boolean isEnd() {
        return flag;
    }
}
class Solution {
    // BACKTRACKING TRIE
    private Node root;
    int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

    public Solution() {
        root = new Node();
    }

    private void insert(String word) {
        Node node = root;
        for ( int i=0; i<word.length(); i++ ) {
            char ch = word.charAt(i);
            if ( !node.containsKey(ch) ) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd(true);
    }

    private void dfs(int x, int y, StringBuilder str, char[][] board, boolean[][] visited, Node node, List<String> result) {
        visited[x][y] = true;
        str.append(board[x][y]);
        if ( node.isEnd() ) {
            node.setEnd(false);
            result.add(str.toString());
        }
        for ( int[] dir : directions ) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            if ( dx<0 || dy<0 || dx>=board.length || dy>=board[0].length || visited[dx][dy] ) continue;
            if ( !node.containsKey( board[dx][dy] ) ) continue;
            dfs(dx, dy, str, board, visited, node.get( board[dx][dy] ), result);
        }
        visited[x][y] = false;
        str.deleteCharAt(str.length()-1);
    }

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        List<String> result = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        for ( String word : words ) {
            insert(word);
        }

        Node node = root;

        for ( int i=0; i<m; i++ ) {
            for ( int j=0; j<n; j++ ) {
                char ch = board[i][j];
                if ( node.containsKey(ch) ) {
                    dfs(i, j, str, board, visited, node.get(ch), result);
                }
            }
        }

        return result;
    }
}