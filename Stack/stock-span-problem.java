import java.util.*;

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
                indexStack.pop();
            }

            if (!stack.isEmpty())
                res[i] = i - indexStack.peek();
            else
                res[i] = i + 1;

            stack.push(arr[i]);
            indexStack.push(i);
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp.add(res[i]);
        }
        return temp;

    }
}