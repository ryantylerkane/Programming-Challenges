/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int minDepth(TreeNode* root) {
        
        if(root==NULL)
            return 0;
        
        queue<TreeNode*> q;
        int level=0;
        int size;
        TreeNode* current;
        
        q.push(root);
        
        while(!q.empty())
        {
            size = q.size();
            level++;
            for(int i=0; i <size;i++)
            {
                current = q.front();
                q.pop();
                
                if(current->left == NULL && current->right==NULL)
                {
                    return level;
                }
                if(current->left != NULL)
                    q.push(current->left);
                if(current->right != NULL)
                    q.push(current->right);
            }
        }
        
        return level;
    }
};