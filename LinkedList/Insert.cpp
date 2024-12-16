#include <bits/stdc++.h>
using namespace std;
class ListNode
{
public:
    int val;
    ListNode *next;
    ListNode(int val)
    {
        this->val = val;
        this->next = nullptr;
    }
};
void insertAtHead(ListNode *&head, int val)
{
    ListNode *temp = new ListNode(val);
    temp->next = head;
    head = temp;
}
void insertAtTail(ListNode *&tail, int val)
{
    ListNode *temp = new ListNode(val);
    tail->next = temp;
    tail = temp;
}
void printNodeVal(ListNode *&head)
{
    ListNode *temp = head;
    while (temp != nullptr)
    {
        cout << temp->val << " ";
        temp = temp->next;
    }
    cout << endl;
}
void printNodeAdd(ListNode *&head)
{
    ListNode *temp = head;
    while (temp != nullptr)
    {
        cout << temp->next << " ";
        temp = temp->next;
    }
    cout << endl;
}
int main()
{
    ListNode *node1 = new ListNode(20);
    ListNode *head = node1;
    ListNode *tail = node1;
    insertAtHead(head, 10);
    insertAtTail(tail, 30);
    insertAtTail(tail, 40);
    printNodeVal(head);
    printNodeAdd(head);
    return 0;
}
