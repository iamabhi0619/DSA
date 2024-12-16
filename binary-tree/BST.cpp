#include <iostream>
using namespace std;
struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int data)
    {
        val = data;
        left = right = nullptr;
    }
};

TreeNode* insert(TreeNode* root, int val){
    if(root == nullptr){
        return new TreeNode(val);
    }
    if(val < root->val){
        root->left = insert(root->left, val);
    }
    else if(val > root->val){
        root->right = insert(root->right, val);
    }
    return root;
}

bool search(TreeNode* root, int check){
    if(root == nullptr) return false;
    if(root->val == check) return true;
    if(check < root->val) return search(root->left, check);
    if(check > root->val) return search(root->right, check);
}


//left->root->right
void inorder(TreeNode* root){
    if(root == nullptr) return;
    inorder(root->left);
    cout << root->val << " ";
    inorder(root->right);
}


int main()
{
    int arr[] = {2,4,9,1,4,6,2,7,8,11,24};
    int n = sizeof(arr)/sizeof(int);
    TreeNode* root = nullptr;
    for(auto x:arr){
        root = insert(root, x);
    }
    inorder(root);
    cout << endl;
    cout << search(root,21);
    cout << endl;
    return 0;
}
