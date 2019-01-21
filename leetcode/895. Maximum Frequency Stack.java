/*
Use Priority Queue and Map to implement a Frequency Stack.

TC: O(nlogn)
SC: O(n)
*/
class FreqStack {
    
    class Point {
        int value;
        int count;
        int time;
        public Point (int value, int count, int time) {
            this.value = value;
            this.count = count;
            this.time = time;
        }
    }
    
    class PointComparator implements Comparator<Point>{
        public int compare(Point a, Point b) {
            if(a.count==b.count) {
                return b.time-a.time;
            }
            return b.count-a.count;
        }
    }
    
    
    int timeStamp;
    Map<Integer, Integer> map;
    Queue<Point> queue;
    
    public FreqStack() {
        this.timeStamp = 0;
        this.map = new HashMap<>();
        this.queue = new PriorityQueue<>(new PointComparator());
    }
    
    public void push(int x) {
        timeStamp++;
        map.put(x, map.getOrDefault(x, 0)+1);
        queue.offer(new Point(x, map.get(x), timeStamp));
    }
    
    public int pop() {
        Point curr = queue.poll();
        int value = curr.value;
        map.put(value, map.get(value)-1);
        return value;
    }
}
