//TC: O(2^N)
//SC: O(1)
class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        if(N==1) {
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        }
        Set<Integer> set = new HashSet<>();
        String one = "";
        for(int i = 1; i <= 9; i++) {
            dfs(one, i, 1, N, K, set);
        }
        int index = 0;
        int[] res = new int[set.size()];
        for(int num : set) {
            res[index++] = num;
        }
        return res;
    }
    
    public void dfs(String s, int curr, int i, int N, int K, Set<Integer> set) {
        if(i>N) {
            int num = Integer.parseInt(s);
            set.add(num);
            return;
        }
        if(curr+K<=9) {
            dfs(s+curr, curr+K, i+1, N, K, set);
        }
        if(curr-K>=0) {
            dfs(s+curr, curr-K, i+1, N, K, set);
        }
        return;
    }   
}