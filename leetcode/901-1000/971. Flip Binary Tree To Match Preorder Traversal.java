/*
Brute Force
TC: O(n)
SC: O(1)
*/

class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        int n = voyage.length;
        int[] voyageIdx = new int[n+1];
        for(int i = 0; i < n; i++) {
            voyageIdx[voyage[i]] = i;
        }
        boolean res = flip(root, voyage, voyageIdx, 0, n-1);
        return res?list:new ArrayList<>(Arrays.asList(-1));
    }
    
    public boolean flip(TreeNode root, int[] voyage, int[] voyageIdx, int start, int end) {
        if(root.val!=voyage[start]) {
            return false;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left==null && right==null) {
            return start==end;
        }
        if(left==null) {
            int rIdx = voyageIdx[right.val];
            if(rIdx!=start+1) {
                return false;
            }
            return flip(root.right, voyage, voyageIdx, rIdx, end);
        }
        if(right==null) {
            int lIdx = voyageIdx[left.val];
            if(lIdx!=start+1) {
                return false;
            }
            return flip(root.left, voyage, voyageIdx, lIdx, end);
        }
        
        int lIdx = voyageIdx[left.val];
        int rIdx = voyageIdx[right.val];
        if(lIdx<start || lIdx>end || rIdx<start || rIdx>end) {
            return false;
        }
        if(lIdx<rIdx) {
            if(lIdx!=start+1) {
                return false;
            }
            return flip(root.left, voyage, voyageIdx, lIdx, rIdx-1) &&
                   flip(root.right, voyage, voyageIdx, rIdx, end);
        } else {
            if(rIdx!=start+1) {
                return false;
            }
            list.add(root.val);
            return flip(root.left, voyage, voyageIdx, lIdx, end) &&
                   flip(root.right, voyage, voyageIdx, rIdx, lIdx-1);
        }
    }
}