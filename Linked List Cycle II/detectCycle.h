class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
       ListNode *walk = head;
        ListNode *run = head;
        
        while(run != NULL && run->next != NULL)
        {
            walk = walk->next;
            run = run->next->next;
            
            if(walk==run)
            {
                return findCycle(run, walk,head);
            }
                
        }
        
        return NULL;
        
    }
    
private:
    ListNode* findCycle(ListNode *walk, ListNode *run, ListNode *head)
    {
        walk = head;
        
        while(run != walk)
        {
            run = run->next;
            walk = walk->next;
        }
        
        return walk;
    }
};