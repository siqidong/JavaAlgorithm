/*
Linked List

TC: O(n)
SC: O(1)
*/
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode dummySmall = small;
        ListNode big = new ListNode(0);
        ListNode dummyBig = big;
        while(head!=null) {
            if(head.val<x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = dummyBig.next;
        return dummySmall.next;
    }
}
