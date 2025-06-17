/**
 * Short Notes:
 * Implementing a Queue using two Stacks.
 * - push(x): Push directly to stack 'first' (O(1))
 * - pop(): Move all elements to 'second' to access front, pop it, then restore (O(n))
 * - peek(): Same as pop but without removing the front element (O(n))
 * - empty(): Check if 'first' is empty (O(1))
 * 
 * Time Complexity:
 * push: O(1)
 * pop: O(n)
 * peek: O(n)
 * empty: O(1)
 * 
 * Space Complexity:
 * O(n) - n is number of elements stored in stacks
 */

class MyQueue {
    private Stack<Integer> first;   // Main stack to hold elements
    private Stack<Integer> second;  // Temporary stack used for reversing

    // Constructor: initialize both stacks
    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }

    // Push element to the back of the queue
    public void push(int x) {
        first.push(x);  // Simply push to 'first' stack
    }

    // Removes the element from the front of the queue and returns it
    public int pop() {
        int popElement = 0;

        // Move all elements to 'second' to access front element
        while (!first.isEmpty()) {
            popElement = first.pop();
            if (!first.isEmpty()) {
                second.push(popElement);  // Only push to second if it's not the last element
            }
        }

        // Restore elements back to 'first'
        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return popElement;  // This was the front element of the queue
    }

    // Get the front element without removing it
    public int peek() {
        int popElement = 0;

        // Move all elements to 'second' to access the front element
        while (!first.isEmpty()) {
            popElement = first.pop();
            second.push(popElement);
        }

        // Restore elements back to 'first'
        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return popElement;  // This is the front element
    }

    // Return whether the queue is empty
    public boolean empty() {
        return first.isEmpty();  // O(1) check
    }
}