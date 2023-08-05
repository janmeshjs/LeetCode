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
    
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }
    
    public List<TreeNode> helper(int s, int e){
        List<TreeNode> list = new ArrayList<>();
        
        if(s>e){
            list.add(null);
            return list;
        }
        
        if(s==e){
            list.add(new TreeNode(s));
            return list;
        }
        
        for(int i = s; i<=e; i++){
            
            List<TreeNode> leftsub = helper(s, i-1);
            List<TreeNode> rightsub = helper(i+1, e);
            
            for(TreeNode left : leftsub){
                for(TreeNode right : rightsub){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}