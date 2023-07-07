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
    public int goodNodes(TreeNode root) {
        int n = Integer.MIN_VALUE;
        return find(root,n);
    }
    int count=0;
    private int find(TreeNode root, int prev){
        if(root == null) return 0;
        
        if(root.val>=prev){
            count++;
            prev=root.val;
        }
        
        find(root.left, prev);
        //prev = root.val;
        find(root.right, prev);
        
        return count;
    }
}