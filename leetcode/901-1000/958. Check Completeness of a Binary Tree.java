//TC: O(n)
//SC: O(n)

public boolean isCompleteTree(TreeNode root) {
    if(root==null) {
        return true;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean isEnd = false;
    while(!queue.isEmpty()) {
        TreeNode curr = queue.poll();
        if(curr==null) {
            isEnd = true;
        } else {
            if(isEnd) {
                return false;
            }
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
    }
    return true;
}