import java.io.*;
import java.util.*;

class Problem {
    String str;
    private static final int[] ALPHABAT = new int[26];

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        for (int i = 0; i < str.length(); ++i) {
            ++ALPHABAT[str.charAt(i) - 'a'];
        }
        System.out.println(solve(0, -1));
    }

    private int solve(int index, int prev) {
        if (index == str.length()) {
            return 1;
        }

        int ret = 0;
        for (int i = 0; i < 26; ++i) {
            if (ALPHABAT[i] > 0 && (prev != i)) {
                --ALPHABAT[i];
                ret += solve(index + 1, i);
                ++ALPHABAT[i];
            }
        }
        return ret;
    }
}
public class Baekjoon1342 {
    public static void main(String[] args) {
        new Problem();
    }    
}
