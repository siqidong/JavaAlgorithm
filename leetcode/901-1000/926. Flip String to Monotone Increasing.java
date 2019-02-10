/*
My three-pass solution.

Easy to understand.
Keep two int arrays:
prev: store how many ones before the current element
next: store how many zeros after the current element
then use a for loop to check if the current element is the first one, how many flips are needed.
the last element is in case the after flip string doesn't contain 1.

ex: S = [0 0 0 1 1 0 0 0]
  prev= [0 0 0 0 1 2 2 2  2]
  next= [5 4 3 3 3 2 1 0  0]
  flip= [6 5 4 3 4 5 4 3  2] => ans = 2

TC: O(n)
SC: O(1)
*/
public int minFlipsMonoIncr(String S) {
    int n = S.length();
    int[] prev = new int[n+1];
    int[] next = new int[n+1];
    int one = 0;
    for(int i = 0; i <= n; i++) {
        prev[i] = one;
        if(i<n && S.charAt(i)=='1') {
            one++;
        }
    }
    int zero = 0;
    for(int i = n; i >= 0; i--) {
        next[i] = zero;
        if(i<n && S.charAt(i)=='0') {
            zero++;
        }
    }
    int res = prev[n]+next[n];
    for(int i = 0; i < n; i++) {
        int temp = prev[i]+next[i];
        if(S.charAt(i)=='0') {
            temp++;
        }
        res = Math.min(res, temp);
    }
    return res;
}


/*
There is a brilliant one-pass solution.
Feels like I can't think of this one if in an interview...

TC: O(n)
SC: O(1)
*/
public int minFlipsMonoIncr(String S) {
    char[] arr = S.toCharArray();
    int one = 0, zero = 0;
    
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == '0') {
            one = Math.min(one, zero) + 1;
        } else {
            one = Math.min(one, zero);
            zero += 1;
        }
    }
    
    return (int) Math.min(one ,zero);
}