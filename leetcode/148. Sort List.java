/*
Merge sort on LinkedList

TC: O(nlogn)
SC: O(1) -  doesn't count runtime call stack
*/
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(middle);
        ListNode res = merge(list1, list2);
        return res;
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
    
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode newlist = new ListNode(0);
        ListNode dummy = newlist;
        while(list1!=null && list2!=null) {
            if(list1.val<list2.val) {
                newlist.next = list1;
                list1 = list1.next;
            } else {
                newlist.next = list2;
                list2 = list2.next;
            }
            newlist = newlist.next;
        }
        if(list1!=null) {
            newlist.next = list1;
        }
        if(list2!=null) {
            newlist.next = list2;
        }
        return dummy.next;
    }
}
