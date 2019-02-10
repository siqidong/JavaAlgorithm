/*
Simplify a Linux file path
Be causeful when there is no elements in stack, which means in the root directory, return "/"

TC: O(n)
SC: O(n)
*/
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/");
        for(String s : strs) {
            if(s.equals("") || s.equals(".")) {
                continue;
            } else if(s.equals("..")) {
                if(!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
            System.out.println(s);
        }
        if(stack.empty()) {
            return "/";
        }
        Stack<String> temp = new Stack<>();
        while(!stack.empty()) {
            temp.push(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!temp.empty()) {
            sb.append('/');
            sb.append(temp.pop());
        }
        return sb.toString();
    }
}