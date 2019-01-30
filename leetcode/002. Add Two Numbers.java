/*
Brute Force

TC: O(n)
SC: O(1)
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        int count = 0;
        while(l1!=null || l2!=null) {
            int sum = count;
            if(l1!=null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!=null) {
                sum += l2.val;
                l2 = l2.next;
            }
            count = sum/10;
            head.next = new ListNode(sum%10);
            head = head.next;
        }
        
        if(count!=0) {
            head.next = new ListNode(count);
        }
        return dummy.next;
    }
}
