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
void insertAtHead(ListNode *&head, int value)
{
    ListNode *temp = new ListNode(value);
    temp->next = head;
    head = temp;
}
void insertAtTail(ListNode *&tail, ListNode *&head, int value)
{
    ListNode *temp = new ListNode(value);
    if (head == nullptr)
    {
        cout <<"Insertion at head happend" << endl;
        head = temp;
        tail = temp;
    }
    else
    {
        cout <<"Insertion at tail happend" << endl;
        tail->next = temp;
        tail = temp;
    }
}
void print(ListNode *head)
{
    while (head != nullptr)
    {
        cout << head->val << " ";
        head = head->next;
    }
    cout << endl;
}
int main()
{
    int arr[] = {10, 20, 30, 40, 50};
    int n = 5;
    ListNode *head = nullptr;
    ListNode *tail = nullptr;
    for (int i = 0; i < 5; i++)
    {
        insertAtTail(tail, head, arr[i]);
    }
    print(head);
    // ListNode* head = new ListNode(10);
    // ListNode* tail = head;
    // print(head);
    // insertAtHead(head, 20);
    // print(head);
    // insertAtTail(tail,30);
    // print(head);// 20 10 30
    return 0;
}
