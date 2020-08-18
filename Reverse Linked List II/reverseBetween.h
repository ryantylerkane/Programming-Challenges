/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        
        if(head==NULL)
            return head;
        
        ListNode *lowerBound = NULL, *upperBound = NULL;
        ListNode *beg = NULL;
        ListNode* end = head;
        ListNode *temp = NULL;
      
        while(m > 1) //Navigate to lower bound to be reversed.
        {
            beg = end;
            end = end->next;
            m--;
            n--;
        }
        
        lowerBound = beg;
        upperBound = end;
        
        while(n > 0)
        {
            temp = end->next;
            end->next = beg;
            beg = end;
            end = temp;
            n--;
        }
        
        if(lowerBound != NULL)
            lowerBound->next = beg;
        else
            head = beg;
        
        upperBound->next = end;
        
        return head;
        
        
    }