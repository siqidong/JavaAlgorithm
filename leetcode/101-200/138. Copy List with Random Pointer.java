/*
Two pass

TC: O(n)
SC: O(n)
*/
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode res = new RandomListNode(0);
        RandomListNode resDummy = res;
        RandomListNode headDummy = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while(head!=null){
            RandomListNode copyNode = new RandomListNode(head.label);
            map.put(head, copyNode);
            res.next = copyNode;
            res = res.next;
            head = head.next;
        }
        head = headDummy;
        res = resDummy.next;
        while(head!=null) {
            if(head.random!=null) {
                if(map.containsKey(head.random)) {
                    res.random = map.get(head.random);
                } else {
                    RandomListNode randomNode = new RandomListNode(head.random.label);
                    res.random = randomNode;
                    map.put(head.random, randomNode);
                }
            }
            res = res.next;
            head = head.next;
        }
        return resDummy.next;
    }
}
