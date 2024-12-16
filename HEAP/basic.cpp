#include <iostream>
#include <vector>
using namespace std;

class MaxHeap
{
    vector<int> heap;
    void heapifyUp(int index)
    {
        if (index == 0)
            return;
        int parent = (index - 1) / 2;
        if (heap[index] > heap[parent])
        {
            swap(heap[index], heap[parent]);
            heapifyUp(parent);
        }
    }

    void heapifyDown(int index)
    {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest = index;
        if (leftChild < heap.size() && heap[leftChild] > heap[largest])
            largest = leftChild;
        if (rightChild < heap.size() && heap[rightChild] > heap[largest])
            largest = rightChild;
        if (largest != index)
        {
            swap(heap[index], heap[largest]);
            heapifyDown(largest);
        }
    }

public:
    void insert(int val)
    {
        heap.push_back(val);
        heapifyUp(heap.size() - 1);
    }
    void removeTop()
    {
        if (heap.size() == 0)
        {
            cout << "Heap is empty" << endl;
            return;
        }
        swap(heap[0], heap[heap.size() - 1]);
        heap.pop_back();
        heapifyDown(0);
        return;
    }
    void print()
    {
        for (int value : heap)
        {
            cout << value << " ";
        }
        cout << endl;
    }
};

int main()
{
    MaxHeap heap;

    // Insert elements
    heap.insert(10);
    heap.insert(20);
    heap.insert(5);
    heap.insert(30);

    cout << "Heap elements: ";
    heap.print();

    heap.removeTop();

    cout << "Heap after extraction: ";
    heap.print();

    return 0;
}