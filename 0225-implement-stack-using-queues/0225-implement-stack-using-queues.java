/**
 * Short Notes:
 * Implementing a stack using two queues.
 * - push(x): enqueue into 'first' (O(1))
 * - pop(): dequeue all but the last from 'first' to 'second' to simulate LIFO (O(n))
 * - top(): similar to pop but keeps all elements (O(n))
 * - empty(): checks if the 'first' queue is empty (O(1))
 * 
 * Time Complexity:
 * push: O(1)
 * pop: O(n)
 * top: O(n)
 * empty: O(1)
 * 
 * Space Complexity:
 * O(n) - where n is the number of elements in the stack
 */

class MyStack {
    private Queue<Integer> first;
    private Queue<Integer> second;

    // Constructor: initialize two queues
    public MyStack() {
        first = new LinkedList<>();
        second = new LinkedList<>();
    }

    // Push element onto the stack
    public void push(int x) {
        first.add(x); // Enqueue to first queue (O(1))
    }

    // Removes and returns the top element of the stack
    public int pop() {
        int popElement = 0;

        // Move all elements except the last to 'second' queue
        while (!first.isEmpty()) {
            popElement = first.poll();
            if (!first.isEmpty()) {
                second.add(popElement);
            }
        }

        // Move back elements from 'second' to 'first'
        while (!second.isEmpty()) {
            first.add(second.poll());
        }

        return popElement; // Last polled is the top element (LIFO behavior)
    }

    // Returns the top element without removing it
    public int top() {
        int topElement = 0;

        // Move all elements to 'second', while tracking the last one
        while (!first.isEmpty()) {
            topElement = first.poll();
            second.add(topElement);
        }

        // Restore the elements back to 'first'
        while (!second.isEmpty()) {
            first.add(second.poll());
        }

        return topElement;
    }

    // Returns true if the stack is empty
    public boolean empty() {
        return first.isEmpty(); // Check if queue is empty (O(1))
    }
}