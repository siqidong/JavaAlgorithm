/*
Brute Force

Basic LinkedList operations:
1. Find the middle node
2. Reverse the linked list
3. Traverse and combine linked lists

TC: O(n)
SC: O(1)
*/
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        ListNode newList = new ListNode(0);
        ListNode half = getMiddle(head);
        ListNode reverseHalf = reverse(half);
        boolean flag = true;
        while(head!=null && reverseHalf!=null) {
            if(flag) {
                newList.next = head;
                head = head.next;
            } else {
                newList.next = reverseHalf;
                reverseHalf = reverseHalf.next;
            }
            flag = !flag;
            newList = newList.next;
        }
        if(head==null) {
            newList.next = reverseHalf;
        } else if(reverseHalf==null) {
            newList.next = head;
        }
    }
    
    public ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        return res;
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