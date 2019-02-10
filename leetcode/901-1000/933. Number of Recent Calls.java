/*
TC: O(n)
SC: O(n)
*/

class RecentCounter {

    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        int lower = t-3000;
        while(!queue.isEmpty() && queue.peek()<lower) {
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }
}