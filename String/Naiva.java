
import java.util.ArrayList;
import java.util.List;

public class Naiva {
    public static List<Integer> bf(String s, String p) {
        int n = s.length();
        int m = p.length();

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && s.charAt(i + j) == p.charAt(j)) {
                j++;
            }
            if (j == m)
                res.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
        String str = "abcdabce";
        String pattern = "bce";

        long startTime = System.nanoTime();
        List<Integer> match = bf(str, pattern);
        long endTime = System.nanoTime();
        System.out.println("Pattern found at indexs: " + match);
        System.out.println("Execution time: " + (endTime - startTime) + " ns");
    }
}
