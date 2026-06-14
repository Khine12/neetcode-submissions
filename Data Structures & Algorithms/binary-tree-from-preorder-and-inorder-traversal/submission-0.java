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

    int index_of_preorder = 0;

    Map<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i=0; i < inorder.length; i++){

            map.put(inorder[i],i);
        }

        return build(preorder,0,inorder.length-1);
        
    }

    private TreeNode build(int[] preorder, int L, int R){

        if(L>R) return null;

        int rootVal = preorder[index_of_preorder++];

        TreeNode root = new TreeNode(rootVal);

        int mid = map.get(rootVal);

        root.left = build(preorder,L,mid-1);

        root.right = build(preorder,mid+1,R);

        return root;
    }
}
