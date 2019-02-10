/*
I'm surprised this is a hard problem...
Simply transform string to double
because in case 0.9999999999 is equal to 1.0, so double comparison is much easier than processing the string.

Lesson: when doing complex number/integer/double comparison, do in number is easier.


TC: O(1)
SC: O(1)
*/
class Solution {
    public boolean isRationalEqual(String S, String T) {
        double numS = processString(S);
        double numT = processString(T);
        return Math.abs(numS-numT)<1e-12;
    }
    
    public double processString(String s) {   
        if(s.indexOf("(")==-1) {
            return Double.parseDouble(s);
        }
        String[] str = s.split("\\.");
        int first = Integer.parseInt(str[0]);
        
        int sIdx = str[1].indexOf("(");
        int eIdx = str[1].indexOf(")");
        String repeat = str[1].substring(sIdx+1, eIdx);
        String second = str[1].substring(0, sIdx);
        while(second.length()<15) {
            second += repeat;
        }
        double res = first+Double.parseDouble("0."+second);
        return res;
    }
}