/*
暴力大法好

TC: O(n)
SC: O(1)
*/

public boolean validMountainArray(int[] A) {
    if(A==null || A.length<=2) {
        return false;
    }
    int n = A.length;
    int index = 1;
    while(index<n && A[index]>A[index-1]) {
        index++;
    }
    if(index==1 || index==n) {
        return false;
    }
    while(index<n && A[index]<A[index-1]) {
        index++;
    }
    if(index<n) {
        return false;
    }
    return true;
}