//Use Union Find.

//TC: O((3*n)^2) - n is equal to grid.length
/*when creating the augmented array from grid, for each char in grid string, use a 3*3 matrix to represent the value.

if grid[i][j] = ' ',  use: 000
                           000
                           000
if grid[i][j] = '/',  use: 001
                           010
                           100
if grid[i][j] = '\\', use: 200
                           020
                           002
(here use '\\' to represent a single char which value is equal to '\')

For example, 
Input:
[
  "/\\",
  "\\/"
]

the augmented array will be:
[
    001|200
    010|020
    100|002
    --------
    200|001
    020|010
    002|100
]

and then count the number of "islands" that are formed by all the 0s.
which answer is 5.

*/

class Solution {
    
    class UnionFind {
        int[] father;
        int count;
        
        public UnionFind(int n) {
            this.father = new int[n];
            for(int i = 0; i < n; i++) {
                father[i] = i;
            }
            count = n;
        }
        
        public int find(int x) {
            if(father[x]==x) {
                return x;
            }
            return father[x] = find(father[x]);
        }
        
        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if(rootA!=rootB) {
                count--;
                father[rootA] = rootB;
            }
        }
    }
    
    int totalZero;
    public int regionsBySlashes(String[] grid) {
        if(grid==null || grid.length==0) {
            return 0;
        }
        int[] xval = new int[]{1, -1, 0, 0};
        int[] yval = new int[]{0, 0, 1, -1};
        int n = grid.length;
        int size = 3*n;
        totalZero = size*size;
        int[][] augArr = convertArray(grid);
        UnionFind uf = new UnionFind(size*size);
        uf.count = totalZero;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(augArr[i][j]==0) {
                    for(int k = 0; k < 4; k++) {
                        int newx = i+xval[k];
                        int newy = j+yval[k];
                        if(newx<0 || newx>=size || newy<0 || newy>=size || augArr[newx][newy]!=0) {
                            continue;
                        }
                        uf.union(i*size+j, newx*size+newy);
                    }
                }
            }
        }
        return uf.count;
    }
    
    public int[][] convertArray(String[] grid) {
        int n = grid.length;
        int[][] arr = new int[3*n][3*n];
        for(int i = 0; i < n; i++) {
            String s = grid[i];
            int index = 0;
            for(int j = 0; j < grid[i].length(); j++) {
                if (s.charAt(j)=='/') {
                    arr[3*i][3*j+2] = 1;
                    arr[3*i+1][3*j+1] = 1;
                    arr[3*i+2][3*j] = 1;
                    totalZero -= 3;
                } else if (s.charAt(j)=='\\') {
                    arr[3*i][3*j] = 2;
                    arr[3*i+1][3*j+1] = 2;
                    arr[3*i+2][3*j+2] = 2;
                    totalZero -= 3;
                }
            }
        }
        return arr;
    }
}