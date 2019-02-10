/*
Iterative way.

TC: O(n)
SC: O(1)
*/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = head;
        ListNode curr = head;
        while(head!=null) {
            while(head!=null && head.val==curr.val) {
                head = head.next;
            }
            curr.next = head;
            curr = head;
        }
        return dummy;
    }
}
