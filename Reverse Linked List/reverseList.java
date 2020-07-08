class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head==null ||head.next==null)
            return head;
        
        ListNode current = head;
        ListNode previous = null;
        ListNode next = head.next;
        
        while(next != null)
        {
            current.next = previous;
            previous = current;
            current = next;
            next = next.next;
        }
        
        current.next = previous;
        
        return current;
        
    }
}