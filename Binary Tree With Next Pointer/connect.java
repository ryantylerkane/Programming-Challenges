/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)
            return null; //Tree is empty.
       
        root.next = null;
        connectRight(root);
        
        return root;
        
        
    }
    
    public void connectRight(Node root)
    {
        if(root.left!=null) //Then root.right must not be null either.
        {
            root.left.next = root.right;
            if(root.next != null)
                root.right.next = root.next.left;
            else
                root.right.next = null;
            connectRight(root.left);
            connectRight(root.right);
        }
            
        
    }
}