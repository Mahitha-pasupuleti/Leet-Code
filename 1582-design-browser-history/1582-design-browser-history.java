class Node {
    String val;
    Node prev;
    Node next;
    public Node(String val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
class BrowserHistory {
    private Node curr;
    public BrowserHistory(String homepage) {
        curr = new Node(homepage); // LC
    }
    
    public void visit(String url) {
        Node website = new Node(url); // GC
        curr.next = website; // LC -> GC
        website.prev = curr; // LC <=> GC <=> FC <=> YC
        curr = curr.next;
    }
    
    public String back(int steps) {
        while ( curr.prev != null && steps != 0 ) {
            curr = curr.prev; // CURR = FC
            steps--;
        }
        return curr.val;
    }
    
    public String forward(int steps) {
        while ( curr.next != null && steps != 0 ) {
            curr = curr.next;
            steps--;
        }
        return curr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */