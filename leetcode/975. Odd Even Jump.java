/*
Brute Force - Simulation

TC: O(n^2)
SC: O(n)
*/
class Solution {
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        int[] odd = new int[n];
        int[] even = new int[n];
        List<Integer> list = new ArrayList<>();
        list.add(n-1);
        for(int i = n-1; i>=0; i--) {
            int index = 0;
            while(index<list.size() && A[i]>A[list.get(index)]) {
                index++;
            }
            odd[i] = index<list.size()?list.get(index):-1;
            int temp = list.size()-1;
            while(temp>=0 && A[list.get(temp)] >= A[i]) {
                temp--;
            }
            list.add(temp+1, i);
        }
        
        list = new ArrayList<>();
        list.add(n-1);
        for(int i = n-1; i>=0; i--) {
            int index = 0;
            while(index<list.size() && A[i]<A[list.get(index)]) {
                index++;
            }
            even[i] = index<list.size()?list.get(index):-1;
            int temp = list.size()-1;
            while(temp>=0 && A[list.get(temp)] <= A[i]) {
                temp--;
            }
            list.add(temp+1, i);
        }
        
        int res = 0;
        for(int i = 0; i < n; i++) {
            int curr = i;
            boolean isOdd = true;
            while(curr!=-1 && curr!=n-1) {
                if(isOdd) {
                    curr = odd[curr];
                } else {
                    curr = even[curr];
                }
                isOdd = !isOdd;
            }
            if(curr==n-1) {
                res++;
            }
        }
        return res;
    }
}


/*
Same idea, a better solution... Use TreeMap
*/
class Solution {
    public int oddEvenJumps(int[] A) {
        
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        TreeMap<Integer, List<Integer>> map2 = new TreeMap<>();
        for(int i = 0; i < A.length; i++) {
            List<Integer> list = new ArrayList<Integer>();
            if(map.containsKey(A[i]))
                list = map.get(A[i]);
            list.add(i);
            map.put(A[i], list);
        }
        
        int[] oddIndex = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            List<Integer> list = map.get(A[i]);
            if(list.size() > 1) {
                oddIndex[i] = list.get(1);
            }
            if(oddIndex[i] == 0) {
                Map.Entry<Integer, List<Integer>> nextEnt = map.higherEntry(A[i]);
                if(nextEnt == null) oddIndex[i] = -1;
                else {
                    oddIndex[i] = nextEnt.getValue().get(0);
                }
            }
            map.get(A[i]).remove(new Integer(i));
            if(map.get(A[i]).size() == 0) map.remove(A[i]);
        }
        
        
        for(int i = 0; i < A.length; i++) {
            List<Integer> list = new ArrayList<Integer>();
            if(map2.containsKey(A[i]))
                list = map2.get(A[i]);
            list.add(i);
            map2.put(A[i], list);
        }
        int[] evenIndex = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            List<Integer> list = map2.get(A[i]);
            if(list.size() > 1) {
                evenIndex[i] = list.get(1);
            }
            if(evenIndex[i] == 0) {
                Map.Entry<Integer, List<Integer>> nextEnt = map2.lowerEntry(A[i]);
                if(nextEnt == null) evenIndex[i] = -1;
                else {
                    evenIndex[i] = nextEnt.getValue().get(0);
                }
            }
            map2.get(A[i]).remove(new Integer(i));
            if(map2.get(A[i]).size() == 0) map2.remove(A[i]);
        }        
        
        int ans = 0;
        for(int i = 0; i < A.length; i++) {
            int idx = i;
            boolean odd = true;
            while(idx != A.length-1 && idx != -1) {
                if(odd) {
                    idx = oddIndex[idx];
                }
                else {
                    idx = evenIndex[idx];
                }
                if(idx == 0) idx = -1;
                odd = !odd;
            }
            
            if(idx == A.length - 1) ans++;
        }

        return ans;
        
    }
}