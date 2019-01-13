/*
求解关于subarray sum类型的问题时，最常用的技巧先求pre sum
本题一开始的想法是preSum, 然后遍历i和j，判断preSum[i]-preSum[j]是否被k整除
然而这种算法的时间复杂度是O(n^2)

很容易想到如果preSum[0, i]和preSum[0, j] 都可以被k整除的话 => preSum[i, j]可以被k整除，
但这样依然要从0开始loop

再进一步，会想到：
preSum[0, i] % K == x |  => preSum[i, j]可以被k整除
preSum[0, j] % K == x |  

所以对于每一个preSum[0, i],只要看在i之前有多少preSum[0, i*]，mod K值相同

TC: O(n)
SC: O(K)
*/
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for(int num : A) {
            sum = (sum+num)%K;
            if(sum<0) {
                sum += K;
            }
            res += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}