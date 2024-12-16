void heapify(vector<int>& v, int index) {
//     int leftChild = 2 * index + 1;  // Left child index
//     int rightChild = 2 * index + 2;  // Right child index
//     int smallest = index;  // Assume the current node is the smallest

//     // If the left child exists and is smaller than the current node
//     if (leftChild < v.size() && v[leftChild] < v[smallest]) {
//         smallest = leftChild;
//     }

//     // If the right child exists and is smaller than the smallest value
//     if (rightChild < v.size() && v[rightChild] < v[smallest]) {
//         smallest = rightChild;
//     }

//     // If the smallest value is not the current node, swap and heapify
//     if (smallest != index) {
//         swap(v[index], v[smallest]);
//         heapify(v, smallest);  // Recursively heapify the affected subtree
//     }
// }