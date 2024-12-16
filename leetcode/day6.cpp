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
        next = nullptr;
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
};
class Solution
{
public:
    ListNode *findInNode(vector<int> &nums, ListNode *head)
    {
        ListNode *temp = head;
        while (temp != nullptr)
        {
            for (int num : nums)
            {
                if (num == temp->val)
                {
                    return temp;
                }
            }
            temp = temp->next;
        }
        return nullptr;
    }
    ListNode *modifiedList(vector<int> &nums, ListNode *head)
    {
        if (!head)
            return nullptr;

        ListNode *temp = head;
        ListNode *prev = nullptr;

        while (temp != nullptr)
        {
            ListNode *foundNode = findInNode(nums, temp);
            if (foundNode != nullptr)
            {
                if (prev != nullptr)
                {
                    prev->next = foundNode->next;
                }
                else
                {
                    head = foundNode->next;
                }
                temp = foundNode->next;
            }
            else
            {
                prev = temp;
                temp = temp->next;
            }
        }
        print(head);
        return head;
    }
};


int main()
{
    vector<int> ch = {1, 2, 3, 4, 5};
    ListNode *node1 = new ListNode(ch[0]);
    ListNode *head = node1;
    ListNode *tail = node1;
    for (int i = 1; i < ch.size(); i++)
    {
        insertAtTail(tail, ch[i]);
    }
    vector<int> nums = {2, 3};
    Solution result;
    result.modifiedList(nums, head);
    return 0;
}