#include <iostream>
#include <queue>
using namespace std;
struct Node
{
    int data;
    Node* left;
    Node* right;
    Node(int val){
        data = val;
        left=right=nullptr;
    }
};

Node* insert(int arr[], int start, int end){
    if(start>=end) return nullptr;
    Node* root = new Node(arr[start]);
    root->left = insert(arr, 2*start+1, end);
    root->right = insert(arr, 2*start+2, end);
    return root;
}

//preorder
//root->left->right
void preorder(Node* root){
    if(root==nullptr) return;
    cout << root->data << " ";
    preorder(root->left);
    preorder(root->right);
}

//inorder
//left->root->right
void inorder(Node* root){
    if(root==nullptr) return;
    inorder(root->left);
    cout<< root->data << " ";
    inorder(root->right);
}

//postorder
//left->right->root
void postorder(Node* root){
    if(root==nullptr) return;
    postorder(root->left);
    postorder(root->right);
    cout << root->data << " ";
}

void BFT(Node* root){
    if(root == nullptr) return;
    queue<Node*>q;
    q.push(root);
    while (!q.empty())
    {
        Node* temp = q.front();
        q.pop();
        cout << temp->data << " ";

        if(temp->left != nullptr){
            q.push(temp->left);
        }
        if(temp->right != nullptr){
            q.push(temp->right);
        }
    }
    
}


int main()
{
    int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
    int n = sizeof(arr)/sizeof(int);
    Node* root = insert(arr,0,n);
    cout << "PreOrder:- ";
    preorder(root);
    cout << endl << "InOrder:- ";
    inorder(root);
    cout << endl << "PostOrder:- ";
    postorder(root);
    cout << endl << "LevelOrder:- ";
    BFT(root);
    cout << endl;
    return 0;
}
