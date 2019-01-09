/*
Brute Force
Only need to consider min value and max value in the array.

case 1: return 0

        ^
 
  ^     .

  .     v

  v


case 2: return distance = (upper-K) - (lower+K)

        ^
 
        .

        v    --- 
              |
            distance
              |
  ^          ---

  .

  v


TC: O(n)
SC: O(1)
*/
class Solution {
    public int smallestRangeI(int[] A, int K) {
        int lower = A[0];
        int upper = A[0];
        for(int num : A) {
            lower = Math.min(num, lower);
            upper = Math.max(num, upper);
        }
        lower += K;
        upper -= K;
        return Math.max(upper-lower, 0);
    }
}