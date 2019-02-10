/*
Recursion

TC: O(n)
SC: O(n)
*/
class Solution {
    public Node flatten(Node head) {
        if(head==null) {
            return null;
        }
        List<Node> list = new ArrayList<>();
        helper(list, head);
        for(int i = 0; i < list.size(); i++) {
            Node curr = list.get(i);
            Node prev = i>=1?list.get(i-1):null;
            Node next = i<list.size()-1?list.get(i+1):null;
            curr.prev = prev;
            curr.next = next;
            curr.child = null;
        }
        return list.get(0);
    }
    
    public void helper(List<Node> list, Node head) {
        while(head!=null) {
            list.add(head);
            if(head.child!=null) {
                helper(list, head.child);
            }
            head = head.next;
        }
    }
}
