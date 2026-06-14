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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();

        serialize_helper(root,sb);

        return sb.toString();
    }

    private void serialize_helper(TreeNode node,StringBuilder sb){

        if(node == null){

            sb.append("N,");

            return;
        }

        sb.append(node.val).append(",");

        serialize_helper(node.left,sb);

        serialize_helper(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] token = data.split(",");

        int[] idx = new int[1];

        return deserialize_helper(token,idx);
    }

    private TreeNode deserialize_helper(String[] token,int[] idx){

        String curr = token[idx[0]++];

        if(curr.equals("N")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(curr));

        node.left = deserialize_helper(token,idx);

        node.right = deserialize_helper(token,idx);

        return node;
    }
}
