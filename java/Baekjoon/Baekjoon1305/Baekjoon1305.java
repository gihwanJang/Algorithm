import java.io.*;

class Problem {
    private int l;
    private String str;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        l = Integer.parseInt(br.readLine());
        str = br.readLine();
        solve();
    }

    private void solve() {
        int s = 0;
        int[] table = new int[l];
        
        for (int e = 1; e < l; ++e) {
            while (s > 0 && str.charAt(s) != str.charAt(e)) {
                s = table[s - 1];
            }
            if (str.charAt(s) == str.charAt(e)) {
                table[e] = ++s;
            }
        }

        System.out.println(l - table[l-1]);
    }
}

public class Baekjoon1305 {
    public static void main(String[] args) {
        new Problem();
    }
}
