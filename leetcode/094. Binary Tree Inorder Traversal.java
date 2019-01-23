/*
Binary Tree Inorder Traversal

Recursion
TC: O(n)
SC: O(logn) - also count the runtime call stack space
*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    public void helper(TreeNode root, List<Integer> res) {
        if(root==null) {
            return;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
}

/*
Binary Tree Inorder Traversal

Iterative
TC: O(n)
SC: O(logn)
*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.empty() || root!=null) {
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
