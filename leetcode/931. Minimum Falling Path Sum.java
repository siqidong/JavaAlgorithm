/*
A no brainer DP
I can improve the space complexity to O(m) by replacing it with a temp[m] every loop, but I'm too lazy to do that.

TC: O(nm)
SC: O(nm) -> O(m)
*/
public int minFallingPathSum(int[][] A) {
    int n = A.length;
    int m = A[0].length;
    int[][] dp = new int[n][m];
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            dp[i][j] = i==0?A[0][j]:Integer.MAX_VALUE;
        }
    }
    for(int i = 1; i < n; i++) {
        for(int j = 0; j < m; j++) {
            int prev = j==0?Integer.MAX_VALUE:dp[i-1][j-1];
            int now = dp[i-1][j];
            int next = j==(m-1)?Integer.MAX_VALUE:dp[i-1][j+1];
            dp[i][j] = A[i][j] + Math.min(prev, Math.min(now, next));
        }
    }
    int res = Integer.MAX_VALUE;
    for(int j = 0; j < m; j++) {
        res = Math.min(res, dp[n-1][j]);
    }
    return res;
}