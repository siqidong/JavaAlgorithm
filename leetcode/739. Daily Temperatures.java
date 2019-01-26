/*
Keep a index stack to maintain a increasing stack.
The stack only contains the index, so to calculate the distance (number of days to wait) for a higher value. 

TC: O(n)
SC: O(n)
*/
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i >= 0; i--) {
            while(!stack.empty() && T[stack.peek()]<=T[i]) {
                stack.pop();
            }
            if(stack.empty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek()-i;
            }
            stack.push(i);
        }
        return res;
    }
}
