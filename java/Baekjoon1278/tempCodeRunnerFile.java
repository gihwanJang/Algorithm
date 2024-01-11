import java.io.*;

class Problem {
    int n;
    StringBuilder sb;

    public Problem(int n) {
        this.n = n;
        sb = new StringBuilder();
    }

    public String solve() {
        sb.append(1<<n-1).append("\n");
        f(n);
        sb.append(n);
        return sb.toString();
    }

    private void f(int x) {
        if (x == 0) {
            return;
        }
        f(x - 1);
        sb.append(x).append("\n");
        f(x - 1);
    }
}

public class Baekjoon1278 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem p = new Problem(Integer.parseInt(br.readLine()));
        System.out.println(p.solve());
    }
}
