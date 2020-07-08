public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode run = head;
        ListNode walk = head;
        
        while(run != null && run.next != null)
        {
            walk = walk.next;
            run = run.next.next;
            
            if(walk==run)
            {
                return true;
            }
        }
        
        return false;
    }
}