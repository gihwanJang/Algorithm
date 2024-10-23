import java.io.*;
import java.util.*;

class Info implements Comparable<Info> {
    String s;
    int i;
    int d;

    public Info(String s, int i, int d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    @Override
    public int compareTo(Info o) {
        return i - o.i;
    }

}

class Problem {
    private int n;
    private Info[] infos;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        infos = new Info[n];
        for (int i = 0; i < n; ++i) {
            String[] in = br.readLine().split(" ");
            infos[i] = new Info(in[0], Integer.parseInt(in[1]), Integer.parseInt(in[2]));
        }
        solve();
    }

    private void solve() {
        int up = 'A' - 'a';
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(infos);
        for (int i = 0; i < n; ++i) {
            char c = infos[i].s.charAt(infos[i].d-1);
            if ('a' <= c && c <= 'z') {
                c += up;
            }
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}

public class Baekjoon26150 {
    public static void main(String[] args) {
        new Problem();
    }
}
