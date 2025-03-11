
import java.util.ArrayList;
import java.util.List;

public class KnuthMorrisPartt {

    public static List<Integer> lps(String str) {
        List<Integer> res = new ArrayList<>();
        int n = str.length();
        int longestMatch = 0;
        res.add(0);
        for (int i = 1; i < n; i++) {
            while (longestMatch > 0 && str.charAt(i) != str.charAt(longestMatch)) {
                longestMatch = res.get(longestMatch - 1);
            }
            if (str.charAt(i) == str.charAt(longestMatch)) {
                longestMatch++;
            }
            res.add(longestMatch);
        }
        return res;
    }

    public static List<Integer> kmp(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> lps = lps(p);
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < n) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                res.add(i - j);
                j = lps.get(j - 1);
            } else if (i < n && s.charAt(i) != p.charAt(j)) {
                if (j != 0) {
                    j = lps.get(j - 1);
                } else {
                    i++;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String str = "ababcabcabababd";
        String pattern = "ababd";

        List<Integer> res = kmp(str, pattern);

        System.out.println("Result fond at:- " + res);
    }
}
