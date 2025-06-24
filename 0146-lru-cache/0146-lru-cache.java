class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail; // dummy head and tail

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        head = new Node(0, 0);
        tail = new Node(0, 0);
        
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        moveToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToTail(node);
        } else {
            if (map.size() == capacity) {
                Node lru = head.next;
                remove(lru);
                map.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertToTail(newNode);
        }
    }

    private void moveToTail(Node node) {
        remove(node);
        insertToTail(node);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToTail(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }
}
