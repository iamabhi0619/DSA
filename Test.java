import java.util.*;

class Solution {
    static int firstOccurance(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                res = mid;
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    static int lastOccurance(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                res = mid;
                start = mid + 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    public static int countOccurrences(int[] arr, int target) {
        int first = firstOccurance(arr, target);
        // if(first)
        int last = lastOccurance(arr, target);
        return last - first + 1;
    }

}

public class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = { 10, 20, 30, 30, 30, 40, 50 };
        int res = sol.countOccurrences(arr, 30);
        System.out.println("Answer:- " + res);
    }
}