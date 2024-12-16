// insertion:
//  Insert at head --> insert before the first node
//  Insert at tail --> insert after the last node
#include <iostream>
using namespace std;
class ListNode
{
public:
    int val;
    ListNode *next;
    ListNode(int val)
    {
        this->val = val;
        next = nullptr;
    }
};
void insertAtHead(ListNode *&head, int val)
{
    ListNode *temp = new ListNode(val);
    temp->next = head;
    head = temp;
}
void insertAtTail(ListNode *&tail, int val){
    ListNode *temp = new ListNode(val);
    tail->next = temp;
    tail = tail->next;
}
void print(ListNode *&head)
{
    ListNode *temp = head;
    while (temp != nullptr)
    {
        cout << temp->val << " ";
        temp = temp->next;
    }
    cout << endl;
}

int main()
{
    ListNode *node1 = new ListNode(10);
    ListNode *head = node1;
    ListNode *tail = node1;
    insertAtTail(tail, 12);
    insertAtTail(tail, 13);
    print(head);
    return 0;
}
