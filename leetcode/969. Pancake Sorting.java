/*
Pancake Sorting
Just keep flipping the largest number to the tail.
Total number of flips: 2*n (n is the length of A)

TC: O(n)
SC: O(1)
*/
class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> list = new ArrayList<>();
        int n = A.length;
        for(int i = 0; i < n; i++) {
            int index = findLargest(A, 0, n-i-1);
            list.add(index+1);
            reverse(A, 0, index);
            list.add(n-i);
            reverse(A, 0, n-i-1);
        }
        return list;
    }
    
    public int findLargest(int[] A, int start, int end) {
        int index = start;
        for(int i = start; i <= end; i++) {
            if(A[index]<A[i]) {
                index = i;
            }
        }
        return index;
    }
    
    public void reverse(int[] A, int start, int end) {
        for(int i = start, j = end; i<j; i++, j--) {
            swap(A, i, j);
        }
    }
    
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}