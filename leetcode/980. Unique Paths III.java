/*
Graph - DFS

Suppose n is the number of total points in grid
TC: O(4^n)
SC: O(n)
*/
class Solution {
    
    int n;
    int m;
    int zero;
    int start;
    int end;
    int res;
    int[] xval = new int[]{1, -1, 0, 0};
    int[] yval = new int[]{0, 0, 1, -1};
    public int uniquePathsIII(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        zero = 0;
        start = 0;
        end = 0;
        res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j]==0) {
                    zero++;
                }
                if(grid[i][j]==1) {
                    start = i*m+j;
                }
                if(grid[i][j]==2) {
                    end = i*m+j;
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        dfs(grid, start, set, visited);
        return res;
    }
    
    public void dfs(int[][] grid, int curr, Set<Integer> set, Set<Integer> visited) {
        if(curr==end) {
            if(set.size()==zero) {
                res++;
            }
            return;
        }
        int currX = curr/m;
        int currY = curr%m;
        for(int k = 0; k < 4; k++) {
            int newX = currX+xval[k];
            int newY = currY+yval[k];
            int next = newX*m+newY;
            if(newX<0 || newX>=n || newY<0 || newY>=m || grid[newX][newY]==-1 || visited.contains(next)) {
                continue;
            }
            visited.add(next);
            if(grid[newX][newY]==0) {
                set.add(next);    
            }
            dfs(grid, next, set, visited);
            visited.remove(next);
            if(grid[newX][newY]==0) {
                set.remove(next);    
            }
        }
        return;
    }
}