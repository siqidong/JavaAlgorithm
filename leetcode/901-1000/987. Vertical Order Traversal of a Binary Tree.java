/*
Using TreeMap for vertical order traversal 

TC: O(n)
SC: O(n)
*/
class Solution {
    
    class Point {
        int y;
        int value;
        
        public Point(int y, int value) {
            this.y = y;
            this.value = value;
        }
    }
    
    class PointComparator implements Comparator<Point> {
        public int compare(Point a, Point b) {
            if(a.y==b.y) {
                return a.value-b.value;
            }
            return b.y-a.y;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Point>> map = new TreeMap<>();
        helper(map, root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer, List<Point>> entry : map.entrySet()) {
            List<Point> list = entry.getValue();
            Collections.sort(list, new PointComparator());
            List<Integer> one = new ArrayList<>();
            for(Point p : list) {
                one.add(p.value);
            }
            res.add(one);
        }
        return res;
    }
    
    public void helper(Map<Integer, List<Point>> map, TreeNode root, int x, int y) {
        if(root==null) {
            return;
        }
        if(!map.containsKey(x)) {
            map.put(x, new ArrayList<>());
        }
        map.get(x).add(new Point(y, root.val));
        helper(map, root.left, x-1, y-1);
        helper(map, root.right, x+1, y-1);
    }
}
