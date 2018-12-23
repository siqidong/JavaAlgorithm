//TC: O(n)
//SC: O(n)
public int repeatedNTimes(int[] A) {
    Set<Integer> set = new HashSet<>();
    for(int num : A) {
        if(!set.add(num)) {
            return num;
        }
    }
    return 0;
}