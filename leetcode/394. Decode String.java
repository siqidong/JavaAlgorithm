/*
Using stack to decode string.

Be careful to handle the case where stack.pop() when stack is empty;
and be caureful to handle case where substring maybe reversed when poping out from the stack.

TC: O(n)
SC: O(n)
*/
class Solution {
    public String decodeString(String s) {
        Stack<Object> stack = new Stack<>();
        int number = 0;
        for(char c : s.toCharArray()) {
            if(c=='[') {
                stack.push(number);
                number = 0;
            } else if (c==']') {
                String sub = getSubstring(stack);
                int time = (int)stack.pop();
                for(int k = 0; k < time; k++) {
                    for(char h : sub.toCharArray()) {
                        stack.push(h);
                    }
                }
            } else if ('0'<=c && c<='9') {
                number = 10*number+(c-'0');
            } else {
                stack.push(c);
            }
        }
        String res = getSubstring(stack);
        return res;
    }
    
    public String getSubstring(Stack<Object> stack) {
        StringBuilder sb = new StringBuilder();
        while(!stack.empty() && stack.peek() instanceof Character) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
