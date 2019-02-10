/*
Easy version of RPN

TC: O(n)
SC: O(n)
*/
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            if(token.equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2+num1);
            } else if (token.equals("-")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2-num1);
            } else if (token.equals("*")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2*num1);
            } else if (token.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2/num1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
