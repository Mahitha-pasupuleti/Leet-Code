class Node {
    Map<String, Node> links = new HashMap<>();
    boolean flag = false;

    boolean contains(String str) {
        return links.containsKey(str);
    }

    void put(String str, Node node) {
        links.put(str, node);
    }

    Node get(String str) {
        return links.get(str);
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
    private void insert(String folder, List<String> result) {
        folder += "/";
        Node node = root;
        Stack<Character> stack = new Stack<>();

        for ( int i=0; i<folder.length(); i++ ) {
            char ch = folder.charAt(i);
            if ( ch == '/' && stack.isEmpty() ) continue;
            else if ( ch == '/' ) {
                StringBuilder str = new StringBuilder();
                while ( !stack.isEmpty() ) {
                    str.append(stack.pop());
                }
                String fold = str.reverse().toString();

                if ( !node.contains(fold) ) {
                    node.put(fold, new Node());
                }
                node = node.get(fold);
                if ( node.isEnd() ) return;
            } else {
                stack.push(ch);
            }
        }

        folder = folder.substring(0, folder.length() - 1);
        node.setEnd();
        result.add(folder);
    }
    public List<String> removeSubfolders(String[] folders) {
        Arrays.sort(folders);
        List<String> result = new ArrayList<>();
        for ( String folder : folders ) {
            insert(folder, result);
        }
        return result;
    }
}

/*
-> while adding a word if encountered a true  i.e end of word discrd adding the current word
-> if while adding u end up keeping the current word true then add this to final result
-> duplicates not allowed
-> discard /, single / not allowed
*/

// char ch = folder.charAt(i);
            // if ( ch == '/' ) continue;
            // if ( !node.contains(ch) ) {
            //     node.put(ch, new Node());
            // }
            // node = node.get(ch);
            // if ( node.isEnd() ) return;