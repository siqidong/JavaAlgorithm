/*
My code is so looooooooooooong..... but effective :)

My thought:
store the node in a list, every time store twice.
if the first and second is the same node, then insert to the left of the first node.
if the first and secon are different nodes, then insert to the right of the first node.

ex:      1
        / \
       2   3
      /
     4

At first there is no tree, and we insert 1, 2, 3, 4 into the tree, D - delete in list

list = []
        
insert: 1
list = [1, 1] -> root node is 1

insert: 2
list = [1, 1, 2, 2] -> 1==1, so 2 is left child to 1
        D

insert: 3
list = [1, 1, 2, 2, 3, 3] -> 1!=2, so 3 is right child to 1
        D  D

insert: 4
list = [1, 1, 2, 2, 3, 3, 4, 4] -> 2==2, so 4 is left child to 2
        D  D  D      
...


TC: init: O(n), insert: O(1)
SC: O(n)
*/
class CBTInserter {

    TreeNode root;
    List<TreeNode> list;
    public CBTInserter(TreeNode root) {
        this.root = root;
        list = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            insert(curr);
            if(curr.left!=null) {
                q.offer(curr.left);
            }
            if(curr.right!=null) {
                q.offer(curr.right);
            }
        }
    }
    
    public int insert(int v) {
        TreeNode newnode = new TreeNode(v);
        TreeNode parent = insert(newnode);
        return parent.val;
    }
    
    public TreeNode insert(TreeNode node) {
        if(list.size()==0) {
            list.add(node);
            list.add(node);
            return node;
        }
        TreeNode first = list.get(0);
        if(list.get(0).equals(list.get(1))) {
            first.left = node;
        } else {
            first.right = node;
        }
        list.add(node);
        list.add(node);
        list.remove(0);
        return first;
    }
    
    public TreeNode get_root() {
        return root;
    }
}