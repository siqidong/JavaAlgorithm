/*
Two Pass

TC: O(n)
SC: O(1)
*/
class Solution {
    public boolean isMonotonic(int[] A) {
        if(A==null || A.length<=2) {
            return true;
        }
        int n = A.length;
        boolean increase = true;
        for(int i = 0; i < n-1; i++) {
            if(A[i]>A[i+1]) {
                increase = false;
                break;
            }
        }
        for(int i = 0; i < n-1; i++) {
            if(increase) {
                if(A[i]>A[i+1]) {
                    return false;
                }
            } else {
                if(A[i]<A[i+1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
