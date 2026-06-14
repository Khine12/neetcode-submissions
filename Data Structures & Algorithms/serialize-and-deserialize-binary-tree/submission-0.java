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

        helper_serialize(root,sb);

        return sb.toString();
        
    }

    private void helper_serialize(TreeNode node, StringBuilder sb){

        if(node == null){

            sb.append("N,");

            return;
        }

        sb.append(node.val).append(",");

        helper_serialize(node.left,sb);

        helper_serialize(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] collector = data.split(",");

        int[] idx = new int[1];

        return helper_deserialize(data,idx);
    }

    private TreeNode helper_deserialize(String data, int[] idx){

        String curr = collector[idx[0]++];

        if(curr.isequals("N")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(curr));

        node.left = helper_deserialize(collector,idx);

        node.right = helper_deserialize(collector,idx);

        return node;
        


    }
}
