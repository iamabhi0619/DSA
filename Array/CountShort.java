
import java.util.Arrays;

public class CountShort {

    static void count(int arr[]) {
        int n = arr.length;
        if (n == 0)
            return;

        int max = Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
        int min = Arrays.stream(arr).min().orElse(Integer.MAX_VALUE);
        int range = max - min + 1;

        int[] count = new int[range];
        int[] res = new int[n];

        // frequency array
        for (int num : arr) {
            count[num - min]++;
        }

        // coumaltive frequency array
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            res[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        System.arraycopy(res, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int arr[] = { 100, 2, 3, 99, 1, 1000, 500, 10, 20, 300, 15, 150, 5, 250, 50, 75, 100, 4,
                87, 35, 120, 30, 45, 89, 95, 0, 101, 55, 200, 18, 75, 98, 76, 17, 150, 25,
                110, 105, 80, 70, 92, 40, 140, 190, 260, 180, 220, 170, 130, 160, 210, 280,
                240, 270, 230, 290, 310, 330, 350, 320, 340, 360, 400, 380, 370, 390, 420,
                450, 430, 410, 470, 440, 460, 490, 480, 500, 520, 540, 560, 580, 600, 620,
                640, 660, 680, 700, 720, 740, 760, 780, 800, 820, 840, 860, 880, 900, 920,
                940, 960, 980, 1000
        };

        System.out.print("Original Array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        long startTime = System.nanoTime();

        count(arr);

        long endTime = System.nanoTime();

        System.out.print("Sorted Array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Execution time: " + (endTime - startTime) + " ns");
    }
}
