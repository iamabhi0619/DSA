
import java.util.ArrayList;
import java.util.List;

public class RabinKarp {
    public static int hashFunction(Character s) {
        return (int) s - 96;
    }

    public static List<Integer> rollingHash(String s, String p) {
        int n = s.length();
        int m = p.length();
        int pHash = 0;
        int sHash = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            pHash += hashFunction(p.charAt(i));
            sHash += hashFunction(s.charAt(i));
        }
        for (int i = 0; i <= n - m; i++) {
            if (pHash == sHash) {
                int j = 0;
                while (j < m) {
                    if (s.charAt(i + j) == p.charAt(j)) {
                        j++;
                    } else {
                        break;
                    }
                    if (j == m)
                        res.add(i);
                }
            }
            if (i < n - m) {
                sHash = sHash - hashFunction(s.charAt(i)) + hashFunction(s.charAt(i + m));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "abcdabce";
        String pattern = "bce";

        long startTime = System.nanoTime();
        List<Integer> match = rollingHash(str, pattern);
        long endTime = System.nanoTime();
        System.out.println("Pattern found at indexs: " + match);
        System.out.println("Execution time: " + (endTime - startTime) + " ns");
    }
}
