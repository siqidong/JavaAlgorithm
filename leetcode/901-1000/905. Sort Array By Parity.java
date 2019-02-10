/*
Two pointers one pass

TC: O(n)
SC: O(1)
*/
public int[] sortArrayByParity(int[] A) {
    int n = A.length;
    int[] res = new int[n];
    int i = 0;
    int j = n-1;
    for(int k = 0; k < n; k++) {
        if(A[k]%2==0) {
            res[i++] = A[k];
        } else {
            res[j--] = A[k];
        }
    }
    return res;
}