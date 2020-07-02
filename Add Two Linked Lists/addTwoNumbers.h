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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        
        int sum =l1->val + l2->val;
        int remainder = sum/10;
        
        ListNode *answer = new ListNode(sum%10);
        ListNode *current = answer;
        
        l1 = l1->next;
        l2 = l2->next;
        
        int l2Val = 0;
        int l1Val = 0;
        
        while(l1 != NULL || l2 != NULL)
        {
            if(l1 == NULL)
            {
                l1Val = 0;
                l2Val = l2->val;
                l2 = l2->next;
            }
            else if(l2==NULL)
            {
                l2Val = 0;
                l1Val = l1->val;
                l1 = l1->next;
            }
            else
            {
                l1Val = l1->val;
                l2Val = l2->val;
                l1 = l1->next;
                l2 = l2->next;
            }

            sum = l1Val + l2Val+remainder;

            current -> next = new ListNode(sum%10);
            current = current->next;

            if(sum >= 10)
                remainder = sum/10;
            else
                remainder = 0;
        }
        
        if(remainder>0)
            current-> next = new ListNode(remainder);
        
        return answer;
    }
    
    
};