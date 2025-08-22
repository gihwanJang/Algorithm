import java.io.*;
import java.math.*;
import java.util.*;

class Problem {
    BigInteger a, b;

    public Problem(String a, String b) {
        this.a = new BigInteger(a);
        this.b = new BigInteger(b);
    }

    public BigInteger solve() {
        return a.add(b);
    }
}

public class Baekjoon15740 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem problem = new Problem(st.nextToken(), st.nextToken());
        System.out.println(problem.solve());
    }
}
