/*
Stack & Queue

Use 2 data structures to flip the order in each turn

TC: O(n)
SC: O(n)
*/
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(stack1.size()>1) {
            stack2.push(stack1.pop());
        }
        int value = stack1.pop();
        while(!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return value;
    }
    
    /** Get the front element. */
    public int peek() {
        while(stack1.size()>1) {
            stack2.push(stack1.pop());
        }
        int value = stack1.peek();
        while(!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return value;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty();
    }
}