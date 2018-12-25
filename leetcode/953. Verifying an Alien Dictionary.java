/*
暴力大法好

TC: O(mn) - suppose there are m words with length n
SC: O(1) - a total of 26 characters
*/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words==null || words.length<=1) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i+1);
        }
        for(int i = 0; i < words.length-1; i++) {
            String prev = words[i];
            String next = words[i+1];
            if(!isSmaller(prev, next, map)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isSmaller(String prev, String next, Map<Character, Integer> map) {
        int index = 0;
        while(index<prev.length() && index<next.length() && prev.charAt(index)==next.charAt(index)) {
            index++;
        }
        if(index>=prev.length() && index>=next.length()) {
            return true;
        }
        if(index>=prev.length()) {
            return true;
        }
        if(index>=next.length()) {
            return false;
        }
        return map.get(prev.charAt(index))<=map.get(next.charAt(index));
    }
}