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
    int total = 0;
    public int goodNodes(TreeNode root) {
     
        if(root==null)
            return 0;
        preOrder(root, Integer.MIN_VALUE);
        return total;
    }
    
    private void preOrder(TreeNode curr, int max)
    {
        if(curr.val >= max)
            total++;
        
        max = (max < curr.val) ? curr.val : max;
        if(curr.left != null)
            preOrder(curr.left, max);
        if(curr.right != null)
            preOrder(curr.right, max);
    }
}
