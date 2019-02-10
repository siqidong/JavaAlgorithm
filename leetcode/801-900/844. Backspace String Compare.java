/*
Brute Force using Stack

TC: O(n)
SC: O(n)
*/
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        for(char c : S.toCharArray()) {
            if(c=='#') {
                if(!sStack.empty()) {
                    sStack.pop();
                }
            } else {
                sStack.push(c);
            }
        }
        for(char c : T.toCharArray()) {
            if(c=='#') {
                if(!tStack.empty()) {
                    tStack.pop();
                }
            } else {
                tStack.push(c);
            }
        }
        if(sStack.size()!=tStack.size()) {
            return false;
        }
        while(!sStack.empty()) {
            if(sStack.pop()!=tStack.pop()) {
                return false;
            }
        }
        return true;
    }
}
