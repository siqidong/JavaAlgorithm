/*
K closest - Priority Queue

TC: O(Klogn)
SC: O(K)
*/
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Queue<int[]> pq = new PriorityQueue<>(K, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                double disA = Math.hypot(a[0], a[1]);
                double disB = Math.hypot(b[0], b[1]);
                return disA>disB?-1:1;
            }
        });
        for(int[] point : points) {
            pq.offer(point);
            if(pq.size()>K) {
                pq.poll();
            }
        }
        int[][] res = new int[pq.size()][2];
        int index = 0;
        while(!pq.isEmpty()) {
            res[index++] = pq.poll();
        }
        return res;
    }
}