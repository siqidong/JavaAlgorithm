//LEETCODE 8
//https://leetcode.com/problems/string-to-integer-atoi/description/

//TC: O(n)
public int myAtoi(String str) {
    long tempNum = 0;
    boolean isNegative = false;
    int index = 0;
    while(index<str.length() && str.charAt(index)==' ') {
        index++;
    }
    if(index>=str.length() || !(str.charAt(index)=='+' || str.charAt(index)=='-' || Character.isDigit(str.charAt(index)))) {
        return 0;
    }
    if(str.charAt(index)=='-') {
        isNegative = true;
    }
    if(str.charAt(index)=='+' || str.charAt(index)=='-') {
        index++;
    }
    while(index<str.length() && Character.isDigit(str.charAt(index))) {
        tempNum = 10*tempNum+(str.charAt(index)-'0');
        index++;
        if(tempNum>Integer.MAX_VALUE) {
            return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
    }
    int res = (int)tempNum;
    return isNegative?-res:res;
}