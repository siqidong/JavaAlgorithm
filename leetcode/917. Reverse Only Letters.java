/*
暴力大法好

TC: O(n)
SC: O(n)
*/

public String reverseOnlyLetters(String S) {
    if(S==null || S.length()<=1) {
        return S;
    }
    StringBuilder sb = new StringBuilder();
    for(char c : S.toCharArray()) {
        if(Character.isLetter(c)) {
            sb.append(c);
        }
    }
    String reverse = sb.reverse().toString();
    int index = 0;
    StringBuilder res = new StringBuilder();
    for(int i = 0; i < S.length(); i++) {
        if(!Character.isLetter(S.charAt(i))) {
            res.append(S.charAt(i));
        } else {
            res.append(reverse.charAt(index++));
        }
    }
    return res.toString();
}