/*
Iterative way

TC: O(n)
SC: O(1)
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head!=null) {
            ListNode curr = head.next;
            head.next = prev;
            prev = head;
            head = curr;
        }
        return prev;
    }
}
