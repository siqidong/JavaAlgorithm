//Pascal's Triangle 1
//LEETCODE 118
//https://leetcode.com/problems/pascals-triangle/description/

//TC: O(n^2)
//SC: O(n^2)
public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if(numRows<=0) {
        return res;
    }
    for(int i = 0; i < numRows; i++) {
        List<Integer> one = new ArrayList<>();
        for(int j = 0; j < i+1; j++) {
            if(j==0 || j==i) {
                one.add(1);
            } else if (i>0){
                one.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
        }
        res.add(one);
    }
    return res;
}

//Pascal's Triangle 2
//LEETCODE 119
//https://leetcode.com/problems/pascals-triangle-ii/description/

//TC: O(n^2)
//SC: O(n)
public List<Integer> getRow(int rowIndex) {
    List<Integer> res = new ArrayList<>();
    if(rowIndex<0) {
        return res;
    }
    for(int i = 0; i <= rowIndex; i++) {
        List<Integer> temp = new ArrayList<>();
        for(int j = 0; j <= i; j++) {
            if(j==0 || j==i) {
                temp.add(1);
            } else if (i>1){
                temp.add(res.get(j-1)+res.get(j));
            }
        }
        res = temp;
    }
    return res;
}

