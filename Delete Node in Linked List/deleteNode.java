/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        
        ListNode prev = node;
        ListNode n = node.next;
        int tempVal=0;
        
        while(n.next!= null)
        {
            tempVal = n.val;
            n.val = prev.val;
            prev.val = tempVal;
            n=n.next;
            prev = prev.next;
        }
        
        tempVal = n.val;
        n.val = prev.val;
        prev.val = tempVal;
        prev.next=null;
    }
}