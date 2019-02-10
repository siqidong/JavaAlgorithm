/*
Using Array to Implement a Queue

TC: O(n)
SC: O(n)
*/
class MyCircularQueue {

    /** Initialize your data structure here. Set the size of the queue to be k. */
    int[] arr;
    int head;
    int tail;
    int k;
    public MyCircularQueue(int k) {
        this.arr = new int[k];
        this.head = 0;
        this.tail = 0;
        arr[0] = -1;
        this.k = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        if(isEmpty()) {
            arr[head] = value;
        } else {
            tail = (tail+1)%k;
            arr[tail] = value;    
        }
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
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
    
    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        return arr[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        return arr[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(arr[head]==-1) {
            return true;
        }
        return false;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if((tail+1)%k==head) {
            return true;
        }
        return false;
    }
}
