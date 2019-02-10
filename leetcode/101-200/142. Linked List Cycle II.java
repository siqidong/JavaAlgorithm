/*
Fast & Slow pointer

TC: O(n)
SC: O(1)
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) {
            return null;
        }
        ListNode dummy = head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow) {
                break;
            }
        }
        if(fast==null || fast.next==null) {
            return null;
        }
        slow = slow.next;
        while(dummy!=slow) {
            dummy = dummy.next;
            slow = slow.next;
        }
        return slow;
    }
}
