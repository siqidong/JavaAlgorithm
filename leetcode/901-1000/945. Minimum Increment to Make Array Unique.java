/*
Sort the array, then we need to guarantee that the element is greater than its previous element by 1.

need: the value the next element "should be", which is the current set number +1
res: add the move for each number, if need-num is <0, means the current value is greater than it should be

  ex: [0, 2, 2, 2, 7]
 res: [0, 0, 1, 3, 3] => res = 3
need: [1, 3, 4, 5, 8]

TC: O(nlogn)
SC: O(1)
*/
public int minIncrementForUnique(int[] A) {
    Arrays.sort(A);
    int res = 0;
    int need = 0;
    for(int num : A) {
        res += Math.max(need-num, 0);
        need = Math.max(need, num)+1;
    }
    return res;
}