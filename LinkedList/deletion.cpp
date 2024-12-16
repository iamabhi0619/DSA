#include <iostream>
#include <vector>
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
void insertionAtHead(ListNode *&head, ListNode *&tail, int val)
{
    ListNode *temp = new ListNode(val);
    if (head == nullptr)
    {
        head = temp;
        tail = temp;
    }
    temp->next = head;
    head = temp;
}
void insertionAtTail(ListNode *&head, ListNode *&tail, int val)
{
    ListNode *temp = new ListNode(val);
    if (tail == nullptr)
    {
        head = temp;
        tail = temp;
    }
    tail->next = temp;
    tail = temp;
}
void deletionofelementAtHead(ListNode *&head)
{
    if (head == nullptr)
    {
        cout << "No head to delete" << endl;
        return;
    }
    head = head->next;
}
void deletionofelementAtTail(ListNode *&head)
{
    if (head == nullptr)
    {
        cout << "No tail to delete" << endl;
        return;
    }
    ListNode *temp = head;
    while (temp->next->next != nullptr)
    {
        temp = temp->next;
    }
    temp->next = nullptr;
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
void deletionofelementAtPosition(ListNode *&head, int k)
{
    if (k == 1)
    {
        head = head->next;
        return;
    }
    int c = 1;
    ListNode *temp = head;

    while (temp->next != nullptr)
    {
        ++c;
        if (c == k)
        {
            if (temp->next->next != nullptr)
            {
                temp->val = temp->next->val;
                temp->next = temp->next->next;
                return;
            }
            else
            {
                temp->next = nullptr;
                return;
            }
        }
        temp = temp->next;
    }
    cout << "No elemet To delete" << endl;
}
int main()
{
    vector<int> arr = {1, 2, 3, 4, 5, 6, 7};
    ListNode *head = nullptr;
    ListNode *tail = nullptr;
    for (int i = 0; i < arr.size(); i++)
    {
        insertionAtTail(head, tail, arr[i]);
    }
    print(head);
    // deletionofelementAtHead(head);
    // print(head);
    // deletionofelementAtTail(head);
    // print(head);
    deletionofelementAtPosition(head, 8);
    print(head);
    return 0;
}
