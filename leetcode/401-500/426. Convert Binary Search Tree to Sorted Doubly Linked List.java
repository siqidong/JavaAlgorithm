/*
Store them in an arraylist and then do the conversion.

TC: O(n)
SC: O(n)
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if(root==null) {
            return null;
        }
        List<Node> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while(!stack.empty() || root!=null) {
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root);
            root = root.right;
        }
        Node head = list.get(0);
        int size = list.size();
        for(int i = 0; i < list.size(); i++) {
            Node prev = i==0? list.get(size-1) : list.get(i-1);
            Node curr = list.get(i);
            Node next = i==size-1 ? list.get(0) : list.get(i+1);
            curr.left = prev;
            curr.right = next;
        }
        return head;
    }
}
