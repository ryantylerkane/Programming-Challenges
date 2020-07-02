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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        if(root==null)
        {
            return ret;
        }
        
        ArrayList<TreeNode> children = new ArrayList<>(); 
        children.add(root);
        
        boolean zig = true;
        while(children.size() != 0)
        {
            ret.add(zigZag(children,zig));
            zig = (!zig);
            
        }
        
        return ret;
        
    }
    
    public LinkedList<Integer> zigZag(ArrayList<TreeNode> children, boolean isZig) //Traverses left to right.
    { //Treats the children array as a queue.
        int currentSize = children.size();
        TreeNode currentNode=null;
        LinkedList<Integer> list = new LinkedList<>();
        
            for(int i=currentSize-1; i >=0 ;i--)
            {
                currentNode = children.get(i);
                if(isZig) //Traverse left toright.
                {
                    if(currentNode.left!=null)
                        children.add(currentNode.left);
                    if(currentNode.right!=null)
                        children.add(currentNode.right);
                }
                else //Traverse right to left.
                {
                    if(currentNode.right!=null)
                        children.add(currentNode.right);
                    if(currentNode.left!=null)
                        children.add(currentNode.left);
                }
                
                 
                list.add(currentNode.val);
            }
            
        
        children.subList(0, currentSize).clear();
        return list;
    }
}