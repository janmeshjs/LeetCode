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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty() || !st2.isEmpty()){
            List<Integer> list1 = new ArrayList<>();
            while(!st1.isEmpty()){
                TreeNode temp = st1.pop();
                System.out.print(temp.val+"st1");
                list1.add(temp.val);
                if(temp.left!=null)  st2.push(temp.left);
                if(temp.right!=null) st2.push(temp.right);
            }
            ans.add(list1);
            List<Integer> list2 = new ArrayList<>();
            while(!st2.isEmpty()){
                TreeNode temp = st2.pop();
                System.out.print(temp.val+" st2");

                list2.add(temp.val);
                if(temp.right!=null) st1.push(temp.right);
                if(temp.left!=null)  st1.push(temp.left);
            }
            if (!list2.isEmpty()) {
                ans.add(list2);
            }
        }
        
        return ans;
    }
}