class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return findSum(root, sum);
    }
    
    private boolean findSum(TreeNode current, int sum)
    {
        if(current==null)
           return false;
        
        sum-=current.val;
        
        if(current.left==null && current.right==null && sum==0)
            return true;
        
        return findSum(current.left,sum) || findSum(current.right, sum);
    }
}