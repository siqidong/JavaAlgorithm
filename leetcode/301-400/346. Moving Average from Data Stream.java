/*
Queue

TC: O(n)
SC: O(size)
*/
class MovingAverage {

    /** Initialize your data structure here. */
    Queue<Integer> queue;
    int size;
    double sum;
    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
        this.sum = 0.0;
    }
    
    public double next(int val) {
        queue.offer(val);
        sum += val;
        if(queue.size()>size) {
            int last = queue.poll();
            sum -= last;
        }
        return sum/queue.size();
    }
}
