/*
Keep a list to store the number of 0s between each 1.
To calculate the number of subarrays:
only need to multiply the 0s around.

ex:
A = [0 0 1 0 0 0 1 0], S = 2
    [-------------]
      [-----------]
        [---------]
    [---------------]
      [-------------]
        [-----------]

        0 1 2
list = (2 3 1) => res = (2+1)*(1+1) = 6

if S==0, calculate the 0s: for each 0: res += n*(n+1)/2 (n is the number of 0s between each 1)

TC: O(n)
SC: O(n)
*/
    
public int numSubarraysWithSum(int[] A, int S) {
    if(A==null || A.length==0) {
        return 0;
    }
    List<Integer> list = new ArrayList<>();
    int count = 0;
    for(int num : A) {
        if(num==1) {
            list.add(count);
            count = 0;
        } else {
            count++;
        }
    }
    list.add(count);
    if(S>=list.size()) {
        return 0;
    }
    int res = 0;
    if(S==0) {
        for(int num : list) {
            res += num*(num+1)/2;
        }
        return res;
    }
    for(int i = 0; i+S < list.size(); i++) {
        int prod = (list.get(i)+1)*(list.get(i+S)+1);
        res += prod;
    }
    return res;
}


/*
The following is a really brilliant solution from @lee215
I don't think I can come up with this elegant code...
so simply mobaidashen
*/
public int numSubarraysWithSum(int[] A, int S) {
    int psum = 0, res = 0, count[] = new int[A.length + 1];
    count[0] = 1;
    for (int i : A) {
        psum += i;
        if (psum >= S)
            res += count[psum - S];
        count[psum]++;
    }
    return res;
}