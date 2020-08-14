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
    vector<string> binaryTreePaths(TreeNode* root) {
        
        if(root == NULL)
        {
            return ret;
        }
        findPath(root, "");
        return ret;
    }
    
private:
    
    vector<string> ret;
    
    void findPath(TreeNode *root, string s)
    {
        if(s!="") //Make sure not to put -> prior to root.
            s.append("->");
        
        s.append(to_string(root->val));
        if(root->left==NULL && root->right==NULL)
            ret.push_back(s);
        if(root->left != NULL)
            findPath(root->left, s);
        if(root->right != NULL)
            findPath(root->right, s);
    }
    
};