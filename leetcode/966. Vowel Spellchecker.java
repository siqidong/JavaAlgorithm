/*
Keep three hashtable to store the processed string.
1. wordSet: all the original word list without any process
2. capitallist: only process the capitalization and store the corres. index
3. vowellist: process both capitalization and vowel and store the corres. index

For each query word, find the index in order of 1,2,3, if nothing is found, return "".


TC: O(n) - suppose total n words in wordlist and queries
SC: O(n)
*/
class Solution {
    String vowelstr = "aeiouAEIOU";
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> wordSet = new HashSet<>();
        int m = wordlist.length;
        Map<String, Integer> capitallist = new HashMap<>();
        Map<String, Integer> vowellist = new HashMap<>();
        for(int i = 0; i < m; i++) {
            String temp = wordlist[i];
            wordSet.add(temp);
            temp = wordlist[i].toUpperCase();
            if(!capitallist.containsKey(temp)) {
                capitallist.put(temp, i);
            }
            temp = processVowel(wordlist[i]);
            if(!vowellist.containsKey(temp)) {
                vowellist.put(temp, i);
            }
        }
         
        int n = queries.length;
        String[] res = new String[n];
        for(int i = 0; i < n; i++) {
            String query = queries[i];
            if(wordSet.contains(query)) {
                res[i] = query;
            } else {
                String first = query.toUpperCase();
                if(capitallist.containsKey(first)) {
                    res[i] = wordlist[capitallist.get(first)];
                    continue;
                }
                String after = processVowel(query);
                if(vowellist.containsKey(after)) {
                    res[i] = wordlist[vowellist.get(after)];
                    continue;
                }
                res[i] = "";
            }
        }
        return res;
    }
    
    public String processVowel(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(vowelstr.indexOf(c)!=-1) {
                sb.append('a');
            } else {
                sb.append(Character.toUpperCase(c));    
            }
        }
        return sb.toString();
    }
}