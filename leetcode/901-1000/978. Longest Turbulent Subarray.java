/*
Brute Force

TC: O(n)
SC: O(n)
*/
class Solution {
    public int maxTurbulenceSize(int[] A) {
        int n = A.length;
        if(n==1) {
            return 1;
        }
        int[] compare = new int[n-1];
        for(int i = 0; i < n-1; i++) {
            if(A[i]<A[i+1]) {
                compare[i] = -1;
            } else if (A[i]>A[i+1]) {
                compare[i] = 1;
            }
        }
        int[] count = new int[n-1];
        count[0] = 1;
        int max = 1;
        for(int i = 1; i < n-1; i++) {
            if(compare[i] == (0-compare[i-1])) {
                count[i] = count[i-1]+1;
            } else {
                count[i] = 1;
            }
            max = Math.max(max, count[i]);
        }
        return max+1;
    }
}