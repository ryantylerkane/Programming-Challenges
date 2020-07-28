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
    vector<vector<int>> levelOrder(TreeNode* root) {
        
        vector<vector<int>> answer;
          if(root==NULL)
            return answer;
        
        queue<TreeNode*> level;
        vector<int> currentLevel;
        
        level.push(root);
        int size;
        while(!level.empty())
        {
            TreeNode *current;
            size = level.size();
           for(int i=0; i < size;i++) 
           {
               current = level.front();
               level.pop();
               currentLevel.push_back(current->val);
                if(current->left != NULL)
                {
                    level.push(current->left);
                }
                if(current->right!=NULL)
                {
                    level.push(current->right);
                }
           }
            
            answer.push_back(currentLevel);
            currentLevel.clear();
        }
        
         return answer;
    }
};