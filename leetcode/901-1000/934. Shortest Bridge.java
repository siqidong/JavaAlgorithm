/*
图论三剑客
Union Find / BFS / DFS都可以做
思路就是找到岛1的所有点，逐层外扩，直到达到岛2的任意一个点就是最短的bridge，注意答案-1（因为求的是flip的个数）

TC: O(mn)
SC: O(mn)
*/
class Solution {
    public int shortestBridge(int[][] A) {
        int[] xval = new int[]{1, -1, 0, 0};
        int[] yval = new int[]{0, 0, 1, -1};
        int n = A.length;
        int m = A[0].length;
        int num = 0;
        Set<Integer> allSet = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(A[i][j]==1) {
                    num = i*m+j;
                    allSet.add(num);
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(num);
        q.offer(num);
        set.add(num);
        visited.add(num);
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            int currX = curr/m;
            int currY = curr%m;
            for(int i = 0; i < 4; i++) {
                int newX = currX+xval[i];
                int newY = currY+yval[i];
                if(newX<0 || newX>=n || newY<0 || newY>=m || A[newX][newY]==0 || set.contains(newX*m+newY)) {
                    continue;
                }
                queue.offer(newX*m+newY);
                q.offer(newX*m+newY);
                set.add(newX*m+newY);
                visited.add(newX*m+newY);
            }
        }
        
        int res = 0;
        while(!q.isEmpty()) {
            res++;
            int size = q.size();
            for(int k = 0; k < size; k++) {
                int curr = q.poll();
                int currX = curr/m;
                int currY = curr%m;
                for(int i = 0; i < 4; i++) {
                    int newX = currX+xval[i];
                    int newY = currY+yval[i];
                    if(newX<0 || newX>=n || newY<0 || newY>=m || visited.contains(newX*m+newY)) {
                        continue;
                    }
                    if(allSet.contains(newX*m+newY)) {
                        return res-1;
                    }
                    q.offer(newX*m+newY);
                    visited.add(newX*m+newY);
                }
            }
        }
        return 0;
    }
}