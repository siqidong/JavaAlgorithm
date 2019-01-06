/*
Brute Force
TC: O(n^2) - n is equal to Math.max(log(x, bound), log(y, bound))
SC: O(1)
*/
public List<Integer> powerfulIntegers(int x, int y, int bound) {
    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    if(bound<2) {
        return list;
    }
    int upperX = x==1?0:(int)(Math.log(bound) / Math.log(x))+1;
    int upperY = y==1?0:(int)(Math.log(bound) / Math.log(y))+1;
    System.out.println("upperX="+upperX+"upperY="+upperY);
    for(int i = 0; i <= upperX; i++) {
        for(int j = 0; j <= upperY; j++) {
            int num = (int)(Math.pow(x, i)+Math.pow(y, j));
            if(num<=bound && !set.contains(num)) {
                list.add(num);
                set.add(num);
            }
        }
    }
    return list;
}