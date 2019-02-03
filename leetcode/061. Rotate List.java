/*
Rotate / Swap: 注意判断边界情况：k==0时不用进行rotate/swap操作 直接返回原linkedlist。。

TC: O(n)
SC: O(n)
*/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k < 0) {
            return head;
        }
        int size = getLength(head);
        k = k%size;
        if(k==0) {
            return head;
        }
        ListNode last = head;
        while(last.next!=null) {
            last = last.next;
        }
        ListNode start = head;
        for(int i = 0; i < size-k-1; i++) {
            start = start.next;
        }
        ListNode newhead = start.next;
        start.next = null;
        last.next = head;
        return newhead;
    }
    
    public int getLength(ListNode head) {
        int length = 0;
        while(head!=null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
