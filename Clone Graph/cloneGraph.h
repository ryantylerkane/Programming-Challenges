/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    Node* cloneGraph(Node* node) {
        
        if(node==NULL)
            return NULL;
        
        unordered_map<int,Node*> visited;
        Node *original = node;
        return createNewNode(visited, original);
    }
    
private:
    Node* createNewNode(unordered_map<int,Node*>& visited, Node* original)
    {
        Node *newNode = new Node(original->val);
        visited.emplace(newNode->val, newNode);
        
        for(int i =0; i < original->neighbors.size();i++)
        {
            if(visited.find(original->neighbors[i]->val) == visited.end())
            {
                createNewNode(visited, original->neighbors[i]);
            }
            newNode->neighbors.push_back(visited.find(original->neighbors[i]->val)->second);
                
        }
        
        return newNode;
    }
    
    
};