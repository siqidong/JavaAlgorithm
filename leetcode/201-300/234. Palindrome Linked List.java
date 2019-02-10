/*
Brute Force

TC: O(n)
SC: O(1)
*/
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) {
            return true;
        }
        ListNode first = head;
        ListNode second = getMiddle(head);
        ListNode reverseSecond = reverse(second);
        while(first!=null && reverseSecond!=null) {
            if(first.val != reverseSecond.val) {
                return false;
            }
            first = first.next;
            reverseSecond = reverseSecond.next;
        }
        return true;
    }
    
    public ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head!=null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}