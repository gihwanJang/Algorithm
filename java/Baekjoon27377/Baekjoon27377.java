import java.io.*;
import java.util.*;
import java.math.*;

class Problem {
    long n;
    String s, t;

    public Problem(long n, String s, String t) {
        this.n = n;
        this.s = s;
        this.t = t;
    }

    public BigInteger solve() {
        BigInteger time = new BigInteger("0");
        while(n > 0) {
            if(n%2 == 1) {
                n -= 1;
                time = time.add(new BigInteger(s));
            } else {
                n /= 2;
                time = time.add(new BigInteger(String.valueOf(n)).multiply(new BigInteger(s)).min(new BigInteger(t)));
            }
        }
        return time;
    }
}

public class Baekjoon27377 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; ++i) {
            long n = Long.parseLong(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Problem problem = new Problem(n, st.nextToken(), st.nextToken());
            sb.append(problem.solve()).append("\n");
        }

        System.out.print(sb.toString());
    }
}
