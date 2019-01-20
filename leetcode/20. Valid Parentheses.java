/*
Brute Force

TC: O(n)
SC: O(n)
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c=='(' || c=='[' || c=='{') {
                stack.push(c);
            } else {
                if(stack.empty()) {
                    return false;
                }
                if(c==')') {
                    if(stack.pop()!='(') {
                        return false;
                    }
                }
                if(c==']') {
                    if(stack.pop()!='[') {
                        return false;
                    }
                }
                if(c=='}') {
                    if(stack.pop()!='{') {
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }
}