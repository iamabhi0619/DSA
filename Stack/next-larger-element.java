import java.util.*;

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty())
                result[i] = stack.peek();
            else
                result[i] = -1;
            stack.push(arr[i]);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int num : result)
            res.add(num);
        return res;
    }
}
