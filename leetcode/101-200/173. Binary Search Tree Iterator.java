/*
Same algorithm as binary tree inorder traverse - iterative way

TC: O(1) Amortized
SC: O(h) - h is the height of the tree
*/
class BSTIterator {

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while(root!=null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode temp = stack.pop();
        int value = temp.val;
        temp = temp.right;
        while(temp!=null) {
            stack.push(temp);
            temp = temp.left;
        }
        return value;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }
}
