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
    
    
    public int kthSmallest(TreeNode root, int k) 
    {
        ArrayList<Integer> values = new ArrayList<>();
        traverseSubTree(root.left, values);
        values.add(root.val);
        if(values.size() >= k)
            return values.get(k-1);
        traverseSubTree(root.right, values);
        return values.get(k-1);
    }
    
    public void traverseSubTree(TreeNode root, ArrayList<Integer> values)
    {
        if(root!=null)
        {
            traverseSubTree(root.left, values);
            values.add(root.val);
            traverseSubTree(root.right,values);
        }
    }
}