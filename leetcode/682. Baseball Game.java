/*
Stack

TC: O(n)
SC: O(n)
*/
class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for(String op : ops) {
            if(op.equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2);
                stack.push(num1);
                stack.push(num1+num2);
            } else if (op.equals("D")) {
                int num1 = stack.pop();
                stack.push(num1);
                stack.push(2*num1);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        int res = 0;
        while(!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }
}
