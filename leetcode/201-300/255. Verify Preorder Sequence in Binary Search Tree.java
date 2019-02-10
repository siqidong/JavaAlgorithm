/*
My idea: 
解决preorder inorder postorder存在一个数组里的问题的通用方法，就是通过index进行递归
和construct binary tree using preorder and inorder / postorder是一样的思路，暴力解。

//TODO: Summary list of the same type problems

TC: O(n^2)
SC: O(1) - which doesn't count the runtime call stack space
*/
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, preorder.length-1);
    }
    
    public boolean helper(int[] preorder, int min, int max, int start, int end) {
        if(start>end) {
            return true;
        }
        int temp = start+1;
        while(temp<=end && preorder[temp]<preorder[start]) {
            temp++;
        }
        return (min<=preorder[start] && preorder[start]<=max) &&
               helper(preorder, min, Math.min(max, preorder[start]), start+1, temp-1) && 
               helper(preorder, Math.max(min, preorder[start]), max, temp, end);
    }
}


/*
Linear Time Complexity.
Which is the same idea using stack to traverse the binary tree.

ex:        8
          / \
         4   15
        /\   / \
       1  6  9  23

A valid preorder traverse is [8, 4, 1, 6, 15, 9, 23]

stack: 8, 4, 1, (6)
       8, 6 (low = 4) (15)
       15, 9 (low = 8) (23)
       23 (low = 15)

If the current value (pre) is larger than stack.peek(), means we go to the right side of the tree.
All the right side part of the tree should be larger than the left side.
Keep variable low to record the left part's biggest number, and loop the preorder array.

TC: O(n)
SC: O(n)
*/
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int low = Integer.MIN_VALUE;
        for(int pre : preorder) {
            if(pre<low) {
                return false;
            }
            while(!stack.empty() && pre>stack.peek()) {
                low = stack.pop();
            }
            stack.push(pre);
        }
        return true;
    }
}