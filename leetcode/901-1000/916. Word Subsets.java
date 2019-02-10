/*
暴力大法好

TC: O(mn) - suppose there are m words with n length each
SC: O(mn)
*/
public List<String> wordSubsets(String[] A, String[] B) {
    int[] count = new int[26];
    for(String s : B) {
        int[] temp = new int[26];
        for(char c : s.toCharArray()) {
            temp[c-'a']++;
        }
        for(int i = 0; i < 26; i++) {
            count[i] = Math.max(count[i], temp[i]);
        }
    }
    List<String> res = new ArrayList<>();
    for(String s : A) {
        int[] temp = new int[26];
        for(char c : s.toCharArray()) {
            temp[c-'a']++;
        }
        boolean flag = true;
        for(int i = 0; i < 26; i++) {
            if(count[i]>temp[i]) {
                flag = false;
                break;
            }
        }
        if(flag) {
            res.add(s);
        }
    }
    return res;
}