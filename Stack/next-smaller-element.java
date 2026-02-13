import java.util.*;

class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] <= s.peek())
                s.pop();

            if (!s.isEmpty())
                res[i] = s.peek();
            else
                res[i] = -1;

            s.push(arr[i]);
        }

        // CONVERT INTO ARRAYLIST
        ArrayList<Integer> temp = new ArrayList<>();
        for (int a : res) {
            temp.add(a);
        }
        return temp;
    }
}
