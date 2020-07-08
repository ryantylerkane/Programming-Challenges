class MinStack {
    
    struct Node
    {
        int min;
        int value;
        Node* next;    
    };
    
    Node *head;
    
public:
    MinStack() {
        head = NULL;
    }
    
    void push(int x) {
        
        Node *temp = new Node;
        temp->value = x;
        
        if(head==NULL || x < head->min)
            temp->min = x;
            
        else //List is non-empty and > current minimum value.
            temp->min = head->min;
        
        temp->next = head;
        head = temp;
    }
    
    void pop() {
        
        Node *temp = head;
        head = head->next;
        delete temp;
    }
    
    int top() {
        
        return head->value;
        
    }
    
    int getMin() {
        
        return head->min;
    }
};