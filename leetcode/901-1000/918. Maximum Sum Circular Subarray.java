/*
One pass, store the maximum subarray sum and the minimum subarray sum.
Since the array is a circle, the circle part subarray maximum sum = total sum - minimum subarray sum.

ex:  [a0, a1, a2, a3, a4, a5, a6, a7]
 
if [3, 6] is minimum => [a7, a0, a1, a2] will be miximum in circular part.

TC: O(n)
SC: O(1)
*/
public int maxSubarraySumCircular(int[] A) {
    int total = 0;
    int min1 = 0;
    int max1 = Integer.MIN_VALUE;
    int sum1 = 0;
    int min2 = Integer.MAX_VALUE;
    int max2 = 0;
    int sum2 = 0;
    for(int num : A) {
        sum1 += num;
        max1 = Math.max(max1, sum1-min1);
        min1 = Math.min(min1, sum1);
        
        sum2 += num;
        min2 = Math.min(min2, sum2-max2);
        max2 = Math.max(max2, sum2);
        
        total += num;
    }

    if(min2==total) {
        return max1;
    }
    return Math.max(max1, total-min2);
}