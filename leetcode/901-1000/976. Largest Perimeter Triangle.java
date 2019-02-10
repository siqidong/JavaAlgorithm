/*
Brute Force

TC: O(n^2)
SC: O(1)
*/
class Solution {
    public int largestPerimeter(int[] A) {
        if(A.length<=2) {
            return 0;
        }
        int res = 0;
        Arrays.sort(A);
        for(int i = 0; i < A.length; i++) {
            for(int last = A.length-1; last-1 > i; last--) {
                if(A[i]+A[last-1]>A[last]) {
                    res = Math.max(res, A[i]+A[last]+A[last-1]);
                }
            }
        }
        return res;
    }
}