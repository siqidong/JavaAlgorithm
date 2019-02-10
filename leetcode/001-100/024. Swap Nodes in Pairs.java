/*
Brute Force

TC: O(n)
SC: O(1)
*/
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode prev = new ListNode(0);
        ListNode dummy = prev;
        while(head!=null && head.next!=null) {
            prev.next = head.next;
            head.next = head.next.next;
            prev.next.next = head;
            prev = head;
            head = prev.next;
        }
        return dummy.next;
    }
}
