import java.io.*;

class Problem {
    int n;
    public Problem(int n) {
        this.n = n;
    }
    public String solve() {
        int k = n % 100;
        if((n+1) % k == 0) {
            return "Good";
        }
        return "Bye";
    }
}

public class Baekjoon31090 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; ++t) {
            Problem problem = new Problem(Integer.parseInt(br.readLine()));
            sb.append(problem.solve()).append("\n");
        }

        System.out.print(sb.toString());
    }
}

