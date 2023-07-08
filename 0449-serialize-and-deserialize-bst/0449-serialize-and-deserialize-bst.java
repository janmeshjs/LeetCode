/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#";

    return root.val+" "+ serialize(root.left)+" "+ serialize(root.right);
    }

    // Decodes your encoded data to tree.
    String[] arr; int index;
    public TreeNode deserialize(String data) {
        arr = data.split(" ");
        index =0;
        return helper();
    }
    
    private TreeNode helper(){
        int index = this.index++;
        if(arr[index].equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(arr[index]));
        root.left = helper();
        root.right = helper();
        return root;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;