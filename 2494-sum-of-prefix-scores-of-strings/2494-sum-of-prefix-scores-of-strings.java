class Node {
    Node[] links = new Node[26];
    int visitCount = 0;
    boolean flag = false;

    boolean contains(char ch) {
        return links[ch - 'a'] != null;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void add(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
}

class Solution {
    private Node root = new Node();

    private void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.contains(ch)) {
                node.add(ch, new Node());
            }
            node = node.get(ch);
            node.visitCount++; // increment prefix visit count
        }
        node.setEnd();
    }

    public int[] sumPrefixScores(String[] words) {
        for (String word : words) {
            insert(word);
        }

        int[] result = new int[words.length];
        int index = 0;

        for (String word : words) {
            int count = 0;
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                node = node.get(ch);
                count += node.visitCount;
            }
            result[index++] = count;
        }

        return result;
    }
}
