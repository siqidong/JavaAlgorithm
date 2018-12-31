/*
TC: O(n)
SC: O(1)
*/
public int[] sortArrayByParityII(int[] A) {
    int n = A.length;
    int[] res = new int[n];
    int even = 0;
    int odd = 1;
    for(int num : A) {
        if(num%2==0) {
            res[even] = num;
            even += 2;
        } else {
            res[odd] = num;
            odd += 2;
        }
    }
    return res;
}