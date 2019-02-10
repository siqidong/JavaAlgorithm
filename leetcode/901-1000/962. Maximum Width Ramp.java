/*
Method 1: Brute Force
Too naive, no explanation...
TC: O(n^2)
SC: O(1)
*/
public int maxWidthRamp(int[] A) {
    int res = 0;
    for(int i = 0; i < A.length; i++) {
        int j = 0;
        while(j < i && A[j]>A[i]) {
            j++;
        }
        if(j < i) {
            res = Math.max(res, i-j);
        }
    }
    return res;
}

/*
Method 2: Monotonous Stack
Keep a decreasing stack (only keeps the index, because we can use index to find the value, but not vice versa), 
and compare from last number to first number
     0  1  2  3  4  5
ex: [6, 0, 8, 2, 1, 5]

stack:  [0, 1]
(value): 6  0

compare 5: stack pop 1, res = 4
compare 1: stack no pop, res = 4
compare 2: stack no pop, res = 4
compare 8: stack pop 0, res = Math.max(4, 2-0) = 4
compare 0: stack is empty
compare 6: stack is empty
=> res = 4

Because the stack pops up element if A[stack.peek()]<=A[i], so in the case: 

ex: [6, 7, 2]
2 will always be poped out from stack before compare 7.
so the element we are comparing are always the values before this element.

TC: O(n)
SC: O(n)
*/
public int maxWidthRamp(int[] A) {
    int res = 0;
    Stack<Integer> stack = new Stack<>();
    for(int i = 0; i < A.length; i++) {
        if(stack.empty() || A[stack.peek()]>A[i]) {
            stack.push(i);
        }
    }
    for(int i = A.length-1; i>=res; i--) {
        while(!stack.empty() && A[stack.peek()]<=A[i]) {
            res = Math.max(res, i-stack.pop());
        }
    }
    return res;
}


