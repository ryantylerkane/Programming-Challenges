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
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root==null)
            return false;
        
      ArrayList<ArrayList<TreeNode>> families = new ArrayList<ArrayList<TreeNode>>();
        boolean isX = false;
        boolean isY = false;
        
        ArrayList<TreeNode> first = new ArrayList<>();
        first.add(root);
        families.add(new ArrayList<TreeNode>(first));
        while(!families.isEmpty())
        {
            int size = families.size();
            for(int i=0; i < size;i++)
            {
                ArrayList<TreeNode> newFamily = new ArrayList<>();
                for(int j=0; j < families.get(i).size();j++)
                {
                    TreeNode current = families.get(i).get(j);

                    if(current.left != null)
                        newFamily.add(current.left);
                    if(current.right != null)
                        newFamily.add(current.right);
                    if(current.left != null && current.right != null)
                    {
                        if(current.left.val==x && current.right.val==y || current.left.val==y && current.right.val==x)
                            return false;
                    }
                    
                    if(current.val==x && !isX)
                    {
                        isX = true;
                    }
                    else if(current.val==y && !isY)
                    {
                        isY=true;
                    }
                }
                families.remove(0);
                if(isX && isY)
                    return true;
                else
                {
                    isX = false;
                    isY=false;
                }
                if(newFamily.size() > 0)
                    families.add(new ArrayList<TreeNode>(newFamily));
            }
        }
        
        return false;
    }
}