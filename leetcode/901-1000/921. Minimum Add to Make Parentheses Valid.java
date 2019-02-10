/*
TC: O(n)
SC: O(n)
*/
public int minAddToMakeValid(String S) {
    if(S==null || S.length()==0) {
        return 0;
    }
    Stack<Character> stack = new Stack<>();
    for(char c : S.toCharArray()) {
        if(c==')' && !stack.empty() && stack.peek()=='(') {
            stack.pop();
        } else {
            stack.push(c);
        }
    }
    return stack.size();
}