/*
Proof:
https://leetcode.com/problems/broken-calculator/discuss/234526/Simple-recursive-solution-considering-only-last-bit-(and-proof-why-it's-guranteed-shortest-path)

TC: O(n)
SC: O(n)
*/
class Solution {
    public int brokenCalc(int X, int Y) {
        if(X==Y) {
            return 0;
        }
        if(X>Y) {
            return X-Y;
        }
        if((Y&1)==1) {
            return 1+brokenCalc(X, Y+1);
        } else {
            return 1+brokenCalc(X, Y/2);
        }
    }
}
