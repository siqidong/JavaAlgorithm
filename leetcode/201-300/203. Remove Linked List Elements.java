/*
Remove

TC: O(n)
SC: O(1)
*/
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newlist = new ListNode(0);
        ListNode dummy = newlist;
        newlist.next = head;
        while(newlist!=null && newlist.next!=null) {
            ListNode curr = newlist.next;
            while(curr!=null && curr.val==val) {
                curr = curr.next;
            }
            newlist.next = curr;
            newlist = newlist.next;
        }
        return dummy.next;
        
    }
}
