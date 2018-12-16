//LEETCODE 28
//https://leetcode.com/problems/implement-strstr/description/

//用substring()
//TC: O(m*n), assume haystack.length()==m and needle.length()==n
public int strStr(String haystack, String needle) {
	if(needle==null || needle.length()==0) {
	    return 0;
	}
	if(haystack==null || haystack.length()<needle.length()) {
	    return -1;
	}
	for(int i = 0; i <= haystack.length()-needle.length(); i++) {
	    String sub = haystack.substring(i, i+needle.length());
	    if(sub.equals(needle)) {
	        return i;
	    }
	}
	return -1;
}

//没有用substring()
//TC: O(m*n)
public int strStr(String haystack, String needle) {
    if(needle==null || needle.length()==0) {
        return 0;
    }
    if(haystack==null || haystack.length()<needle.length()) {
        return -1;
    }
    for(int i = 0; i <= haystack.length()-needle.length(); i++) {
        int j = 0;
        for(; j < needle.length(); j++) {
            if(haystack.charAt(i+j)!=needle.charAt(j)) {
                break;
            }
        }
        if(j==needle.length()) {
            return i;
        }
    }
    return -1;
}

//其它最优算法还有KMP, Boyer-Moore, Rabin-Karp
