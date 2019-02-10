/*
TC: O(n)
SC: O(logn)
*/
public TreeNode increasingBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode res = null;
    TreeNode prev = null;
    while(!stack.empty() || root!=null) {
        while(root!=null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        if(res==null) {
            res = root;
        }
        if(prev!=null) {
            prev.left = null;
            prev.right = root;
        }
        prev = root;
        root.left = null;
        root = root.right;
    }
    return res;
}