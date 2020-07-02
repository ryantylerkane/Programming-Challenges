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
    ListNode* oddEvenList(ListNode* head) {
        
        /*Have a runner printer that will obtain odd values and a walker pointer that will obtain even values
        *and overwrite them with odd values.*/
        
        if(head==NULL|| head->next == NULL || head->next->next ==NULL) //List is only one or two nodes long.
            return head; //Return the list as is.
        
        //Else, list is at least three elements long. 
        ListNode *even = head->next;
        ListNode *odd = even->next;
        ListNode *writer = even;
        vector<int> evenNums;
        
        swap(even, odd, evenNums, writer);

        while(odd->next != NULL && odd->next->next != NULL) //Group together all odd nodes.
        {
            even = even->next->next;
            odd = odd->next->next;
            writer = writer->next;
            swap(even, odd, evenNums, writer);
            if(odd->next==NULL)
            {
                break;
            }
        }
        
        writer = writer->next;
        
        for(int i=0; i < evenNums.size(); i++)
        {
            writer->val = evenNums.at(i);
            writer = writer->next;
        }
        
        return head;
        
    }
    
    void swap(ListNode *even, ListNode *odd, vector<int>& evenNums, ListNode* writer)
    {
        evenNums.push_back(even->val);
        writer->val = odd->val;
    }
};