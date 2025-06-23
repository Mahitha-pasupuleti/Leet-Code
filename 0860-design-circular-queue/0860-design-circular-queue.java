class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}
class MyCircularQueue {
    private int maxSize;
    private Node front, rear;
    private int count = 0;

    public MyCircularQueue(int k) {
        this.maxSize = k;
        front = null;
        rear = front;
    }
    
    public boolean enQueue(int value) {
        if ( !isFull() ) {
            Node newNode = new Node(value);
            count++;
            if ( front == null ) {
                front = newNode;
                rear = front;
            } else {
                rear.next = newNode;
                rear = rear.next;
                rear.next = front; // circular LL
            }
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if ( isEmpty() ) return false;
        if ( front == rear ) {
            front = rear = null;
        } else {
            front = front.next;
            rear.next = front;  // circular LL
        }
        count--;
        return true;
    }
    
    public int Front() {
        if ( front != null ) return front.val;
        return -1;
    }
    
    public int Rear() {
        if ( rear != null ) return rear.val;
        return -1;
    }
    
    public boolean isEmpty() {
        if ( count == 0 ) return true;
        return false;
    }
    
    public boolean isFull() {
        if ( count == maxSize ) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */