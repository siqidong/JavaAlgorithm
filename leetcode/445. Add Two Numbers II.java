/*
Add linked list numbers without reversing the linked list

Use stack

TC: O(n)
SC: O(n)
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1!=null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode newnode = null;
        int sum = 0;
        while(!s1.empty() || !s2.empty()) {
            if(!s1.empty()) {
                sum += s1.pop();
            }
            if(!s2.empty()) {
                sum += s2.pop();
            }
            ListNode prev = new ListNode(sum%10);
            prev.next = newnode;
            newnode = prev;
            sum /= 10;
        }
        if(sum!=0) {
            ListNode prev = new ListNode(sum%10);
            prev.next = newnode;
            newnode = prev;
        }
        return newnode;
    }
}
