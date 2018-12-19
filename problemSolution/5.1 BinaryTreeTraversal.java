//树的遍历，recursion和iterative两种写法，更优化的算法是morris遍历
/*
Tree:
      5
    /   \
   3     6
  / \   / \
 7  2  1  8

preorder: 根左右 [5 3 7 2 6 1 8] which is the order to enter the stack
inorder: 左根右 [7 3 2 5 1 6 8] which is the order to pop out from the stack
postorder: 左右根 [7 2 3 1 8 6 5] which is the reverse of 根右左, use preorder to solve it.

In case of a binary tree degraded to a linked list, the worst space complexity will still be O(n)
*/


//Preorder
//LEETCODE 114
//https://leetcode.com/problems/binary-tree-preorder-traversal/description/

//Recursion
//TC: O(n) - n is the number of nodes
//SC: O(n)
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    helper(root, res);
    return res;
}

public void helper(TreeNode root, List<Integer> res) {
    if(root==null) {
        return;
    }
    res.add(root.val);
    helper(root.left, res);
    helper(root.right, res);
}

//Iterative
//TC: O(n) - n is the number of nodes
//SC: O(n)
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while(root!=null || !stack.empty()) {
        while(root!=null) {
            stack.push(root);
            res.add(root.val);
            root = root.left;
        }
        root = stack.pop();
        root = root.right;
    }
    return res;
}


//Inorder
//LEETCODE 94
//https://leetcode.com/problems/binary-tree-inorder-traversal/description/

//Recursion
//TC: O(n) - n is the number of nodes
//SC: O(n)
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

//Iterative
//TC: O(n) - n is the number of nodes
//SC: O(n)
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while(root!=null || !stack.empty()) {
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


//Postorder
//LEETCODE 145
//https://leetcode.com/problems/binary-tree-postorder-traversal/description/

//Recursion
//TC: O(n) - n is the number of nodes
//SC: O(n)
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

//Iterative
//TC: O(n) - n is the number of nodes
//SC: O(n)
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while(root!=null || !stack.empty()) {
        while(root!=null) {
            stack.push(root);
            res.add(0, root.val);
            root = root.right;
        }
        root = stack.pop();
        root = root.left;
    }
    return res;
}

