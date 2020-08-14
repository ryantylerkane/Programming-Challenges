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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> stk = new Stack<List<Integer>>();
        Queue<TreeNode> toVisit = new LinkedList<>();
        ArrayList<List<Integer>> answer = new ArrayList<List<Integer>>();
        
        if(root !=null)
            toVisit.add(root);
        
        ArrayList<Integer> level = new ArrayList<>();
        while(!toVisit.isEmpty())
        {
            int size = toVisit.size();
            for(int i =0; i < size;i++)
            {
                TreeNode current = toVisit.poll();
                level.add(current.val);
                if(current.left != null)
                    toVisit.add(current.left);
                if(current.right!=null)
                    toVisit.add(current.right);
            }
            stk.push(new ArrayList<>(level));
            level.clear();
        }
        
       while(!stk.isEmpty())
           answer.add(stk.pop());
        
        return answer;
    }
}