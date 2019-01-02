/*
														s              e
Divide the String into pieces by following the pattern [I,... I, D,... D] with start index s and end index e.
For [I, ... I] part keep increasing with value [mid+1, end]
For [D, ... D] part keep decreasing with value [start, end]
Because first is ignored, we need to add "D" at the beginning.

ex: S =   "DDD ID IIIIDD"
		  0123 45 678901
      => "DDDD|ID|IIIIDD"

part 1: S="DDDD", s = 0, e = 3 => res = [3, 2, 1, 0]
part 2: S="ID", s = 4, e = 5 => res = [5, 4]
part 3: S="IIIIDD", s = 6, e = 11 => res = [8, 9, 10, 11, 7, 6]

=> ans = [3, 2, 1, 0, 5, 4, 8, 9, 10, 11, 7, 6]

TC: O(n)
SC: O(1)
*/

public int[] diStringMatch(String S) {
    S = "D"+S;
    int n = S.length()-1;
    int[] res = new int[n+1];
    int start = 0;
    for(int i = 0; i <= n; i++) {
        if(i==n || (i<n && S.charAt(i)=='D' && S.charAt(i+1)=='I')) {
            helper(S, res, start, i);
            start = i+1;
        }
    }
    return res;
}

public void helper(String S, int[] res, int start, int end) {
    int i = start;
    int j = end;
    int k = end;
    while(k>=start && S.charAt(k)=='D') {
        res[k--] = i++;
    }
    while(k>=start && S.charAt(k)=='I') {
        res[k--] = j--;
    }
}


/*
I should have thought of this method... 留下了没技术的泪水.jpg

		   012 34 567890
ex: S =   "DDD ID IIIIDD"

min = 0, max = 11
ans = [11, 10, 9, 0, 8, 1, 2, 3, 4, 7, 6, 5]

TC: O(n)
SC: O(1)
*/

public int[] diStringMatch(String S) {
    int n = S.length();
    int[] ans = new int[n+1];
    int max = n, min = 0,pos=0;
    for(int i = 0; i < S.length();i++){
        if(S.charAt(i) == 'D') ans[pos++] = max--;
        else ans[pos++] = min++;
    }
    
    ans[pos] = min;  
    return ans;
}
