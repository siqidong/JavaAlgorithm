//LEETCODE 28
//https://leetcode.com/problems/implement-strstr/description/

//https://www.jiuzhang.com/video/rabin-karp
//TC: O(m+n) where source.length() is m, target.length() is n
//和KMP的时间复杂度是近似一样的，但是实现起来容易的多
public int strStr2(String source, String target) {
    if(source==null || target==null) {
        return -1;
    }
    int m = target.length();
    if(m==0) {
        return 0;
    }
    int BASE = 10000007;
    int power = 1;
    for(int i = 0; i < m; i++) {
        power = (power * 31)%BASE;
    }
    int hashTarget = 0;
    for(int i = 0; i < m; i++) {
        hashTarget = (hashTarget * 31 + target.charAt(i)) % BASE;
    }
    int hashSource = 0;
    for(int i = 0; i < source.length(); i++) {
        hashSource = (hashSource * 31 + source.charAt(i)) % BASE;
        if(i >= m) {
            hashSource = (hashSource - source.charAt(i-m) * power) % BASE;
            if(hashSource < 0) {
                hashSource += BASE;
            }
        }
        if(i >= m-1) {
            if(hashSource==hashTarget && source.substring(i-m+1, i+1).equals(target)) {
                return i-m+1;
            }
        }
    }
    return -1;
}