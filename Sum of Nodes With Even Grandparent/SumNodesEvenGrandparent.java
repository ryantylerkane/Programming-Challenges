public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
 
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        if(root ==null)
            return 0;
        return sumValues(root.left, root, null) + sumValues(root.right, root, null); //Sum values recursively in left and right sub-tree.
        
    }
    
    
    public int sumValues (TreeNode root, TreeNode parent, TreeNode grand)
    {
        int value = 0;
        
        if(root==null)
        {
            return 0; //Base case - Current node is root.
        }
        if(grand!= null && grand.val%2==0) //Only add the value if a grandparent exists and is an even number.
        {
            value = root.val;
        }
        
        return value + sumValues(root.left, root, parent) + sumValues(root.right, root, parent);
    }
}