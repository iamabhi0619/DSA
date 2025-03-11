import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    static void merge(int arr[], int l, int mid, int r) {
        List<Integer> temp = new ArrayList<>();
        int i = l;
        int j = mid + 1;
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                j++;
            }
        }
        while (i <= mid) {
            temp.add(arr[i]);
            i++;
        }
        while (j <= r) {
            temp.add(arr[j]);
            j++;
        }

        int n = temp.size();
        for (int k = 0; k < n; k++) {
            arr[k + l] = temp.get(k);
        }
    }

    static void mergeSort(int arr[], int l, int r) {
        if (l >= r)
            return;
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void main(String[] args) {
        int arr[] = { 12, 31, 35, 8, 32, 17 };
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}
