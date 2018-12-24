// GREEDY / RACE CAR PROBLEM
/*
Method 1: DFS+Memoization
用最少的operator使x变成target，就是说尽量让x连乘，直到超过target为止
答案只可能是下面两种情况：
case1: x*x*x*x...*x - (.....)
      [ >=target  ]

case1 = count + leastOpsExpressTarget(x, product-target) + 1
      = 连乘的次数 + (.....)的个数 + 一次减号

case2: x*x*x*x...*x + (.....)
      [ <=target  ]

case2 = leastOpsExpressTarget(x, (int)(target-product)) + (count==0?2:count);
case2
           count==0：
       ／  leastOpsExpressTarget(x, (target-product)) + 2;
           (.....)的个数 + x比target大，product除以x得到1的一次 + 一次加法，所以是2
     = 
           count>0：
        \  leastOpsExpressTarget(x, (target-product)) + count - 1 + 1;
           (.....)的个数 + 连乘到product的个数 + 因为product大于target所以要除以x小于target的一次 + 一次加法

case1和case2的初始值必须是MXA_VALUE, in case of 只有一种解的情况
保留case1和case2里面的最小值，存在map里

TC: O(target)?

*/
Map<Integer, Integer> map = new HashMap<>();
public int leastOpsExpressTarget(int x, int target) {
    if(target==1) {
        return x==1?0:1;
    }
    if(map.containsKey(target)) {
        return map.get(target);
    }
    int count = 0;
    long product = x;
    while(product<target) {
        count++;
        product *= x;
    }
    
    //CASE 1: x*x*x*x*x*x - (...)
    int case1 = Integer.MAX_VALUE;
    if(product==target) {
        case1 = count;
    } else if (product-target < target) {
        case1 = count + leastOpsExpressTarget(x, (int)(product-target)) + 1;
    }
    
    //CASE 2: x*x*x*x*x*x + (...)
    int case2 = Integer.MAX_VALUE;
    product /= x;
    case2 = leastOpsExpressTarget(x, (int)(target-product)) + (count==0?2:count);
    int res = Math.min(case1, case2);
    map.put(target, res);
    return res;
}



/*
Method 2: Brute Force
The followig is my first thought on this problem...
very ruo zhi, and got TLE on the 4th test case.

However, this should be a "correct" solution.
*/
class Solution {
    public int leastOpsExpressTarget(int x, int target) {
        if(x==target) {
            return 0;
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("", x);
        Set<String> set = new HashSet<>();
        set.add("");
        while(true) {
            Set<String> temp = new HashSet<>();
            for(String s : set) {
                for(int i = 0; i < 4; i++) {
                    String news = s + i;
                    int value = 0;
                    if(i==0) { // + 
                        value = map.get(s)+x;
                    } else if (i==1) { // -
                        value = map.get(s)-x;
                    } else if (i==2) { // *
                        value = getValue(x, 2, s, map);
                    } else { // /
                        value = getValue(x, 3, s, map);
                    }
                    map.put(news, value);
                    temp.add(news);
                    if(value==target) {
                        return news.length();
                    }
                }
            }
            set = temp;
        }
    }
    
    public int getValue(int x, int i, String s, Map<String, Integer> map) {
        int index = s.length()-1;
        while(index>=0 && (s.charAt(index)=='2' || s.charAt(index)==3)) {
            index--;
        }
        int prev = 0;
        if(index>=0) {
            String left = s.substring(0, index);
            prev = map.get(left);
        }
        int right = map.get(s.substring(index+1));
        if(i==2) {
            right *= x;
        } else { //i==3
            right /= x;
        }
        if(index>=0) {
            if(s.charAt(index)=='1') {
               right = 0-right; 
            }
        }
        return prev+right;
    }
}