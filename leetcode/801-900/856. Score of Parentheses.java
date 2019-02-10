/*
Brute Force

Using a stack to keep track of the elements in the string S.
For example: S = "(()(()))"
stack = (
        ((      
        (1       next char is ), push 1 to stack
        (1(      
        (1((   
        (1(1     next char is ), push 1 to stack
        (1 2     next char is ), total = 1, push 2*total = 2 to stack
        6        next char is ), total = 3, push 2*total = 2*3 = 6 to stack 

TC: O(n)
SC: O(n)
*/
class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Object> stack = new Stack<>();
        for(char c : S.toCharArray()) {
            if(c=='(') {
                stack.push(c);
            } else {
                if(stack.empty()) {
                    return -1;
                }
                if(stack.peek() instanceof Character) {
                    stack.pop();
                    stack.push(1);
                } else {
                    int total = 0;
                    while(!stack.empty() && stack.peek() instanceof Integer) {
                        total += (int)stack.pop();
                    }
                    stack.pop();
                    stack.push(2*total);
                }
            }
        }
        int sum = 0;
        while(!stack.empty()) {
            sum += (int)stack.pop();
        }
        return sum;
    }
}
