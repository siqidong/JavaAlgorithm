/*
TC: O(n) - suppose n nodes in the tree
SC: O(1)
*/

class Solution {
    int value = 0;
    public boolean isUnivalTree(TreeNode root) {
        value = root.val;
        return helper(root);
    }
    
    public boolean helper(TreeNode root) {
        if(root==null) {
            return true;
        }
        if(root.val!=value) {
            return false;
        }
        return helper(root.left)&&helper(root.right);
    }
}