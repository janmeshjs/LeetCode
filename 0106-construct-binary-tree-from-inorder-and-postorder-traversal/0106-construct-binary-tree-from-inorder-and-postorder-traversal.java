/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        int postIndex;
    HashMap<Integer, Integer> inMap;
    public TreeNode buildTree(int[] in, int[] po) {
        postIndex = po.length -1;
        inMap = new HashMap<>();
        for(int i=0; i<in.length; i++){
            inMap.put(in[i], i);
        }
        return helper(po, 0, po.length -1);
    }
    
    private TreeNode helper(int[] po, int left, int right) {
        if(left > right ) return null;
        
        int rootv = po[postIndex--];
        TreeNode root = new TreeNode(rootv);
        
        root.right = helper(po, inMap.get(rootv)+1, right);
        root.left = helper(po, left, inMap.get(rootv)-1);
        return root;
    }
}


