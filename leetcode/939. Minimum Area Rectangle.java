/*
Brute Force
Loop thru the array, and assume the two points [(x1, y1), (x2, y2)] are the diagonal points 
(they cant be parallel to x-axis or y-axis)
and calculate the two others points to see if they are in the array.


TC: O(n^2)
SC: O(n)

*/

public int minAreaRect(int[][] points) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for(int[] point : points) {
        int x = point[0];
        int y = point[1];
        if(!map.containsKey(x)) {
            map.put(x, new HashSet<>());
        }
        map.get(x).add(y);
    }
    int res = Integer.MAX_VALUE;
    for(int i = 0; i < points.length; i++) {
        int x1 = points[i][0];
        int y1 = points[i][1];
        for(int j = i+1; j < points.length; j++) {
            int x2 = points[j][0];
            int y2 = points[j][1];
            if(x1==x2 || y1==y2) {
                continue;
            }
            if(!map.get(x1).contains(y2) || !map.get(x2).contains(y1)) {
                continue;
            }
            int area = Math.abs(x2-x1)*Math.abs(y2-y1);
            res = Math.min(res, area);
        }
    }
    return res==Integer.MAX_VALUE?0:res;
}