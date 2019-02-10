/*
Brute Force

TC: O(n)
SC: O(n)
*/
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int n = A.length;
        int addNum = K;
        for(int i = n-1; i>=0; i--) {
            addNum += A[i];
            res.add(addNum%10);
            addNum /= 10;
        }
        while(addNum>0) {
            res.add(addNum%10);
            addNum /= 10;
        }
        Collections.reverse(res);
        return res;
    }
}
