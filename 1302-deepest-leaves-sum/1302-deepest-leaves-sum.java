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
    public int deepestLeavesSum(TreeNode root) {
        int lev = lev(root);
    return sum(root,lev, 1, 0);
    }
    public int sum(TreeNode root, int lev, int dep, int sum){
        if(root==null)return 0;
        if(lev==dep){
            sum+= root.val;
            return sum;
        }
        return sum(root.left, lev, dep+1, sum) + sum(root.right, lev, dep+1, sum);
    }
    public int lev(TreeNode root){
        if(root==null)return 0;
        
        return Math.max(lev(root.left),lev(root.right))+1;
        
    }
}
