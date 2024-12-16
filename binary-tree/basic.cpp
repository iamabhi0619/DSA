#include <iostream>
using namespace std;
struct Node
{
    int data;
    Node *left;
    Node *right;

    Node(int val)
    {
        data = val;
        left = right = nullptr;
    }
};

Node* insertation(int arr[], int start, int end){
    if(start >= end) return nullptr;
    Node* root = new Node(arr[start]);
    root->left = insertation(arr, 2*start+1, end);
    root->right = insertation(arr, 2*start+2, end);
    return root;
}


void inorder(Node *root)
{
    if (root != nullptr)
    {
        inorder(root->left);
        cout << root->data << " ";
        inorder(root->right);
    }
}

int main()
{
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
    int n = sizeof(arr)/sizeof(int);
    cout << n << endl;
    for(auto x:arr){
        cout << x << " ";
    }
    cout << endl;
    Node *root = insertation(arr, 0, n);
    cout << "Element in tree" << endl;
    inorder(root);
    cout << endl;
    return 0;
}
