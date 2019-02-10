/*
Stack & Queue

Use 2 data structures to flip the order, since queue will keep the order, so only swap() is enough.

TC: O(n)
SC: O(n)
*/
class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(queue1.size()>1) {
            queue2.offer(queue1.poll());
        }
        int value = queue1.poll();
        swap();
        return value;
    }
    
    /** Get the top element. */
    public int top() {
        while(queue1.size()>1) {
            queue2.offer(queue1.poll());
        }
        int value = queue1.poll();
        queue2.offer(value);
        swap();
        return value;
    }
    
    public void swap() {
        Queue<Integer> temp = new LinkedList<>();
        temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
