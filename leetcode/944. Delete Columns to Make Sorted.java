/*
暴力大法好

TC: O(m*n) - suppose A.length==m, A[0].length()==n
SC: O(1)
*/

public int minDeletionSize(String[] A) {
    if(A==null || A.length<=1) {
        return 0;
    }
    int count = 0;
    int size = A[0].length();
    for(int j = 0; j < size; j++) {
        for(int i = 1; i < A.length; i++) {
            if(A[i].charAt(j)<A[i-1].charAt(j)) {
                count++;
                break;
            }
        }
    }
    return count;
}