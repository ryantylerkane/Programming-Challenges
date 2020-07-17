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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head.next!=null)
        {   ListNode walker = head;
            ListNode runner = head;

            while(runner.next!= null) //Traverse runner to last element and walker to one before target node.
            {
                runner = runner.next;
                if(n>0)
                    n--;
                else
                    walker = walker.next;
            }
         
         if(n>0)
             head = head.next;
        walker.next = walker.next.next;
        }
        else
            head=null;
        
        return head;
    }
}