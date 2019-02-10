/*
Brute Force

TC: O(n)
SC: O(n)
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if(lenA>lenB) {
            int diff = lenA-lenB;
            while(diff>0) {
                headA = headA.next;
                diff--;
            }
        } else {
            int diff = lenB-lenA;
            while(diff>0) {
                headB = headB.next;
                diff--;
            }
        }
        while(headA!=null && headB!=null && headA!=headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    
    public int getLength(ListNode head) {
        int count = 0;
        while(head!=null) {
            head = head.next;
            count++;
        }
        return count;
    }
}
