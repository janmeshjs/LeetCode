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
    int i, p;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       i = p = 0;
      return dfs(preorder, inorder, 3001);
   }

   private TreeNode dfs(int[] pre, int[] in, int rightBoundary) {
      if (p == pre.length || in[i] == rightBoundary) return null;

      TreeNode node = new TreeNode(pre[p++]);
      node.left  = dfs(pre, in, node.val);
      i++;
      node.right = dfs(pre, in, rightBoundary);
      return node;
   }
}