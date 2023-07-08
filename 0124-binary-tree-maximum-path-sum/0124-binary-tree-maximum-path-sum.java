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
    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathsum(root);
        return ans;
    }
    
    public int pathsum(TreeNode root){
        if(root==null) return 0;
        
        int left = pathsum(root.left);
        int right = pathsum(root.right);
        
        int ms = Math.max(Math.max(left,right)+root.val, root.val);
        int ms_1 = Math.max(root.val+left+right, ms);
         ans = Math.max(ans, ms_1);
        return ms;
    }
}
