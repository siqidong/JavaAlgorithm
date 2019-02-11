/*
One pass

TC: O(n)
SC: O(n)
*/
class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        for(int num : A) {
            if(num%2==0) {
                sum += num;
            }
        }
        int n = queries.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            int[] query = queries[i];
            int val = query[0];
            int index = query[1];
            int before = A[index];
            int after = A[index]+val;
            if(before%2==0) {
                sum -= before;
            }
            if(after%2==0) {
                sum += after;
            }
            res[i] = sum;
            A[index] += val;
        }
        return res;
    }
}