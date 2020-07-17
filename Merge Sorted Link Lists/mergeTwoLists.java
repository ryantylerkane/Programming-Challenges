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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode answer = new ListNode(-1);
        ListNode tail = answer;
        while(l1 != null && l2 != null)
        {
           ListNode value;
            if(l1.val <= l2.val)
            {
                value = l1;
                l1 = l1.next;
            }
            else
            {
                value = l2;
                l2 = l2.next;
            }
            
            tail.next = value;
            tail = value;
        }
        
        ListNode remaining =null;
        if(l1 != null)
            remaining = l1;
        else
            remaining=l2;
        
        while(remaining != null)
        {
            tail.next = remaining;
            tail = remaining;
            remaining = remaining.next;
            
        }
        
        return answer.next;
    }
}