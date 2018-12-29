/*
My brute force DFS solution got TLE at 57/147... 嘤嘤嘤(╥﹏╥)

TC: O(2^n)
SC: O(n)
*/
public int bagOfTokensScore(int[] tokens, int P) {
    if(tokens==null || tokens.length==0) {
        return 0;
    }
    int res = 0;
    boolean[] visited = new boolean[tokens.length];
    res = dfs(tokens, visited, P, 0);
    return res;
}

public int dfs(int[] tokens, boolean[] visited, int power, int point) {
    int res = point;
    for(int i = 0; i < tokens.length; i++) {
        if(visited[i]) {
            continue;
        }
        visited[i] = true;
        if(power>=tokens[i]) {
            res = Math.max(res, dfs(tokens, visited, power-tokens[i], point+1));
        }
        if(point>=1) {
            res = Math.max(res, dfs(tokens, visited, power+tokens[i], point-1));    
        }
        visited[i] = false;
    }
    return res;
}


/*
GREEDY
Think this question as "you use tokens to buy points" problem, so always buy the points when its cheap,
and sell the points when its expensive.

TC: O(nlogn)
SC: O(1)
*/
public int bagOfTokensScore(int[] tokens, int P) {
    Arrays.sort(tokens);
    int i = 0;
    int j = tokens.length-1;
    int point = 0;
    int res = 0;
    while(i<=j) {
        if(tokens[i]<=P) {
            P -= tokens[i++];
            point++;
            res = Math.max(res, point);
        } else if (point>0) {
            point--;
            P += tokens[j--];
        } else {
            break;
        }
    }
    return res;
}

//原来greedy可以O(nlogn)，被自己蠢哭。。