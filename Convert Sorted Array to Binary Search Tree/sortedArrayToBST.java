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
    public TreeNode sortedArrayToBST(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        TreeNode root = new TreeNode();
        return binSearch(root, left, right, nums);
    }
    
    private TreeNode binSearch(TreeNode current, int left, int right, int nums[])
    {
        if(left <= right)
        {
            int mid = right-(right-left)/2;
            current.val = nums[mid];
            current.left = binSearch(new TreeNode(), left, mid-1, nums);
            current.right = binSearch(new TreeNode(), mid+1, right, nums);
            return current;
        }
        
        return null;
        
    }
}