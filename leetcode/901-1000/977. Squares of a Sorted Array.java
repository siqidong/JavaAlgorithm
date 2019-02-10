/*
Bucket Sort

TC: O(n)
SC: O(1) - since we are given -10000 <= A[i] <= 10000, so this can be seen as a constant.
*/
class Solution {
    public int[] sortedSquares(int[] A) {
        int[] count = new int[10001];
        for(int i = 0; i < A.length; i++) {
            count[Math.abs(A[i])]++;
        }
        int[] res = new int[A.length];
        int index = 0;
        for(int i = 0; i < 10001; i++) {
            for(int j = 0; j < count[i]; j++) {
                res[index++] = i*i;
            }
        }
        return res;
    }
}