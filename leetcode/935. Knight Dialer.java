/*
The chess knight is shown below:

-------------
| 1 | 2 | 3 |
-------------
| 4 | 5 | 6 |
-------------
| 7 | 8 | 9 |
-------------
    | 0 |
    -----

int[][] map = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
map表示i的下一个数字的值，0可以走到4，6；1可以走到6，8；2可以走到7，9......    

思路是：
1. 用prev记录结尾数字是i的string有多少种
2. 每一轮next，对于每个i可以走到的下一个数字j，以下一个数字j为结尾的string的个数就等于当前所有可以走到该数字的个数之和
3. 最后一轮对所有结尾i的个数求和

ex: 

结尾数字 | 现在轮个数 | 可以走的下一个数字 | 下一轮个数
   1    |    35    |    1, 2, 3      | 35
   2    |    72    |    2, 3         | 35+72
   3    |    68    |    3            | 35+72+68
   4    |    19    |    -            | 0

Modular Theorem:
(A + B) mod C = (A mod C + B mod C) mod C
(A - B) mod C = (A mod C - B mod C) mod C

Proof:
https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/modular-addition-and-subtraction

TC: O(n)
SC: O(1)
*/
public int knightDialer(int N) {
    int base = 1000000007;
    int[][] map = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
    Map<Integer, Integer> prev = new HashMap<>();
    for(int i = 0; i <= 9; i++) {
        prev.put(i, 1);
    }
    for(int i = 1; i < N; i++) {
        Map<Integer, Integer> next = new HashMap<>();
        for(int j = 0; j <= 9; j++) {
            next.put(j, 0);
        }
        for(int j = 0; j <= 9; j++) {
            int currValue = prev.get(j);
            for(int nextValue : map[j]) {
                next.put(nextValue, (next.get(nextValue)+currValue)%base);
            }
        }
        prev = next;
    }
    int res = 0;
    for(Map.Entry<Integer, Integer> entry : prev.entrySet()) {
        res += entry.getValue();
        res %= base;
    }
    return res;
}



/*
下面请欣赏自杀式DFS暴力代码。。。

TC: O(10^N)
SC: O(1)

*/
class Solution {
    int base = 1000000007;
    Map<Integer, Set<Integer>> map = new HashMap<>();
    int res = 0;
    public int knightDialer(int N) {
        map.put(0, new HashSet<>(Arrays.asList(4, 6)));
        map.put(1, new HashSet<>(Arrays.asList(6, 8)));
        map.put(2, new HashSet<>(Arrays.asList(7, 9)));
        map.put(3, new HashSet<>(Arrays.asList(4, 8)));
        map.put(4, new HashSet<>(Arrays.asList(0, 3, 9)));
        map.put(5, new HashSet<>(Arrays.asList()));
        map.put(6, new HashSet<>(Arrays.asList(0, 1, 7)));
        map.put(7, new HashSet<>(Arrays.asList(2, 6)));
        map.put(8, new HashSet<>(Arrays.asList(1, 3)));
        map.put(9, new HashSet<>(Arrays.asList(2, 4)));

        for(int i = 0; i <= 9; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            dfs(N, temp, i);
        }
        return res;
    }
    
    public void dfs(int N, List<Integer> list, int curr) {
        if(list.size()==N) {
            res++;
            res %= base;
            return;
        }
        for(int next : map.get(curr)) {
            list.add(next);
            dfs(N, list, next);
            list.remove(list.size()-1);
        }
        return;
    }
}