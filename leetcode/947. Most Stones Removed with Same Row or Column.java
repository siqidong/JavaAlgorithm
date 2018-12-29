/*
Union Find
My solution:
This is simply a problem we need to category the points into different set.
For each two points, if they have same x-axis or y-axis, they belong to the same set.
For each set, only one point is left after picking up all the others.
So the solution is total number of points minus the number of sets.


TC: O(n^2)
SC: O(n)
*/
class Solution {
    class UnionFind {
        int[] father;
        int count;
        
        public UnionFind(int n) {
            this.father = new int[n];
            this.count = n;
            for(int i = 0; i < n; i++) {
                father[i] = i;
            }
        }
        
        public int find(int x) {
            if(father[x]==x) {
                return x;
            }
            return father[x] = find(father[x]);
        }
        
        public void connect(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if(rootA!=rootB) {
                father[rootA] = rootB;
                count--;
            }
        }
    }
    public int removeStones(int[][] stones) {
        if(stones==null || stones.length==0) {
            return 0;
        }
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n; i++) {
            int[] curr1 = stones[i];
            for(int j = 0; j < n; j++) {
                int[] curr2 = stones[j];
                if(curr1[0]==curr2[0] || curr1[1]==curr2[1]) {
                    uf.connect(i, j);
                }
            }
        }
        return n-uf.count;
    }
}


/*
下面又是位运算骚操作TC变成O(n)的解法.
REDO this solution after review bit manipulation.

TC: O(n)
SC: O(n)
*/

Map<Integer, Integer> f = new HashMap<>();
int islands = 0;

public int removeStones(int[][] stones) {
    for (int i = 0; i < stones.length; ++i)
        union(stones[i][0], ~stones[i][1]); // ~按位取反，~x = -x-1
    return stones.length - islands;
}

public int find(int x) {
    if (f.putIfAbsent(x, x) == null)
        islands++;
    if (x != f.get(x))
        f.put(x, find(f.get(x)));
    return f.get(x);
}

public void union(int x, int y) {
    x = find(x);
    y = find(y);
    if (x != y) {
        f.put(x, y);
        islands--;
    }
}

/*
也可以用dfs解，dfs每次搜索把相同x值和y值的点删掉，再走下一个点.

TC: O(n^2)
SC: O(n)
*/
class Solution {
    // Ans = # of stones – # of islands
    public int removeStones(int[][] stones) {
        Set<int[]> visited = new HashSet();
        int numOfIslands = 0;
        for (int[] s1:stones){
            if (!visited.contains(s1)){
               dfs(s1, visited, stones); 
               numOfIslands++;
            }
        }
        return stones.length - numOfIslands;
    }
    
    private void dfs(int[] s1, Set<int[]> visited, int[][] stones){
        visited.add(s1);
        for (int[] s2: stones){
            if (!visited.contains(s2)){
                if (s1[0] == s2[0] || s1[1] == s2[1])
                    dfs(s2, visited, stones);
            }
        }
    }
}