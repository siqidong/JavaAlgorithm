/*
Linked List

TC: O(n)
SC: O(n)
*/
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode temp = reverse(head);
        ListNode dummy = temp;
        int num = 1;
        int sum = 0;
        while(temp.next!=null) {
            sum = temp.val+num;
            temp.val = sum%10;
            num = sum/10;
            temp = temp.next;
        }
        sum = temp.val+num;
        temp.val = sum%10;
        num = sum/10;
        if(num>0) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        return reverse(dummy);
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