/*
Linked List

TC: O(n)
SC: O(1)
*/
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode oddDummy = odd;
        ListNode evenDummy = even;
        boolean flag = false;
        while(head!=null) {
            if(flag) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            flag = !flag;
            head = head.next;
        }
        even.next = null;
        odd.next = evenDummy.next;
        return oddDummy.next;
    }
}
