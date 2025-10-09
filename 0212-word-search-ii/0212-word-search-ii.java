class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    boolean contains(char ch) {
        return links[ch - 'a'] != null;
    }

    void add(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void setEnd(boolean val) {
        flag = val;
    }

    boolean isEnd() {
        return flag;
    }
}
class Solution {
    private Node root = new Node();
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

    private void dfs(int x, int y, char[][] board, Node node, StringBuilder str, Set<String> result) {
        char ch = board[x][y];
        node = node.get(ch);
        str.append(ch);
        if (node.isEnd()) {
            result.add(str.toString());
            node.setEnd(false); // prune
        }

        board[x][y] = '#'; // mark visited
        for (int[] dir : directions) {
            int dx = x + dir[0], dy = y + dir[1];
            if (dx < 0 || dy < 0 || dx >= board.length || dy >= board[0].length) continue;
            if (board[dx][dy] == '#') continue;
            if (!node.contains(board[dx][dy])) continue;
            dfs(dx, dy, board, node, str, result);
        }
        board[x][y] = ch; // backtrack
        str.deleteCharAt(str.length() - 1);
    }

    private void insert(String word) {
        Node node = root;
        for ( int i=0; i<word.length(); i++ ) {
            char ch = word.charAt(i);
            if ( !node.contains(ch) ) {
                node.add(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd(true);
    }

    public List<String> findWords(char[][] board, String[] words) {
        Node node = root;
        int m = board.length, n = board[0].length;

        for ( String word : words ) {
            insert(word);
        }

        Set<String> result = new HashSet<>();
        boolean[][] visited = new boolean[m][n];
        StringBuilder str = new StringBuilder();

        for ( int i=0; i<m; i++ ) {
            for ( int j=0; j<n; j++ ) {
                if ( node.contains(board[i][j]) ) {
                    dfs(i, j, board, node, str, result);
                }
            }
        }
        List<String> mainRes = new ArrayList<>();
        for ( String res : result ) mainRes.add(res);
        return mainRes;
    }
}







// ["eath","ea","eat","eain", "oath"]
// construct Trie , intiall add all to Trie
// add all nodes with starting char into queue
// now in four directions check if any of its char is in the subsequest node, if mutiple?