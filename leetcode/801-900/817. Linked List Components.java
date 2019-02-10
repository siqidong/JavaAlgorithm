/*
题目意思是要找在G里面存在多少个集合，能够用linked list连在一起的算一个集合

TC: O(n)
SC: O(n)
*/
class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for(int num : G) {
            set.add(num);
        }
        int count = 0;
        while(head!=null) {
            if(set.contains(head.val)) {
                count++;
                while(head!=null && set.contains(head.val)) {
                    head = head.next;
                }
            }
            if(head!=null) {
                head = head.next;    
            }
        }
        return count;
    }
}
