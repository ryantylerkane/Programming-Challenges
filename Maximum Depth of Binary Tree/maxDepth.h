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
    int maxDepth(TreeNode* root) {
        
        if(root==NULL)
            return 0;
        
        if(root->left==NULL && root->right==NULL)
            return 1;
        
        stack<pair<TreeNode*, int>> dfs;
        int answer=0;
        
        dfs.push(pair<TreeNode*, int>(root,1));
        pair<TreeNode*, int> current;
        
        while(!dfs.empty())
        {
            current = dfs.top();
            dfs.pop();
            
             if(current.first->left ==NULL && current.first->right == NULL)
            {
                answer = (current.second > answer) ? current.second : answer;
            }
            else
            {
                if(current.first->left!=NULL)
                {
                    dfs.push(pair<TreeNode*, int>(current.first->left, current.second+1));
                }

                if(current.first->right != NULL)
                {
                    dfs.push(pair<TreeNode*, int>(current.first->right, current.second+1));
                }
            }    
        }
        
        return answer;
    }
};