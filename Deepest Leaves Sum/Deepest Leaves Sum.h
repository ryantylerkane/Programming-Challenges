struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 };
 
class Solution {
public:
    int deepestLeavesSum(TreeNode* root) {
        if(root==NULL) //If the tree contains a single node then return an error value.
        {
            return -1;
        }
        
        int sum = 0;
        int lowestLevel = 0;
        traverseTree(root, lowestLevel, sum, 0);
        return sum;
    }
    
    void traverseTree(TreeNode* root, int& lowestLevel, int& sum, int level)
    {
        if(root->left == NULL && root->right ==NULL) //Base Case- Reached leaf.
        {
            if(level > lowestLevel)
            {
                lowestLevel = level;
                sum = root->val;
            } 
            else if(level == lowestLevel)
                sum+=root->val;
        }
        if(root->left != NULL) //Traverse left sub-tree.
        {
            traverseTree(root->left, lowestLevel, sum, level+1);
        }
        if(root->right != NULL) // Traverse right sub-tree.
        {
            traverseTree(root->right, lowestLevel, sum, level+1);
        }
    }
};