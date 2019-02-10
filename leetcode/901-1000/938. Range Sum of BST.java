/*
利用了BST的性质

if root.val < L, go to the right part of root
if root.val > R, go to the left part of root
if L <= root.val <= R, add root.val to res, and go to the both left and right parts of root

TC: O(logn)
SC: O(1)
*/
class Solution {
    int res = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        helper(root, L, R);
        return res;
    }
    
    public void helper(TreeNode root, int L, int R) {
        if(root==null) {
            return;
        }
        if(root.val<L) {
            helper(root.right, L, R);
        } else if(root.val>R) {
            helper(root.left, L, R);
        } else {
            res += root.val;
            helper(root.left, L, R);
            helper(root.right, L, R);
        }
    }
}



/*
遍历一遍的解法竟然也能通过，震惊。。。

TC: O(n)
SC: O(1)
*/
public int rangeSumBST(TreeNode root, int L, int R) {
    int res = 0;
    Stack<TreeNode> stack = new Stack<>();
    while(!stack.empty() || root!=null) {
        while(root!=null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        if(L<=root.val && root.val<=R) {
            res += root.val;
        }
        root = root.right;
    }
    return res;
}