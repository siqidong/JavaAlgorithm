/*
Queue

TC: O(n)
SC: O(n)
*/
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < pid.size(); i++) {
            int parent = ppid.get(i);
            int child = pid.get(i);
            if(!map.containsKey(parent)) {
                map.put(parent, new HashSet<>());
            }
            map.get(parent).add(child);
        }
        List<Integer> res = new ArrayList<>();
        res.add(kill);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int next : map.getOrDefault(curr, new HashSet<Integer>())) {
                res.add(next);
                queue.offer(next);
            }
        }
        return res;
    }
}