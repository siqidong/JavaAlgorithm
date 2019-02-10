/*
My thought:
given array A, sort it based on the value, then use two pointers to record the left interval
so that the index in the left part must be small or equal to right.

ex:
     0  1  2  3  4
A = [5, 0, 3, 8, 6]
    [0, 3, 5, 6, 8] (after sort)

   l 0  1  2  3 => break, right = 2 => res = 3
   r 0  2  2 

TC: O(nlogn)
SC: O(n)
*/
class Point {
    int value;
    int index;
    public Point(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

class PointComparator implements Comparator<Point> {
    public int compare(Point a, Point b) {
        return a.value-b.value;
    }
}

public int partitionDisjoint(int[] A) {
    int n = A.length;
    Point[] points = new Point[n];
    for(int i = 0; i < n; i++) {
        points[i] = new Point(A[i], i);
    }
    Arrays.sort(points, new PointComparator());
    int left = 0;
    int right = 0;
    while(left<=right) {
        right = Math.max(right, points[left].index);
        left++;
    }
    return right+1;
}


/*
A brilliant solution.
REDO this method.

TC: O(n)
SC: O(1)
*/
public int partitionDisjoint(int[] a) {
    int localMax = a[0], partitionIdx = 0, max = localMax;
    for (int i = 1; i < a.length; i++) {
        if (localMax > a[i]) {
            localMax = max;
            partitionIdx = i;
        } else {
            max = Math.max(max, a[i]);
        }
    }
    return partitionIdx + 1;
}


