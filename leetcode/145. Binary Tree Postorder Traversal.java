/*
Binary Tree Postorder Traversal

Recursion
TC: O(n)
SC: O(logn) - also count the runtime call stack space
*/
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    public void helper(TreeNode root, List<Integer> res) {
        if(root==null) {
            return;
        }
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }
}

/*
Binary Tree Postorder Traversal

Iterative
TC: O(n)
SC: O(logn)
*/
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.empty() || root!=null) {
            while(root!=null) {
                stack.push(root);
                res.add(root.val);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        Collections.reverse(res);
        return res;
    }
}

