//Because cells.length == 8, there are at most 2^8 = 256 states.
//Record the state and the index N, if encounter the same state again, just do a mod operation.
//TC: O(1)
//SC: O(1) --- at most 256 times.

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> map = new HashMap<>();
        String currState = convertString(cells);
        map.put(currState, N);
        while(N>0) {
            N--;
            String nextState = getNextState(currState);
            if(map.containsKey(nextState)) {
                N = N%(N-map.get(nextState));
            } else {
                map.put(nextState, N);
            }
            currState = nextState;
        }
        return convertArray(currState);
    }
    
    public String getNextState(String currState) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < currState.length(); i++) {
            if(i==0 || i==currState.length()-1) {
                sb.append('0');
            } else {
                char c = currState.charAt(i-1)==currState.charAt(i+1)?'1':'0';
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public String convertString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int num : arr) {
            sb.append(num);
        }
        return sb.toString();
    }
    
    public int[] convertArray(String s) {
        int[] arr = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i)-'0';
        }
        return arr;
    }
}