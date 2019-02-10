/*
Recursion

TC: O(n)
SC: O(n)
*/
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while(head!=null) {
            list.add(head.val);
            head = head.next;
        }
        TreeNode res = getTreeNode(list, 0, list.size()-1);
        return res;
    }
    
    public TreeNode getTreeNode(List<Integer> list, int start, int end) {
        System.out.println("start = "+start + "end="+end);
        if(start>end) {
            return null;
        }
        if(start==end) {
            return new TreeNode(list.get(start));
        }
        int index = (start+end)/2;
        TreeNode node = new TreeNode(list.get(index));
        node.left = getTreeNode(list, start, index-1);
        node.right = getTreeNode(list, index+1, end);
        return node;
    }
}
