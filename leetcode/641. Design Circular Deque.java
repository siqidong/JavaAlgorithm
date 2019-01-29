/*
Using array to implement a fixed size Deque.

TC: O(n)
SC: O(n)
*/
class MyCircularDeque {

    /** Initialize your data structure here. Set the size of the deque to be k. */
    int[] arr;
    int k;
    int head;
    int tail;
    public MyCircularDeque(int k) {
        this.arr = new int[k];
        this.k = k;
        this.head = 0;
        this.tail = 0;
        arr[head] = -1;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) {
            return false;
        }
        if(head==tail && arr[head]==-1) {
            arr[head] = value;
        } else {
            head = (head-1)%k;
            if(head<0) {
                head += k;
            }
            arr[head] = value;
        }
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }
        if(head==tail && arr[head]==-1) {
            arr[head] = value;
        } else {
            tail = (tail+1)%k;
            arr[tail] = value;
        }
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }
        if(head==tail) {
            arr[head] = -1;
        } else {
            head = (head+1)%k;    
        }
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }
        if(head==tail) {
            arr[head] = -1;
        } else {
            tail = (tail-1)%k; 
            if(tail<0) {
                tail += k;
            }
        }
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) {
            return -1;
        }
        return arr[head];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()) {
            return -1;
        }
        return arr[tail];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(head==tail && arr[head]==-1) {
            return true;
        }
        return false;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if(head==(tail+1)%k) {
            return true;
        }
        return false;
    }
}
