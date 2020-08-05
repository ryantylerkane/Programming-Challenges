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
    TreeNode* increasingBST(TreeNode* root) {
       vector<int> values;
        inOrder(root, values);
        TreeNode *returnTree = new TreeNode();
        TreeNode *current = returnTree;
        for(auto v: values)
        {
            current->right = new TreeNode(v);
            current->left = NULL;
            current = current->right;
            
        }
        
        return returnTree->right;
    }
    
private:
    void inOrder(TreeNode* root, vector<int>& values)
    {
        if(root != NULL)
        {
            inOrder(root->left, values);
            values.push_back(root->val);
            inOrder(root->right, values);
        }
    }
};