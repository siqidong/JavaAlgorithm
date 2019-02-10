/*
Fast&Slow pointer

TC: O(n)
SC: O(1)
*/
public ListNode middleNode(ListNode head) {
    if(head.next==null) {
        return head;
    }
    if(head.next.next==null) {
        return head.next;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while(fast.next!=null && fast.next.next!=null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow.next;
}