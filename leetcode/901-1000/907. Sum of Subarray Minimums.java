/*
To calculate the total sum of min in every subarray, need to know for each number, how many numbers in the left
are  bigger than current value, and how many numbers in the right are bigger than current value.

For example, 
  arr = [5, 2, 3, 1, 6, 4]
 left = [0, 1, 0, 2, 0, 1]
right = [0, 1, 0, 2, 0, 1]

for min is 5: number of subarray = (0+1)*(0+1) = 1
for min is 2: number of subarray = (1+1)*(1+1) = 4
for min is 3: number of subarray = (0+1)*(0+1) = 1
for min is 1: number of subarray = (2+1)*(2+1) = 9
for min is 6: number of subarray = (0+1)*(0+1) = 1
for min is 4: number of subarray = (1+1)*(1+1) = 4

To avoid count the same number again:

for example, arr = [5, 2, 3, 2]
need to calculate > A[i] when calculating the left part,
and calculate >= A[i] when calculating the right part,
otherwise subarray [2, 3, 2] will be counted twice.

TC: O(n)
SC: O(n)
*/
class Solution {
    public int sumSubarrayMins(int[] A) {
        int base = 1000000007;
        Stack<int[]> stack = new Stack<>();
        int n = A.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0; i < n; i++) {
            int count = 0;
            while(!stack.empty() && stack.peek()[0]>A[i]) {
                count += stack.pop()[1];
            }
            stack.push(new int[]{A[i], count+1});
            left[i] = count;
        }
        stack = new Stack<>();
        for(int i = n-1; i >= 0; i--) {
            int count = 0;
            while(!stack.empty() && stack.peek()[0]>=A[i]) {
                count += stack.pop()[1];
            }
            stack.push(new int[]{A[i], count+1});
            right[i] = count;
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            res += A[i]*(left[i]+1)*(right[i]+1);
            res %= base;
        }
        return res;
    }
}


/*
My Brute Force Solution... TLE

TC: O(n^2)
SC: O(n)
*/
class Solution {
    public int sumSubarrayMins(int[] A) {
        int base = 1000000007;
        int n = A.length;
        int res = 0;
        for(int i = 0; i < n; i++) {
            Stack<Integer> stack = new Stack<>();
            for(int j = i; j < n; j++) {
                if(stack.empty() || A[j]<stack.peek()) {
                    stack.push(A[j]);
                }    
                res += stack.peek();
                res %= base;
            }
        }
        return res%base;
    }
}
