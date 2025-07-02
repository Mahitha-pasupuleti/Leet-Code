class Node {
    int key, value;
    Node next, prev;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
class LRUCache {
    private int capacity;
    Map<Integer, Node> map;
    Node front, rear;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        front = rear = null;
    }

    public void moveNodeToFront(Node curr) {
        if ( curr.prev == null ) return; // front
        if ( curr.next == null ) {
            // update rear
            Node currPrev = curr.prev;
            currPrev.next = null;
            curr.prev = null; // next already null
            rear = currPrev;
        } else {
            // If both next nad prev are not null
            Node currPrev = curr.prev;
            Node currNext = curr.next;
            currPrev.next = curr.next;
            currNext.prev = curr.prev;
            curr.next = null;
            curr.prev = null;
        }
        curr.next = front;
        front.prev = curr;
        front = curr;
    }
    
    public int get(int key) {
        if ( !map.containsKey(key) ) return -1;

        Node curr = map.get( key );
        moveNodeToFront( curr );
        return curr.value;
    }

    public void addNodeAtFront(Node curr) {
        if ( map.size() <= capacity ) {
            if ( front == null && rear == null ) front = rear = curr;
            else {
                curr.next = front;
                front.prev = curr;
                front = curr;
            }
        } else {
            curr.next = front;
            front.prev = curr;
            front = curr;

            Node rearPrev = rear.prev;
            rearPrev.next = rear.next;
            if ( rear.next != null ) {
                Node rearNext = rear.next;
                rearNext.prev = rear.prev;
            }
            rear.next = null;
            rear.prev = null;
            map.remove(rear.key);
            rear = rearPrev;
        }
    }
    
    public void put(int key, int value) {
        if ( map.containsKey(key) ) {
            Node curr = map.get(key);
            curr.value = value;
            moveNodeToFront( curr );
        }
        else {
            Node curr = new Node(key, value);
            map.put( key, curr );
            addNodeAtFront( curr );
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */