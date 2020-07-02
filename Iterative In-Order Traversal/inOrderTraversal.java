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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        ArrayList<Integer> returnList = new ArrayList<>();
        
        if(root==null)
            return returnList;
        
        if(root.left != null) //Traverse left sub-tree.
            traverseSubtree(root.left,returnList);
        
        returnList.add(root.val); //Visit parent after visiting left sub-tree.
        
        if(root.right != null) //Visit right sub-tree after visiting parent.
            traverseSubtree(root.right, returnList);
       
        return returnList;
        
    }
    
    private Stack<TreeNode> traverseLeft(TreeNode root, ArrayList<Integer> returnList)
    {
        Stack<TreeNode> parents = new Stack<TreeNode>();
        TreeNode traverse = root;
        while(traverse.left != null)
        {
            parents.push(traverse); //Push Parents onto the stack.
            traverse = traverse.left;
        }
        
        returnList.add(traverse.val); //Bottom leftmost node.
        
        if(traverse.right != null)
            traverseSubtree(traverse.right, returnList);
        
        return parents;
    }
    
    public void traverseSubtree(TreeNode root, ArrayList<Integer> returnList)
    {
         Stack<TreeNode> parents = traverseLeft(root, returnList);
         TreeNode temp;
        
        while(!parents.empty())
        {
            temp = parents.peek();
            returnList.add(temp.val);
            if(temp.right != null)
                traverseSubtree(temp.right, returnList);
            parents.pop(); //Remove parent from top of stack.
            
        }
        
    }

}