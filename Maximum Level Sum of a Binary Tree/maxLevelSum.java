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
    public int maxLevelSum(TreeNode root) {
        ArrayList<Integer> sums = new ArrayList<>();
        Queue<TreeNode> levels = new LinkedList<>();
        
        if(root!=null)
            levels.add(root);
        
        int size;
        TreeNode current;
        int sum;
        while(!levels.isEmpty())
        {
            sum = 0;
            size = levels.size();
            for(int i=0; i < size;i++)
            {
                current = levels.poll();
                sum+=current.val;
                if(current.left != null)
                    levels.add(current.left);
                if(current.right != null)
                    levels.add(current.right);
            }
            sums.add(sum);
        }
        
        int max = Integer.MIN_VALUE;
        int retVal = 0;
        for(int i = 0; i < sums.size();i++)
        {
            if(sums.get(i) > max)
            {
                max = sums.get(i);
                retVal = i;
            }
        }
        
        return retVal+1;
    }
}