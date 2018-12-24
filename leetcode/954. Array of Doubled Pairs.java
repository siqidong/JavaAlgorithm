/*
Brute Force it!
Three cases:
Case 1: num==0: there must be even number of 0s

Case 2: num>0: loop from small to big, there must be a number == 2*small

Case 3: num<0: loop from big to small, there must be a number == big/2

TC: O(nlogn)
SC: O(n)
*/
public boolean canReorderDoubled(int[] A) {
    Arrays.sort(A);
    Map<Integer, Integer> map = new HashMap<>();
    for(int num : A) {
        map.put(num, map.getOrDefault(num, 0)+1);
    }
    if(map.containsKey(0) && map.get(0)%2!=0) {
        return false;
    }
    map.remove(0);
    for(int num : A) {
        if(num==0 || map.get(num)<=0) {
            continue;
        }
        int nextNum = num>0 ? 2*num: num/2;
        if(num<0 && num%2!=0) {
            return false;
        }
        if(!map.containsKey(nextNum) || map.get(nextNum)<=0) {
            return false;
        }
        map.put(num, map.get(num)-1);
        map.put(nextNum, map.get(nextNum)-1);
    }
    return true;
}