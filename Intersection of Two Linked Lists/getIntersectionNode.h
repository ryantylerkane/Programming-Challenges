/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        
        if(headA == NULL || headB==NULL) //One of the lists are empty.
        {
            return NULL;
        }
        
        ListNode *currA = headA;
        ListNode *currB = headB;
        int longerBy=0;
        
        while(currA-> next != NULL && currB ->next != NULL) //Traverse to the end of one of the lists.
        {
            if(currA==currB)
                return currA; //Match found
            currA = currA ->next;
            currB = currB -> next;
        }
        
        int aDiff = 0;
        int bDiff=0;
        
        if(currA->next != NULL)
            aDiff = getDifference(currA, currB);
        else
            bDiff = getDifference(currB, currA);
        
        if(aDiff == -1 || bDiff==-1) //If the lists don't share the same tail, then they don't intersect.
            return NULL;
        
        currA = headA;
        currB = headB;
        
        for(int i =0; i < aDiff;i++)
        {
            currA = currA->next;
        }
        
        for(int i=0; i < bDiff; i++)
            currB = currB->next;
        
        while(currA != currB)
        {
            currA = currA->next;
            currB = currB->next;
        }
        
        return currA;
    }
    
    int getDifference(ListNode *longHead, ListNode *shortHead)
    {
        
        int difference = 0;
        while(longHead -> next != NULL)
        {
            longHead = longHead->next;
            difference++;
        }
        
        if(longHead != shortHead) //Return -1 to indicate the lists don't share the same tail.
            difference = -1;
        return difference;
    }
    
};