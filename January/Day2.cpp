#include <stddef.h>

class Day2 {
public:
    struct TreeNode {
        int val;
        TreeNode *left;
        TreeNode *right;
        TreeNode(int x) : val(x), left(NULL), right(NULL) {}
    };

    TreeNode* getTargetCopy(TreeNode* original, TreeNode* cloned, TreeNode* target) {
        if (cloned == NULL || cloned -> val == target -> val) {
            return cloned;  
        }
        TreeNode* rightNode = getTargetCopy(original, cloned -> right, target);
        TreeNode* leftNode = getTargetCopy(original, cloned -> left, target);
        
        if (rightNode == NULL) {
            return leftNode;
        }
        return rightNode;
    }
};