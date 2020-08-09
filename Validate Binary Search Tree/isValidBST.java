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
    public boolean isValidBST(TreeNode root) {
        
        if(root==null || root.left ==null && root.right==null)
            return true;
        
        Stack<TreeNode> toVisit = new Stack<>();
        double prev = -Double.MAX_VALUE;
        TreeNode current;
        
        while(root!= null) //Traverse down to smallest value stored at lower-left leaf of tree.
        {
            toVisit.push(root);
            root = root.left;
        }
        
        while(!toVisit.isEmpty())
        {
            current = toVisit.pop();
            if(current.val <= prev) //Compare current node to last one in traversal.
                return false;
            prev = current.val;
            current = current.right;
            
            while(current != null) //Check if the right sub-tree has nodes smaller then itself.
            {
                toVisit.push(current);
                current = current.left;
            }
        }
        
        return true; //Return true if the in-order traversal returns 
        
    }
}