/*
DFS

TC: O(n)
SC: O(n)
*/
class Solution {
    String res = "";
    public String smallestFromLeaf(TreeNode root) {
        if(root==null) {
            return "";
        }
        getString(root, "");
        return res;
    }
    
    public void getString(TreeNode root, String str) {
        if(root.left==null && root.right==null) {
            char ch = (char)('a'+root.val);
            str = ch+str;
            if(res.equals("") || str.compareTo(res)<0) {
                res = str;
            }
        }
        char one = (char)('a'+root.val);
        if(root.left!=null) {
            getString(root.left, one+str);
        }
        if(root.right!=null) {
            getString(root.right, one+str);
        }     
    }
}
