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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        if(preorder.length==1)
            return new TreeNode(preorder[0]);
        
        HashMap<Integer, Integer> in = new HashMap<>();
        
        for(int i =0; i < preorder.length; i++) //Hash the inorder traversal to avoid O(n) look up time.
        {
            in.put(inorder[i],i);
        }
        
        return builder(0,inorder.length-1,0,preorder,in);
        
     }
    
    public TreeNode builder(int inStart, int inEnd, int preStart,int[] preorder, HashMap<Integer, Integer> in)
    {
        
        if(inStart>inEnd)
            return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = builder(inStart,in.get(root.val)-1, preStart+1, preorder, in);
        root.right = builder(in.get(root.val)+1, inEnd, preStart+in.get(root.val)-inStart+1, preorder, in);
        
        return root;
    }
}