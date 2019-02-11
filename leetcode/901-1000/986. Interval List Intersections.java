/*
Sweeping line to solve the interval related problems

TC: O(nlogn)
SC: O(n)
*/
class Solution {
    
    class Point {
        int value;
        int isStart;
        
        public Point (int value, int isStart) {
            this.value = value;
            this.isStart = isStart;
        }
    }
    
    class PointComparator implements Comparator<Point> {
        public int compare(Point a, Point b) {
            if(a.value==b.value) {
                return a.isStart-b.isStart;
            }
            return a.value-b.value;
        }
    }
    
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        if(A.length==0 || B.length==0) {
            return new Interval[0];
        }
        List<Point> list = new ArrayList<>();
        for(Interval interval : A) {
            list.add(new Point(interval.start, 0));
            list.add(new Point(interval.end, 1));
        }
        for(Interval interval : B) {
            list.add(new Point(interval.start, 0));
            list.add(new Point(interval.end, 1));
        }
        Collections.sort(list, new PointComparator());
        List<Interval> res = new ArrayList<>();
        
        int start = 0;
        int count = 0;
        for(Point p : list) {
            if(p.isStart==0) {
                count++;
                if(count==2) {
                    start = p.value;
                }
            } else {
                count--;
                if(count==1) {
                    res.add(new Interval(start, p.value));
                }
            }
        }
        
        Interval[] result = new Interval[res.size()];
        for(int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
