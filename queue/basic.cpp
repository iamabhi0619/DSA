#include <bits/stdc++.h>
using namespace std;

class Queue
{
    int *arr;
    int front;
    int rear;
    int capacity;

public:
    Queue(int n)
    {
        front = 0;
        rear = -1;
        capacity = n;
        arr = new int[n];
    }
    void push(int val)
    {
        if (rear == capacity - 1)
        {
            cout << "Can't insert more elements, Queue is full" << endl;
            return;
        }
        arr[++rear] = val;
    }
    void pop()
    {
        if (front > rear)
        {
            cout << "Queue is empty" << endl;
            return;
        }
        for (int i = 0; i < rear; i++)
        {
            arr[i] = arr[i + 1];
        }
        rear--;
    }
    bool isEmpty()
    {
        return front > rear;
    }
    bool isFull()
    {
        return rear == capacity - 1;
    }
    int size()
    {
        return rear + 1;
    }
    void print()
    {
        if (isEmpty())
        {
            cout << "Queue is empty" << endl;
            return;
        }

        cout << "Queue elements: ";
        for (int i = front; i <= rear; i++)
        {
            cout << arr[i] << " ";
        }
        cout << endl;
    }
};

int main()
{
    Queue q(5);

    q.push(10);
    q.print();
    q.push(20);
    q.print();
    q.push(30);
    q.print();

    q.pop();
    q.print();
    q.push(30);
    q.print();
    q.pop();
    q.print();
    return 0;
}
