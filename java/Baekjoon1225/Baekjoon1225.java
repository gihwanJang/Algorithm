import java.io.*;
import java.util.*;

class Problem {
    String a, b;

    public Problem(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public long solve() {
        long ans = 0;
        for(int i = 0; i < a.length(); ++i) {
            for(int j = 0; j < b.length(); ++j) {
                ans += (a.charAt(i)-'0') * (b.charAt(j)-'0');
            }
        }
        return ans;
    }
}

public class Baekjoon1225 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem problem = new Problem(st.nextToken(), st.nextToken());
        System.out.println(problem.solve());
    }
}
