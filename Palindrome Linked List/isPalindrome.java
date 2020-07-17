/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stk = new Stack<>();
        
        ListNode run = head;
        ListNode walk = head;
        
        while(run != null)
        {
            if(run.next==null)
            {
              break;
            }
            
            stk.push(walk.val);
            run = run.next.next;
            walk = walk.next;
        }
        
        if(run!=null) //Check if run is at last element or outside of the list to determine odd/even of list.
            walk = walk.next;
        
        while(walk != null)
        {
            if(stk.peek() != walk.val)
                return false;
            else
                stk.pop();
                walk = walk.next;
        }
        
       return true;
        
    }
}